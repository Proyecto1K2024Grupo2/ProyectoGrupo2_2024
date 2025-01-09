# ProyectoGrupo2_2024

## Miembros
[**Juan Carlos Garcia Andreu**](https://github.com/JuanCarlosgarcia86) \
[**Martin Davia Mora**](https://github.com/Apolonelche) \
[**Raul Quilez Ruiz**](https://github.com/Quilez42) \
[**Rubén Expósito Vicente**](https://github.com/Rebirzt)

## Indice De Contenidos
### [Modelo Logico](https://github.com/Proyecto1K2024Grupo2/ProyectoGrupo2_2024/blob/main/Modelo%20Logico.md)
### [Modelo Fisico](https://github.com/Proyecto1K2024Grupo2/ProyectoGrupo2_2024/blob/main/Modelo%20Logico.md)

## Instrucciones DDL

```sql
CREATE TABLE empleado(
    dni VARCHAR(9),
    nombre VARCHAR(64),
    telefono INT,
    numcuenta VARCHAR(22),
    sueldo DECIMAL(11, 2),
    PRIMARY KEY (dni)
);

CREATE TABLE recepcionista(
    dni VARCHAR(9),  
    CONSTRAINT PK_Recepcionista PRIMARY KEY(dni),
    CONSTRAINT fk_dnirecepcionista FOREIGN KEY (dni) REFERENCES empleado(dni) 
        ON DELETE NO ACTION 
        ON UPDATE CASCADE
);

CREATE TABLE veterinario(
    dni VARCHAR(9),
    PRIMARY KEY(dni),
    CONSTRAINT fk_dniveterinario FOREIGN KEY (dni) REFERENCES empleado(dni) 
        ON UPDATE CASCADE 
        ON DELETE NO ACTION
);

CREATE TABLE cirujano(
    dni VARCHAR(9),
    PRIMARY KEY (dni),
    CONSTRAINT fk_dnicirujano FOREIGN KEY (dni) REFERENCES empleado(dni)
        ON UPDATE CASCADE
        ON DELETE NO ACTION
);

CREATE TABLE cuidador(
    dni VARCHAR(9),
    PRIMARY KEY (dni),
    CONSTRAINT fk_dnicuidador FOREIGN KEY (dni) REFERENCES empleado(dni)
        ON UPDATE CASCADE
        ON DELETE NO ACTION
);

CREATE TABLE centro(
    cod INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(64),
    direccion VARCHAR(64),
    cp VARCHAR(10),
    PRIMARY KEY (cod)
);

CREATE TABLE trabajar(
    dniEmpleado VARCHAR(9),
    codCentro INT UNSIGNED,
    CONSTRAINT fk_dniempleado FOREIGN KEY (dniEmpleado) REFERENCES empleado(dni)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_codcentro FOREIGN KEY (codCentro) REFERENCES centro(cod)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    PRIMARY KEY (dniEmpleado, codCentro)
);

CREATE TABLE tratamiento(
    id INT UNSIGNED AUTO_INCREMENT,
    tratamiento TEXT,
    medicamento VARCHAR(64),
    posologia VARCHAR(64),
    fechaCuidador DATE,
    horaCuidador TIME,
    fechaVeterinario DATE,
    horaVeterinario TIME,
    fechaCirujano DATE,
    horaCirujano TIME,
    dni_veterinario VARCHAR(9),
    dni_cirujano VARCHAR(9),
    dni_cuidador VARCHAR(9),
    PRIMARY KEY (id),
    CONSTRAINT fk_dniveterinariotr FOREIGN KEY (dni_veterinario) REFERENCES veterinario(dni)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_dnicirujanotr FOREIGN KEY (dni_cirujano) REFERENCES cirujano(dni)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_dnicuidadortr FOREIGN KEY (dni_cuidador) REFERENCES cuidador(dni)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE sala(
    nombre VARCHAR(32),
    cod_centro INT UNSIGNED,
    CONSTRAINT fk_cod_centro FOREIGN KEY (cod_Centro) REFERENCES centro(cod)
        ON UPDATE NO ACTION
        ON DELETE no action,
    PRIMARY KEY(nombre)
);

CREATE TABLE cita(
    id INT UNSIGNED AUTO_INCREMENT,
    nombre_sala VARCHAR(32),
    fecha DATE,
    hora TIME,
    dniRecepcionista VARCHAR(9),
    CONSTRAINT fk_nombreSala FOREIGN KEY (nombre_sala) REFERENCES sala(nombre)
        ON UPDATE no action
        ON DELETE no action,
    CONSTRAINT fk_dnirecepcionista_cita FOREIGN KEY (dniRecepcionista) REFERENCES recepcionista(dni)
        ON UPDATE no action
        ON DELETE no action,
    PRIMARY KEY(id)
);

CREATE TABLE cliente(
    dni VARCHAR(9),
    nombre VARCHAR(64),
    PRIMARY KEY(dni)
);

CREATE TABLE animal(
    id INT UNSIGNED AUTO_INCREMENT,
    dni_cliente VARCHAR(9),
    nombre VARCHAR(64),
    especie VARCHAR(32),
    raza VARCHAR(32),
    fnac DATE,
    CONSTRAINT fk_dniCliente FOREIGN KEY (dni_cliente) REFERENCES cliente(dni)
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    PRIMARY KEY(id)
);

CREATE TABLE telefono(
    telefono INT(9),
    dniCliente VARCHAR(9),
    CONSTRAINT fk_dniClienteTel FOREIGN KEY (dniCliente) REFERENCES cliente(dni)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    PRIMARY KEY (telefono)
);

CREATE TABLE historial(
    id_cita INT UNSIGNED, 
    id_animal INT UNSIGNED,
    id_tratamiento INT UNSIGNED,
    CONSTRAINT fk_idCita FOREIGN KEY (id_cita) REFERENCES cita(id)
        ON UPDATE no action
        ON DELETE no action,
    CONSTRAINT fk_idAnimal FOREIGN KEY (id_animal) REFERENCES animal(id)
        ON UPDATE no action
        ON DELETE no action,
    CONSTRAINT fk_idTratamie nto FOREIGN KEY (id_tratamiento) REFERENCES tratamiento(id)
        ON UPDATE no action
        ON DELETE no action,
    PRIMARY KEY (id_cita, id_animal, id_tratamiento)
);

```

## Instrucciones DML

```sql
/*TABLA EMPLEADO*/
INSERT INTO empleado (dni, nombre, telefono, numcuenta, sueldo) VALUES
('12345678A', 'Juan Pérez', 600123456, 'ES12345678901234567890', 2000.00),
('12345678B', 'María López', 600234567, 'ES12345678901234567891', 2200.00),
('12345678C', 'Pedro González', 600345678, 'ES12345678901234567892', 2500.00),
('12345678D', 'Ana Martín', 600456789, 'ES12345678901234567893', 2300.00),
('12345678E', 'Luis García', 600567890, 'ES12345678901234567894', 2100.00),
('12345678F', 'Laura Sánchez', 600678901, 'ES12345678901234567895', 2400.00),
('12345678G', 'Carlos Díaz', 600789012, 'ES12345678901234567896', 2600.00),
('12345678H', 'Paula Fernández', 600890123, 'ES12345678901234567897', 2800.00),
('12345678I', 'Andrés Jiménez', 600901234, 'ES12345678901234567898', 2700.00),
('12345678J', 'Marta Ruiz', 601012345, 'ES12345678901234567899', 2900.00),
('12345678K', 'David Herrera', 601123456, 'ES12345678901234567800', 2000.00),
('12345678L', 'Sofía Gómez', 601234567, 'ES12345678901234567801', 2500.00),
('12345678M', 'Hugo Ramírez', 601345678, 'ES12345678901234567802', 2400.00),
('12345678N', 'Valeria Torres', 601456789, 'ES12345678901234567803', 2200.00),
('12345678O', 'Pablo Castro', 601567890, 'ES12345678901234567804', 2300.00),
('12345678P', 'Elena Peña', 601678901, 'ES12345678901234567805', 2600.00),
('12345678Q', 'Sergio Morales', 601789012, 'ES12345678901234567806', 2800.00),
('12345678R', 'Claudia Vega', 601890123, 'ES12345678901234567807', 2700.00),
('12345678S', 'Manuel Ortega', 601901234, 'ES12345678901234567808', 2900.00),
('12345678T', 'Victoria León', 602012345, 'ES12345678901234567809', 2000.00),
('12345679A', 'Laura Sánchez', 612345678, 'ES12345678901234567890', 1800.00),
('12345680B', 'Carlos Martínez', 623456789, 'ES12345678901234567891', 2000.00),
('12345681C', 'Ana Gómez', 634567890, 'ES12345678901234567892', 1700.00),
('12345682D', 'Miguel Rodríguez', 645678901, 'ES12345678901234567893', 2200.00),
('12345683E', 'Elena Fernández', 656789012, 'ES12345678901234567894', 2100.00),
('12345684F', 'Javier Pérez', 667890123, 'ES12345678901234567895', 2500.00),
('12345685G', 'Lucía Díaz', 678901234, 'ES12345678901234567896', 1600.00),
('12345686H', 'Antonio López', 689012345, 'ES12345678901234567897', 2400.00),
('12345687I', 'María Rodríguez', 690123456, 'ES12345678901234567898', 2200.00),
('12345688J', 'Juan Pérez', 701234567, 'ES12345678901234567899', 2300.00),
('12345689K', 'Raquel Martín', 712345678, 'ES12345678901234567900', 1800.00),
('12345690L', 'Pedro Sánchez', 723456789, 'ES12345678901234567901', 2000.00),
('12345691M', 'Isabel Hernández', 734567890, 'ES12345678901234567902', 1900.00),
('12345692N', 'Sergio García', 745678901, 'ES12345678901234567903', 2100.00),
('12345693O', 'Beatriz López', 756789012, 'ES12345678901234567904', 2400.00),
('12345694P', 'David Romero', 767890123, 'ES12345678901234567905', 2300.00),
('12345695Q', 'Raúl Sánchez', 778901234, 'ES12345678901234567906', 2200.00),
('12345696R', 'Carmen García', 789012345, 'ES12345678901234567907', 2500.00),
('12345697S', 'José Pérez', 790123456, 'ES12345678901234567908', 2700.00),
('12345698T', 'Cristina Martínez', 801234567, 'ES12345678901234567909', 2800.00);


/*TABLA RECEPCIONISTA*/
INSERT INTO recepcionista (dni) VALUES
('12345678A'), 
('12345678B'), 
('12345678C'), 
('12345678D'), 
('12345678E'), 
('12345679A'),
('12345680B'),
('12345681C'),
('12345682D'),
('12345683E');


/* TABLA VETERINARIO*/
INSERT INTO veterinario (dni) VALUES
('12345678F'), 
('12345678G'), 
('12345678H'), 
('12345678I'), 
('12345678J'),
('12345684F'),
('12345685G'),
('12345686H'),
('12345687I'),
('12345688J');



/*TABLA CIRUJANO*/
INSERT INTO cirujano (dni) VALUES
('12345678K'), 
('12345678L'), 
('12345678M'), 
('12345678N'), 
('12345678O'),
('12345689K'),
('12345690L'),
('12345691M'),
('12345692N'),
('12345693O');


/*TABLA CUIDADOR*/
INSERT INTO cuidador (dni) VALUES
('12345678P'), 
('12345678Q'), 
('12345678R'), 
('12345678S'), 
('12345678T'),
('12345694P'),
('12345695Q'),
('12345696R'),
('12345697S'),
('12345698T');


/*TABLA CENTRO*/
INSERT INTO centro (nombre, direccion, cp) VALUES
('Centro Norte', 'Calle Norte, 1', '28001'),
('Centro Sur', 'Calle Sur, 2', '28002'),
('Centro Este', 'Calle Este, 3', '28003'),
('Centro Oeste', 'Calle Oeste, 4', '28004'),
('Centro Central', 'Calle Central, 5', '28005');


/*TABLA TRABAJAR*/
INSERT INTO trabajar (dniEmpleado, codCentro) VALUES
('12345678A', 1), ('12345678B', 2), ('12345678C', 3), ('12345678D', 4), ('12345678E', 5),
('12345678F', 1), ('12345678G', 2), ('12345678H', 3), ('12345678I', 4), ('12345678J', 5),
('12345678K', 1), ('12345678L', 2), ('12345678M', 3), ('12345678N', 4), ('12345678O', 5),
('12345678P', 1), ('12345678Q', 2), ('12345678R', 3), ('12345678S', 4), ('12345678T', 5),
('12345679A', 1), ('12345680B', 1), ('12345681C', 2), ('12345682D', 2), ('12345683E', 3),
('12345684F', 1), ('12345685G', 1), ('12345686H', 2), ('12345687I', 2), ('12345688J', 3),
('12345689K', 1), ('12345690L', 1), ('12345691M', 2), ('12345692N', 2), ('12345693O', 3),
('12345694P', 1), ('12345695Q', 1), ('12345696R', 2), ('12345697S', 2), ('12345698T', 3);


/*TABLA SALA*/
INSERT INTO sala (nombre, cod_centro) VALUES
('Sala 1', 1), 
('Sala 2', 2), 
('Sala 3', 3), 
('Sala 4', 4), 
('Sala 5', 5), 
('Sala 6', 1),
('Sala 7', 1),
('Sala 8', 2),
('Sala 9', 2),
('Sala 10', 3),
('Sala 11', 3);

/*TABLA CITA*/
INSERT INTO cita (nombre_sala, fecha, hora, dniRecepcionista) VALUES
('Sala 1', '2024-01-10', '10:00:00', '12345678A'),
('Sala 2', '2024-01-11', '11:00:00', '12345678B'),
('Sala 3', '2024-01-12', '12:00:00', '12345678C'),
('Sala 4', '2024-01-13', '13:00:00', '12345678D'),
('Sala 5', '2024-01-14', '14:00:00', '12345678E'),
('Sala 1', '2024-05-01', '09:00:00', '12345678A'),
('Sala 2', '2024-05-02', '10:00:00', '12345678B'),
('Sala 3', '2024-05-03', '11:00:00', '12345678C'),
('Sala 4', '2024-05-04', '12:00:00', '12345678D'),
('Sala 5', '2024-05-05', '13:00:00', '12345678E'),
('Sala 6', '2024-05-06', '14:00:00', '12345679A'),
('Sala 7', '2024-05-07', '15:00:00', '12345680B'),
('Sala 8', '2024-05-08', '16:00:00', '12345681C'),
('Sala 9', '2024-05-09', '17:00:00', '12345682D'),
('Sala 10', '2024-05-10', '18:00:00', '12345683E'),
('Sala 11', '2024-05-11', '09:30:00', '12345678A'),
('Sala 1', '2024-05-12', '10:30:00', '12345678B'),
('Sala 2', '2024-05-13', '11:30:00', '12345678C'),
('Sala 3', '2024-05-14', '12:30:00', '12345678D'),
('Sala 4', '2024-05-15', '13:30:00', '12345678E');



/*TABLA CLIENTE*/
INSERT INTO cliente (dni, nombre) VALUES
('11111111A', 'Carlos Pérez'),
('11111111B', 'Laura Gómez'),
('11111111C', 'Hugo López'),
('11111111D', 'Elena Martín'),
('11111111E', 'Pablo Díaz'),
('11111111F', 'Sofía Ramírez'),
('11111111G', 'Andrés Torres'),
('11111111H', 'Claudia Vega'),
('11111111I', 'Manuel Ortega'),
('11111111J', 'Victoria León'),
('11111111K', 'Lucas Herrera'),
('11111111L', 'Isabel Peña'),
('11111111M', 'Javier Morales'),
('11111111N', 'Marina Castro'),
('11111111O', 'Alejandro Ruiz'),
('11111111P', 'Nerea Fernández'),
('11111111Q', 'Diego García'),
('11111111R', 'Carolina Gómez'),
('11111111S', 'Fernando Pérez'),
('11111111T', 'Natalia Sánchez');


/*TABLA ANIMAL*/
INSERT INTO animal (dni_cliente, nombre, especie, raza, fnac) VALUES
('11111111A', 'Max', 'Perro', 'Labrador', '2020-05-15'),
('11111111B', 'Mia', 'Gato', 'Siames', '2021-11-03'),
('11111111C', 'Rocky', 'Perro', 'Bulldog', '2019-08-22'),
('11111111D', 'Luna', 'Gato', 'Persa', '2022-04-10'),
('11111111E', 'Charlie', 'Conejo', 'Enano', '2018-12-25'),
('11111111F', 'Toby', 'Perro', NULL, '2019-07-14'),
('11111111G', 'Nala', 'Gato', 'Bengala', '2021-03-30'),
('11111111H', 'Simba', 'Perro', NULL, '2020-01-20'),
('11111111I', 'Daisy', 'Gato', 'Angora', '2021-09-15'),
('11111111J', 'Bella', 'Conejo', 'Enano', '2020-06-11'),
('11111111K', 'Max', 'Perro', 'Boxer', '2017-02-18'),
('11111111L', 'Lola', 'Gato', NULL, '2019-10-05'),
('11111111M', 'Rocky', 'Perro', 'Husky', '2020-11-27'),
('11111111N', 'Luna', 'Gato', 'Persa', '2021-05-08'),
('11111111O', 'Charlie', 'Pájaro', NULL, '2022-12-02'),
('11111111P', 'Coco', 'Pájaro', 'Loro', '2021-07-09'),
('11111111Q', 'Milo', 'Perro', NULL, '2020-03-25'),
('11111111R', 'Kira', 'Gato', 'Europeo', '2020-10-13'),
('11111111S', 'Bruno', 'Perro', NULL, '2021-02-17'),
('11111111T', 'Mia', 'Conejo', NULL, '2022-06-30');


/*TABLA TELEFONO*/
INSERT INTO telefono (telefono, dniCliente) VALUES
(600111111, '11111111A'),
(600222222, '11111111B'),
(600333333, '11111111C'),
(600444444, '11111111D'),
(600555555, '11111111E'),
(600666666, '11111111F'),
(600777777, '11111111G'),
(600888888, '11111111H'),
(600999999, '11111111I'),
(601000000, '11111111J'),
(601111111, '11111111K'),
(601222222, '11111111L'),
(601333333, '11111111M'),
(601444444, '11111111N'),
(601555555, '11111111O'),
(601666666, '11111111P'),
(601777777, '11111111Q'),
(601888888, '11111111R'),
(601999999, '11111111S'),
(602000000, '11111111T');


/*TABLA TRATAMIENTO*/
INSERT INTO tratamiento (tratamiento, medicamento, posologia, fechaCuidador, horaCuidador, fechaVeterinario, horaVeterinario, fechaCirujano, horaCirujano, dni_veterinario, dni_cirujano, dni_cuidador) VALUES
('Chequeo anual', 'Vacuna A', 'Dosis única', NULL, NULL, '2024-02-16', '10:00:00', NULL, NULL, '12345678F', NULL, NULL),
('Desparasitación interna', 'Comprimido B', '1 comprimido mensual', NULL, NULL, '2024-02-17', '11:00:00', NULL, NULL, '12345678G', NULL, NULL),
('Consulta dermatológica', 'Crema X', 'Aplicar cada 8 horas', NULL, NULL, '2024-02-18', '12:00:00', NULL, NULL, '12345678H', NULL, NULL),
('Limpieza dental', 'Gel Y', 'Aplicar durante 5 minutos', '2024-02-19', '13:00:00', NULL, NULL, NULL, NULL, NULL, NULL, '12345678Q'),
('Baño con champú medicado', 'Champú Z', 'Aplicar y enjuagar', '2024-02-20', '14:00:00', NULL, NULL, NULL, NULL, NULL, NULL, '12345678R'),
('Administración de vitaminas', 'Vitamina D', '1 inyección semanal', '2024-02-21', '15:00:00', NULL, NULL, NULL, NULL, NULL, NULL, '12345678S'),
('Cirugía menor', 'Anestesia general', 'Una aplicación única', NULL, NULL, NULL, NULL, '2024-02-22', '16:00:00', NULL, '12345678K', NULL),
('Extirpación de quiste', 'Anestesia Z', 'Un procedimiento', NULL, NULL, NULL, NULL, '2024-02-23', '17:00:00', NULL, '12345678L', NULL),
('Cirugía dental', 'Anestesia local', '1 dosis', NULL, NULL, NULL, NULL, '2024-02-24', '18:00:00', NULL, '12345678M', NULL),
('Chequeo cardiológico', 'Medicamento X', '1 pastilla diaria', NULL, NULL, '2024-02-25', '10:00:00', NULL, NULL, '12345678F', NULL, NULL),
('Administración de medicamentos', 'Antibiótico Y', 'Cada 12 horas', '2024-02-26', '11:00:00', NULL, NULL, NULL, NULL, NULL, NULL, '12345678Q'),
('Consulta digestiva', 'Suplemento Z', 'Durante 7 días', NULL, NULL, '2024-02-27', '12:00:00', NULL, NULL, '12345678G', NULL, NULL),
('Baño medicado', 'Solución Y', 'Aplicar y enjuagar', '2024-02-28', '13:00:00', NULL, NULL, NULL, NULL, NULL, NULL, '12345678R'),
('Cirugía mayor', 'Anestesia general', 'Un procedimiento', NULL, NULL, NULL, NULL, '2024-02-29', '14:00:00', NULL, '12345678L', NULL),
('Desparasitación externa', 'Pipeta A', 'Una dosis', NULL, NULL, '2024-03-01', '15:00:00', NULL, NULL, '12345678H', NULL, NULL),
('Chequeo general', 'Suplemento A', '1 pastilla diaria', NULL, NULL, '2024-03-02', '09:00:00', NULL, NULL, '12345678F', NULL, NULL),
('Aplicación de pomada', 'Pomada B', 'Aplicar 3 veces al día', '2024-03-03', '10:00:00', NULL, NULL, NULL, NULL, NULL, NULL, '12345678R'),
('Cirugía ortopédica', 'Anestesia general', 'Procedimiento único', NULL, NULL, NULL, NULL, '2024-03-04', '11:00:00', NULL, '12345678K', NULL);

/*TABLA HISTORIAL*/
INSERT INTO historial (id_cita, id_animal, id_tratamiento) VALUES
(1, 1, 1), (2, 2, 2), (3, 3, 3), (4, 4, 4), (5, 5, 5), (6, 6, 6), (7, 7, 7), (8, 8, 8), (9, 9, 9), (10, 10, 10), 
(11, 1, 11), (12, 2, 12), (13, 3, 13), (14, 4, 14), (15, 5, 15);
```

## Posibes consultas para la BD
```sql
-- 1. Devuelveme el nombre de empledado y sus numero de telefono.
SELECT nombre,telefono from empleado;
+--------------------+-----------+
| nombre             | telefono  |
+--------------------+-----------+
| Juan Pérez         | 600123456 |
| María López        | 600234567 |
...
| Cristina Martínez  | 801234567 |
+--------------------+-----------+
40 rows in set (0.005 sec)

-- 2. Calcular el sueldo promedio de los empleados:
SELECT AVG(sueldo) AS sueldo_promedio FROM empleado;
+-----------------+
| sueldo_promedio |
+-----------------+
|     2310.000000 |
+-----------------+
1 row in set (0.029 sec)

-- 3. Lista el nombre y el DNI de los clientes cuyo nombre sea Hugo.
SELECT dni, nombre FROM cliente WHERE nombre LIKE '%Hugo%';
+-----------+-------------+
| dni       | nombre      |
+-----------+-------------+
| 11111111C | Hugo López  |
+-----------+-------------+
1 row in set (0.002 sec)

-- 4. devuelveme el nombre de los empleados recepcionuistas y su dni.
SELECT e.nombre, e.dni FROM empleado e JOIN recepcionista r ON e.dni = r.dni;
+-------------------+-----------+
| nombre            | dni       |
+-------------------+-----------+
| Juan Pérez        | 12345678A |
| María López       | 12345678B |
| Pedro González    | 12345678C |
| Ana Martín        | 12345678D |
| Luis García       | 12345678E |
| Laura Sánchez     | 12345679A |
| Carlos Martínez   | 12345680B |
| Ana Gómez         | 12345681C |
| Miguel Rodríguez  | 12345682D |
| Elena Fernández   | 12345683E |
+-------------------+-----------+
10 rows in set (0.004 sec)

-- 5. Muestra cuantas citas han habido en el mes de Enero
SELECT COUNT(*) AS total_citas_diciembre FROM cita WHERE MONTH(fecha) = 1;
+-----------------------+
| total_citas_diciembre |
+-----------------------+
|                     5 |
+-----------------------+
1 row in set (0.005 sec)

-- 6. Devuelveme los veterinarios que trabajan en el centro 3.
SELECT e.nombre, e.dni FROM empleado e JOIN veterinario v ON e.dni = v.dni JOIN trabajar t ON e.dni = t.dniEmpleado WHERE t.codCentro = 3;
+------------------+-----------+
| nombre           | dni       |
+------------------+-----------+
| Paula Fernández  | 12345678H |
| Juan Pérez       | 12345688J |
+------------------+-----------+
2 rows in set (0.005 sec)

-- 7. Mostrar todas las salas ordenadas por el nombre del centro asociado:
SELECT s.nombre AS sala, c.nombre AS centro FROM sala s
JOIN centro c ON s.cod_centro = c.cod
ORDER BY c.nombre;
+---------+----------------+
| sala    | centro         |
+---------+----------------+
| Sala 5  | Centro Central |
| Sala 10 | Centro Este    |
| Sala 11 | Centro Este    |
| Sala 3  | Centro Este    |
| Sala 1  | Centro Norte   |
| Sala 6  | Centro Norte   |
| Sala 7  | Centro Norte   |
| Sala 4  | Centro Oeste   |
| Sala 2  | Centro Sur     |
| Sala 8  | Centro Sur     |
| Sala 9  | Centro Sur     |
+---------+----------------+
11 rows in set (0.003 sec)

-- 8. Listar cuantos empleado trabajan en cada centro.
SELECT c.nombre AS nombre_centro, c.cod AS codigo_centro, COUNT(t.dniEmpleado) AS numero_empleados FROM centro c
LEFT JOIN trabajar t ON c.cod = t.codCentro
GROUP BY c.cod, c.nombre
ORDER BY numero_empleados DESC;
+----------------+---------------+------------------+
| nombre_centro  | codigo_centro | numero_empleados |
+----------------+---------------+------------------+
| Centro Norte   |             1 |               12 |
| Centro Sur     |             2 |               12 |
| Centro Este    |             3 |                8 |
| Centro Oeste   |             4 |                4 |
| Centro Central |             5 |                4 |
+----------------+---------------+------------------+
5 rows in set (0.004 sec)

-- 9.Muestra los clientes que han tenido cita el mes de Enero
SELECT DISTINCT cl.*
FROM cliente cl
JOIN animal an ON cl.dni = an.dni_cliente
JOIN historial hi ON hi.id_animal = an.id
JOIN cita ci ON ci.id = hi.id_cita
WHERE MONTH(ci.fecha) = 1;
+-----------+---------------+
| dni       | nombre        |
+-----------+---------------+
| 11111111A | Carlos Pérez  |
| 11111111B | Laura Gómez   |
| 11111111C | Hugo López    |
| 11111111D | Elena Martín  |
| 11111111E | Pablo Díaz    |
+-----------+---------------+
5 rows in set (0.011 sec)

-- 10. Mostrar tratamientos realizados por un veterinario Laura
SELECT t.id AS id_tratamiento, t.tratamiento, t.medicamento, t.posologia, t.fechaVeterinario, t.horaVeterinario, e.nombre AS nombre_veterinario
FROM tratamiento t
JOIN veterinario v ON t.dni_veterinario = v.dni
JOIN empleado e ON v.dni = e.dni
WHERE e.nombre = 'Laura Sanchez'
ORDER BY t.fechaVeterinario DESC, t.horaVeterinario DESC;
+----------------+-----------------------+---------------+-------------------+------------------+-----------------+--------------------+
| id_tratamiento | tratamiento           | medicamento   | posologia         | fechaVeterinario | horaVeterinario | nombre_veterinario |
+----------------+-----------------------+---------------+-------------------+------------------+-----------------+--------------------+
|             16 | Chequeo general       | Suplemento A  | 1 pastilla diaria | 2024-03-02       | 09:00:00        | Laura Sánchez      |
|             10 | Chequeo cardiológico  | Medicamento X | 1 pastilla diaria | 2024-02-25       | 10:00:00        | Laura Sánchez      |
|              1 | Chequeo anual         | Vacuna A      | Dosis única       | 2024-02-16       | 10:00:00        | Laura Sánchez      |
+----------------+-----------------------+---------------+-------------------+------------------+-----------------+--------------------+
3 rows in set (0.010 sec)

```
## Reparto De Trabajo
Creación de tablas y comprobación: Martin, [Juan Carlos, Raul, Rubén]\
Creación y comprobación de restricciones: [Martín, Raul]\
Inserción y comprobación de datos: Rubén, [Juan Carlos]\

### Creacion y comprobacion de consultas:\
  Consultas 1,3 y 7 [Juan Carlos]\
  Consutas 2,6 y 8 [Rubén]\
  Consultas 4 y 9 [Martin]\
  Consultas 5 y 10 [Raul]
