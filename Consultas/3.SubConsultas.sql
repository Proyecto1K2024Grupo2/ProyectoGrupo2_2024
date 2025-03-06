-- 1. Definición de 5 consultas con subconsultas (escalares, de fila y de tabla) 
  -- Consulta escalar: Obtener el sueldo máximo de los empleados  
  SELECT nombre, sueldo  FROM empleado 
  WHERE sueldo = (SELECT MAX(sueldo) FROM empleado); 
  
  --+---------------+---------+
  --| nombre        | sueldo  |
  --+---------------+---------+
  --| Marta Ruiz    | 2900.00 |
  --| Manuel Ortega | 2900.00 |
  --+---------------+---------+
  --2 rows in set (0.002 sec)
  
  
  -- Consulta de fila: Obtener el empleado con el sueldo mínimo  
  SELECT * FROM empleado  
  WHERE sueldo = (SELECT MIN(sueldo) FROM empleado); 
  
  --+-----------+--------------+-----------+------------------------+---------+
  --| dni       | nombre       | telefono  | numcuenta              | sueldo  |
  --+-----------+--------------+-----------+------------------------+---------+
  --| 12345685G | Lucía Díaz   | 678901234 | ES12345678901234567896 | 1600.00 |
  --+-----------+--------------+-----------+------------------------+---------+
  --1 row in set (0.001 sec)
  
    
  -- Consulta de tabla: Listar los empleados que sean veterinarios 
  SELECT e.* FROM empleado e  
    WHERE e.dni IN ( SELECT dni  FROM veterinario); 
  
  --+-----------+-------------------+-----------+------------------------+---------+
  --| dni       | nombre            | telefono  | numcuenta              | sueldo  |
  --+-----------+-------------------+-----------+------------------------+---------+
  --| 12345678F | Laura Sánchez     | 600678901 | ES12345678901234567895 | 2400.00 |
  --| 12345678G | Carlos Díaz       | 600789012 | ES12345678901234567896 | 2600.00 |
  --| 12345678H | Paula Fernández   | 600890123 | ES12345678901234567897 | 2800.00 |
  --| 12345678I | Andrés Jiménez    | 600901234 | ES12345678901234567898 | 2700.00 |
  --| 12345678J | Marta Ruiz        | 601012345 | ES12345678901234567899 | 2900.00 |
  --| 12345684F | Javier Pérez      | 667890123 | ES12345678901234567895 | 2500.00 |
  --| 12345685G | Lucía Díaz        | 678901234 | ES12345678901234567896 | 1600.00 |
  --| 12345686H | Antonio López     | 689012345 | ES12345678901234567897 | 2400.00 |
  --| 12345687I | María Rodríguez   | 690123456 | ES12345678901234567898 | 2200.00 |
  --| 12345688J | Juan Pérez        | 701234567 | ES12345678901234567899 | 2300.00 |
  --+-----------+-------------------+-----------+------------------------+---------+
  --10 rows in set (0.003 sec)
  
    
  -- Obtener los veterinarios que han realizado al menos un tratamiento 
  SELECT nombre 
  FROM empleado 
  WHERE dni IN (SELECT dni_veterinario FROM tratamiento ); 
  
  --+------------------+
  --| nombre           |
  --+------------------+
  --| Laura Sánchez    |
  --| Carlos Díaz      |
  --| Paula Fernández  |
  --+------------------+
  --3 rows in set (0.002 sec)
  
  
  -- Obtener el historial de tratamientos de un animal específico 
  SELECT id_cita, id_tratamiento FROM historial  
  WHERE id_animal = (SELECT id  FROM animal WHERE nombre = 'Max'); 
  
  --+---------+----------------+
  --| id_cita | id_tratamiento |
  --+---------+----------------+
  --|       1 |              1 |
  --|      11 |             11 |
  --+---------+----------------+
  --2 rows in set (0.003 sec)
  
  -- Muestra  la (o las) salas con mas citas: 
  select * from sala  
  join cita on nombre = nombre_sala  
  group by nombre having count(nombre_sala) =  
  (select count(nombre_sala) as citas from sala join cita on nombre = nombre_sala group by nombre order by citas desc limit 1); 
  
      --+--------+------------+----+-------------+------------+----------+------------------+
      --| nombre | cod_centro | id | nombre_sala | fecha      | hora     | dniRecepcionista |
      --+--------+------------+----+-------------+------------+----------+------------------+
      --| Sala 1 |          1 |  1 | Sala 1      | 2024-01-10 | 10:00:00 | 12345678A        |
      --| Sala 2 |          2 |  2 | Sala 2      | 2024-01-11 | 11:00:00 | 12345678B        |
      --| Sala 3 |          3 |  3 | Sala 3      | 2024-01-12 | 12:00:00 | 12345678C        |
      --| Sala 4 |          4 |  4 | Sala 4      | 2024-01-13 | 13:00:00 | 12345678D        |
      --+--------+------------+----+-------------+------------+----------+------------------+
      --4 rows in set (0.008 sec)

-- 2. Consultas con CTE  
  -- CTE para obtener los empleados con sueldos superiores al promedio  
  WITH EmpleadosAltos AS (  
  SELECT * FROM empleado  
  WHERE sueldo > (SELECT AVG(sueldo) FROM empleado)  
  )  
  SELECT * FROM EmpleadosAltos; 
  
  --+-----------+--------------------+-----------+------------------------+---------+
  --| dni       | nombre             | telefono  | numcuenta              | sueldo  |
  --+-----------+--------------------+-----------+------------------------+---------+
  --| 12345678C | Pedro González     | 600345678 | ES12345678901234567892 | 2500.00 |
  --| 12345678F | Laura Sánchez      | 600678901 | ES12345678901234567895 | 2400.00 |
  --| 12345678G | Carlos Díaz        | 600789012 | ES12345678901234567896 | 2600.00 |
  --| 12345678H | Paula Fernández    | 600890123 | ES12345678901234567897 | 2800.00 |
  --| 12345678I | Andrés Jiménez     | 600901234 | ES12345678901234567898 | 2700.00 |
  --| 12345678J | Marta Ruiz         | 601012345 | ES12345678901234567899 | 2900.00 |
  --| 12345678L | Sofía Gómez        | 601234567 | ES12345678901234567801 | 2500.00 |
  --| 12345678M | Hugo Ramírez       | 601345678 | ES12345678901234567802 | 2400.00 |
  --| 12345678P | Elena Peña         | 601678901 | ES12345678901234567805 | 2600.00 |
  --| 12345678Q | Sergio Morales     | 601789012 | ES12345678901234567806 | 2800.00 |
  --| 12345678R | Claudia Vega       | 601890123 | ES12345678901234567807 | 2700.00 |
  --| 12345678S | Manuel Ortega      | 601901234 | ES12345678901234567808 | 2900.00 |
  --| 12345684F | Javier Pérez       | 667890123 | ES12345678901234567895 | 2500.00 |
  --| 12345686H | Antonio López      | 689012345 | ES12345678901234567897 | 2400.00 |
  --| 12345693O | Beatriz López      | 756789012 | ES12345678901234567904 | 2400.00 |
  --| 12345696R | Carmen García      | 789012345 | ES12345678901234567907 | 2500.00 |
  --| 12345697S | José Pérez         | 790123456 | ES12345678901234567908 | 2700.00 |
  --| 12345698T | Cristina Martínez  | 801234567 | ES12345678901234567909 | 2800.00 |
  --+-----------+--------------------+-----------+------------------------+---------+
  --18 rows in set (0.006 sec)
  
  
  --Obtener las salas con más citas 
  with nCitas AS (
    SELECT nombre_sala, COUNT(nombre_sala) as citas from cita  
    GROUP BY nombre_sala
    )  
    
  select nombre_sala, citas from nCitas  
  where citas in (select max(citas) from nCitas); 
  
  --+-------------+-------+
  --| nombre_sala | citas |
  --+-------------+-------+
  --| Sala 4      |     3 |
  --| Sala 3      |     3 |
  --| Sala 2      |     3 |
  --| Sala 1      |     3 |
  --+-------------+-------+
  --4 rows in set (0.002 sec)

   
-- 3. Creación de una tabla a partir de una consulta compleja 
  -- Crear una tabla con el historial completo de tratamientos por animal 
  CREATE TABLE HistorialCompleto AS
  SELECT h.id_cita, h.id_animal, h.id_tratamiento, a.nombre AS nombre_animal, t.tratamiento  
  FROM historial h  
  JOIN animal a ON h.id_animal = a.id  
  JOIN tratamiento t ON h.id_tratamiento = t.id; 
  
  --Query OK, 15 rows affected (0.099 sec)
  --Records: 15  Duplicates: 0  Warnings: 0
  
  --MariaDB [EMPRESA_VET]> select * from HistorialCompleto;
  --+---------+-----------+----------------+---------------+---------------------------------+
  --| id_cita | id_animal | id_tratamiento | nombre_animal | tratamiento                     |
  --+---------+-----------+----------------+---------------+---------------------------------+
  --|       1 |         1 |              1 | Max           | Chequeo anual                   |
  --|      11 |         1 |             11 | Max           | Administración de medicamentos  |
  --|       2 |         2 |              2 | Mia           | Desparasitación interna         |
  --|      12 |         2 |             12 | Mia           | Consulta digestiva              |
  --|       3 |         3 |              3 | Rocky         | Consulta dermatológica          |
  --|      13 |         3 |             13 | Rocky         | Baño medicado                   |
  --|       4 |         4 |              4 | Luna          | Limpieza dental                 |
  --|      14 |         4 |             14 | Luna          | Cirugía mayor                   |
  --|       5 |         5 |              5 | Charlie       | Baño con champú medicado        |
  --|      15 |         5 |             15 | Charlie       | Desparasitación externa         |
  --|       6 |         6 |              6 | Toby          | Administración de vitaminas     |
  --|       7 |         7 |              7 | Nala          | Cirugía menor                   |
  --|       8 |         8 |              8 | Simba         | Extirpación de quiste           |
  --|       9 |         9 |              9 | Daisy         | Cirugía dental                  |
  --|      10 |        10 |             10 | Bella         | Chequeo cardiológico            |
  --+---------+-----------+----------------+---------------+---------------------------------+
  --15 rows in set (0.001 sec)
  
    
-- 4. Definición de índices para mejorar el rendimiento  
  CREATE INDEX idx_empleado_sueldo ON empleado(sueldo);  
  --Query OK, 0 rows affected (0.075 sec)
  --Records: 0  Duplicates: 0  Warnings: 0
  
  CREATE INDEX idx_dni_cliente ON animal(dni_cliente)
  --Query OK, 0 rows affected (0.161 sec)
  --Records: 0  Duplicates: 0  Warnings: 0
   

-- 5. Planes de ejecución antes y después de la creación de índices  
  EXPLAIN  
  SELECT nombre, sueldo FROM empleado  
  WHERE sueldo = (SELECT MAX(sueldo) FROM empleado);  
  
  --+------+-------------+----------+------+---------------------+---------------------+---------+-------+------+------------------------------+
  --| id   | select_type | table    | type | possible_keys       | key                 | key_len | ref   | rows | Extra                        |
  --+------+-------------+----------+------+---------------------+---------------------+---------+-------+------+------------------------------+
  --|    1 | PRIMARY     | empleado | ref  | idx_empleado_sueldo | idx_empleado_sueldo | 6       | const | 2    | Using where                  |
  --|    2 | SUBQUERY    | NULL     | NULL | NULL                | NULL                | NULL    | NULL  | NULL | Select tables optimized away |
  --+------+-------------+----------+------+---------------------+---------------------+---------+-------+------+------------------------------+
  --2 rows in set (0.011 sec)
    
  EXPLAIN 
  SELECT nombre FROM cliente 
  WHERE dni IN ( 
    SELECT dni_cliente FROM animal 
    GROUP BY dni_cliente HAVING COUNT(id) > 1
    ); 
  
  --+------+--------------+-------------+--------+---------------+-----------------+---------+-------------------------+------+-------------+
  --| id   | select_type  | table       | type   | possible_keys | key             | key_len | ref                     | rows | Extra       |
  --+------+--------------+-------------+--------+---------------+-----------------+---------+-------------------------+------+-------------+
  --|    1 | PRIMARY      | <subquery2> | ALL    | distinct_key  | NULL            | NULL    | NULL                    | 5    |             |
  --|    1 | PRIMARY      | cliente     | eq_ref | PRIMARY       | PRIMARY         | 38      | <subquery2>.dni_cliente | 1    |             |
  --|    2 | MATERIALIZED | animal      | index  | NULL          | idx_dni_cliente | 39      | NULL                    | 5    | Using index |
  --+------+--------------+-------------+--------+---------------+-----------------+---------+-------------------------+------+-------------+
  --3 rows in set (0.035 sec)
