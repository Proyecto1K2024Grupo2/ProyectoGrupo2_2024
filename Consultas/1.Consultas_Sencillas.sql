-- SQLBook: Code


-- PY615. (RABD.3 // CE3a, CE3b, CE3c, CE3d // 10p) A partir del modelo físico creado en la actividad PY515 del Reto II - Creamos, en esta actividad nos vamos a centrar en definir una serie de consultas para explotar nuestra base de datos.

-- Para ello, se pide un informe que detalle:

-- Definición de 10 consultas que extraigan información, las cuales deben utilizar combinaciones de tablas (tanto internas como externas), filtrado, ordenación y cálculos sencillos.
-- Resolución mediante SQL de cada una de las consultas.
-- Resultados de su ejecución sobre el modelo físico.
-- Se utilizará una rúbrica para su evaluación en base a la siguiente lista de cotejo:

-- Limpieza y calidad de las consultas.
-- Variedad de consultas, desde consultas sencilla a más complejas.
-- Documentación de las consultas.
-- El informe entregado no contiene faltas de ortografía.
-- El informe entregado tiene un formato adecuado (portada, apartados, autores, etc...).
-- El informe debe indicar cómo se han repartido las tareas y qué ha realizado cada alumno/a.


-- 1. Devuelve los clientes que tienen perro.
Select c.dni, c.nombre
 from cliente c
 join animal a on c.dni=a.dni_cliente
 where a.especie='Perro';

-- +-----------+-----------------+
-- | dni       | nombre          |
-- +-----------+-----------------+
-- | 11111111A | Carlos Pérez    |
-- | 11111111C | Hugo López      |
-- | 11111111F | Sofía Ramírez   |
-- | 11111111H | Claudia Vega    |
-- | 11111111K | Lucas Herrera   |
-- | 11111111M | Javier Morales  |
-- | 11111111Q | Diego García    |
-- | 11111111S | Fernando Pérez  |
-- +-----------+-----------------+

-- 2. Calcular el sueldo promedio de los cirujanos.
SELECT AVG(e.sueldo) 
 FROM empleado e
 JOIN cirujano c on e.dni=c.dni;

-- +---------------+
-- | AVG(e.sueldo) |
-- +---------------+
-- |   2160.000000 |
-- +---------------+

-- 3. Lista los animales que no tienen dueño.

SELECT a.id, a.nombre, a.especie 
 FROM animal a
 LEFT JOIN cliente c on a.dni_cliente=c.dni
 WHERE c.dni is null;

-- Empty set (0.001 sec)

-- 4. Devuelve el nombre, la cuenta bancaria y el sueldo de los recepcionistas.
SELECT e.nombre, e.numcuenta, e.sueldo 
 FROM empleado e 
 JOIN recepcionista r ON e.dni = r.dni;

-- +-------------------+------------------------+---------+
-- | nombre            | numcuenta              | sueldo  |
-- +-------------------+------------------------+---------+
-- | Juan Pérez        | ES12345678901234567890 | 2000.00 |
-- | María López       | ES12345678901234567891 | 2200.00 |
-- | Pedro González    | ES12345678901234567892 | 2500.00 |
-- | Ana Martín        | ES12345678901234567893 | 2300.00 |
-- | Luis García       | ES12345678901234567894 | 2100.00 |
-- | Laura Sánchez     | ES12345678901234567890 | 1800.00 |
-- | Carlos Martínez   | ES12345678901234567891 | 2000.00 |
-- | Ana Gómez         | ES12345678901234567892 | 1700.00 |
-- | Miguel Rodríguez  | ES12345678901234567893 | 2200.00 |
-- | Elena Fernández   | ES12345678901234567894 | 2100.00 |
-- +-------------------+------------------------+---------+
 
-- 5. Muestra cuantas citas han sido asignadas para enero.
SELECT COUNT(*) AS total_citas_diciembre 
 FROM cita 
 WHERE MONTH(fecha) = 1;
 -- +-----------------------+
 -- | total_citas_diciembre |
 -- +-----------------------+
 -- |                     5 |
 -- +-----------------------+
 -- 1 row in set (0.005 sec)

-- 6. Devuelve los veterinarios que trabajan en el centro 3.
SELECT e.nombre, e.dni 
 FROM empleado e 
 JOIN veterinario v ON e.dni = v.dni 
 JOIN trabajar t ON e.dni = t.dniEmpleado 
 WHERE t.codCentro = 3;
 -- +------------------+-----------+
 -- | nombre           | dni       |
 -- +------------------+-----------+
 -- | Paula Fernández  | 12345678H |
 -- | Juan Pérez       | 12345688J |
 -- +------------------+-----------+
 -- 2 rows in set (0.005 sec)

-- 7. Muestra todas las salas ordenadas por centros.
SELECT s.nombre AS sala, c.nombre AS centro FROM sala s
JOIN centro c ON s.cod_centro = c.cod
ORDER BY c.nombre;
 -- +---------+----------------+
 -- | sala    | centro         |
 -- +---------+----------------+
 -- | Sala 5  | Centro Central |
 -- | Sala 10 | Centro Este    |
 -- | Sala 11 | Centro Este    |
 -- | Sala 3  | Centro Este    |
 -- | Sala 1  | Centro Norte   |
 -- | Sala 6  | Centro Norte   |
 -- | Sala 7  | Centro Norte   |
 -- | Sala 4  | Centro Oeste   |
 -- | Sala 2  | Centro Sur     |
 -- | Sala 8  | Centro Sur     |
 -- | Sala 9  | Centro Sur     |
 -- +---------+----------------+
 -- 11 rows in set (0.003 sec)

-- 8. Lista cuantos empleados trabajan en cada centro.
SELECT c.nombre AS nombre_centro, c.cod AS codigo_centro, COUNT(t.dniEmpleado) AS numero_empleados 
FROM centro c
LEFT JOIN trabajar t ON c.cod = t.codCentro
GROUP BY c.cod, c.nombre
ORDER BY numero_empleados DESC;
 -- +----------------+---------------+------------------+
 -- | nombre_centro  | codigo_centro | numero_empleados |
 -- +----------------+---------------+------------------+
 -- | Centro Norte   |             1 |               12 |
 -- | Centro Sur     |             2 |               12 |
 -- | Centro Este    |             3 |                8 |
 -- | Centro Oeste   |             4 |                4 |
 -- | Centro Central |             5 |                4 |
 -- +----------------+---------------+------------------+
 -- 5 rows in set (0.004 sec)

-- 9.Muestra los clientes que han tenido citas el mes de enero.
SELECT DISTINCT cl.*
FROM cliente cl
JOIN animal an ON cl.dni = an.dni_cliente
JOIN historial hi ON hi.id_animal = an.id
JOIN cita ci ON ci.id = hi.id_cita
WHERE MONTH(ci.fecha) = 1;
 -- +-----------+---------------+
 -- | dni       | nombre        |
 -- +-----------+---------------+
 -- | 11111111A | Carlos Pérez  |
 -- | 11111111B | Laura Gómez   |
 -- | 11111111C | Hugo López    |
 -- | 11111111D | Elena Martín  |
 -- | 11111111E | Pablo Díaz    |
 -- +-----------+---------------+
 -- 5 rows in set (0.011 sec)

-- 10. Muestra tratamientos realizados por un la veterinaria Laura Sánchez ordenados por más reciente.
SELECT t.id AS id_tratamiento, t.tratamiento, t.medicamento, t.posologia, t.fechaVeterinario, t.horaVeterinario, e.nombre AS nombre_veterinario
FROM tratamiento t
JOIN veterinario v ON t.dni_veterinario = v.dni
JOIN empleado e ON v.dni = e.dni
WHERE e.nombre = 'Laura Sanchez'
ORDER BY t.fechaVeterinario DESC, t.horaVeterinario DESC;
 -- +----------------+-----------------------+---------------+-------------------+------------------+-----------------+--------------------+
 -- | id_tratamiento | tratamiento           | medicamento   | posologia         | fechaVeterinario | horaVeterinario | nombre_veterinario |
 -- +----------------+-----------------------+---------------+-------------------+------------------+-----------------+--------------------+
 -- |             16 | Chequeo general       | Suplemento A  | 1 pastilla diaria | 2024-03-02       | 09:00:00        | Laura Sánchez      |
 -- |             10 | Chequeo cardiológico  | Medicamento X | 1 pastilla diaria | 2024-02-25       | 10:00:00        | Laura Sánchez      |
 -- |              1 | Chequeo anual         | Vacuna A      | Dosis única       | 2024-02-16       | 10:00:00        | Laura Sánchez      |
 -- +----------------+-----------------------+---------------+-------------------+------------------+-----------------+--------------------+
 -- 3 rows in set (0.010 sec)
