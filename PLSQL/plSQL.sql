--1. Definición de 2 eventos que automaticen tareas con diferente periodicidad
--1.1 Eliminar animales sin citas en 20 años o mas
DELIMITER //
CREATE EVENT limpieza_animales_inactivos
ON SCHEDULE EVERY 1 YEAR
STARTS CURRENT_TIMESTAMP + INTERVAL 1 YEAR
DO
BEGIN  
    DELETE FROM animal
    WHERE id IN (
        SELECT a.id
        FROM animal a
        LEFT JOIN historial h ON a.id = h.id_animal
        LEFT JOIN cita c ON h.id_cita = c.id
        GROUP BY a.id
        HAVING MAX(c.fecha) < DATE_SUB(CURDATE(), INTERVAL 20 YEAR) -- Hemos buscado una funcion para hacer el evento y hemos encontrado date_sub()
        OR MAX(c.fecha) IS NULL
    );
END 
//
DELIMITER ;

--1.2 Dos eventos, uno que sube un 10% el salario en navidad y otro que lo revierte en enero (IMPORTANTE no ejecutar los eventos por primera vez el mes de diciembre)
--Subir sueldo
DELIMITER //
CREATE EVENT aumento_navideno_salarios
ON SCHEDULE EVERY 1 YEAR
STARTS CONCAT(YEAR(CURDATE()), '-12-01 00:00:00')
DO
BEGIN
    -- Aplicar aumento del 10% directamente
    UPDATE empleado 
    SET sueldo = sueldo * 1.10;
    
    -- Registrar la acción (opcional)
    INSERT INTO log_eventos (fecha, evento)
    VALUES (NOW(), 'Aplicado aumento navideño del 10%');
END //
DELIMITER ;

--Revertir sueldo
DELIMITER //
CREATE EVENT reversion_aumento_navideno
ON SCHEDULE EVERY 1 YEAR
STARTS CONCAT(YEAR(CURDATE()) + 1, '-01-15 00:00:00')
DO
BEGIN
    -- Revertir el aumento del 10% (dividir entre 1.10)
    UPDATE empleado 
    SET sueldo = sueldo / 1.10;
    
    -- Registrar la acción (opcional)
    INSERT INTO log_eventos (fecha, evento)
    VALUES (NOW(), 'Revertido aumento navideño del 10%');
END //
DELIMITER ;

--2. Definición de 2 disparadores sobre operaciones asociadas al modelo de datos.
--2.1 Actualizar un salario que es menor al salario mínimo y subirlo al salario mínimo
DELIMITER //
CREATE TRIGGER validar_salario_minimo
BEFORE INSERT ON empleado
FOR EACH ROW
BEGIN
    IF NEW.sueldo < 950.00 THEN
        SET NEW.sueldo = 950
    END IF;
END 
//
DELIMITER ;

--2.2 Comprobar que el teléfono introducido es válido utilizando regex (que hemos dado en las demás asignaturas)
DELIMITER //
CREATE TRIGGER validar_formato_telefono
BEFORE INSERT ON empleado
FOR EACH ROW
BEGIN
    IF NEW.telefono NOT REGEXP '^[6-9][0-9]{8}$' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Formato de teléfono inválido. Tiene que ser un número de 9 dígitos que empieze con 6,7,8 o 9';
    END IF;
END //
DELIMITER ;

--3. Definición de 2 procedimientos almacenados que realicen más de una operación dentro de una transacción, haciendo una gestión adecuada de los errores, ya sea mediante señales o excepciones, y sus consiguientes manejadores.
-- 3.1 Procedimiento para cambiar un codigo de centro y actualizarlo en el resto de tablas.
DELIMITER //
CREATE PROCEDURE cambiar_codigo_centro(IN codigo_viejo INT, IN codigo_nuevo INT)
BEGIN
    DECLARE mensaje = VARCHAR(128);
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error al cambiar el código de centro';
    END;
    
    START TRANSACTION;

    IF (SELECT cod from centro WHERE cod = codigo_viejo)
    THEN
        SET mensaje = CONCAT("El centro ",codigo_viejo, " no existe.");
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = mensaje;
        ROLLBACK;
    END IF;

    UPDATE empleado SET codigo_centro = p_codigo_nuevo WHERE codigo_centro = codigo_viejo;
    UPDATE sala SET codCentro = codigo_nuevo WHERE codigo_centro = codigo_viejo;
    COMMIT;
END 
//
DELIMITER ;

-- 3.2 Contratar a un nuevo empleado
DELIMITER //
CREATE PROCEDURE contratar_empleado(
    IN p_dni VARCHAR(9),
    IN p_nombre VARCHAR(64),
    IN p_telefono INT,
    IN p_numcuenta VARCHAR(22),
    IN p_sueldo DECIMAL(11,2),
    IN p_tipo_empleado INT,
    IN p_cod_centro INT UNSIGNED
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;
    
    START TRANSACTION;
    
    INSERT INTO empleado(dni, nombre, telefono, numcuenta, sueldo) VALUES (p_dni, p_nombre, p_telefono, p_numcuenta, p_sueldo);
    
    CASE p_tipo_empleado
        WHEN 1 THEN INSERT INTO recepcionista(dni) VALUES (p_dni);
        WHEN 2 THEN INSERT INTO veterinario(dni) VALUES (p_dni);
        WHEN 3 THEN INSERT INTO cirujano(dni) VALUES (p_dni);
        WHEN 4 THEN INSERT INTO cuidador(dni) VALUES (p_dni);
        ELSE 
            ROLLBACK;
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tipo de empleado inválido';
    END CASE;
    
    INSERT INTO trabajar(dniEmpleado, codCentro) VALUES (p_dni, p_cod_centro);
    
    COMMIT;
END 
//
DELIMITER ;

--4.Definición de 2 procedimientos almacenados que utilicen cursores que recorran cierta cantidad de datos, realizando operaciones sobre una o más tablas, haciendo una gestión adecuada de los errores, ya sea mediante señales o excepciones, y sus consiguientes manejadores.
-- 4.1 Aumentar el salario por centro
DELIMITER //
CREATE PROCEDURE aumento_salarial_centro(IN p_cod_centro INT UNSIGNED, IN p_porcentaje DECIMAL(5,2), OUT p_resultado INT)
BEGIN
    DECLARE v_dni VARCHAR(9);
    DECLARE v_sueldo DECIMAL(11,2);
    DECLARE salir BOOLEAN DEFAULT FALSE;
    
    DECLARE cur CURSOR FOR 
        SELECT e.dni, e.sueldo 
        FROM empleado e
        JOIN trabajar t ON e.dni = t.dniEmpleado
        WHERE t.codCentro = p_cod_centro;
        
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET salir = TRUE;
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_resultado = 0;
    END;
    
    SET p_resultado = 0; 
    
    OPEN cur;
    START TRANSACTION;
    
    WHILE (NOT salir) 
    DO
        FETCH cur INTO v_dni, v_sueldo;
        
        IF (NOT salir) 
        THEN
            SET p_resultado = 1;
            
            UPDATE empleado 
            SET sueldo = v_sueldo * (1 + p_porcentaje/100)
            WHERE dni = v_dni;
        END IF;
    END WHILE;
        
    IF (p_resultado = 1) 
    THEN
        COMMIT;
    ELSE
        ROLLBACK;
        SELECT CONCAT("No se encontraron empleados en el centro ", p_cod_centro) AS mensaje;
    END IF;

    CLOSE cur;
END 
//
DELIMITER ;

--4.2 Aumento general de sueldo indicado
DELIMITER //
CREATE PROCEDURE aumentar_sueldos_general(IN aumento DECIMAL(11,2))
BEGIN
    DECLARE e_dni VARCHAR(9);
    DECLARE e_fin BOOLEAN DEFAULT FALSE;
    
    DECLARE cur_empleados CURSOR FOR SELECT dni, sueldo FROM empleado;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET e_fin = TRUE;
    
    OPEN cur_empleados;
    
    WHILE e_fin
    DO
        FETCH cur_empleados INTO e_dni, e_sueldo;
     
        UPDATE empleado 
        SET sueldo = e_sueldo * aumento
        WHERE dni = e_dni;
    END WHILE;
    
    CLOSE cur_empleados;
END 
//
DELIMITER ;