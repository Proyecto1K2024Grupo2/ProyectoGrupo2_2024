# ProyectoGrupo2_2024

## Miembros
[**Juan Carlos Garcia Andreu**](https://github.com/JuanCarlosgarcia86) \
[**Martin Davia Mora**](https://github.com/Apolonelche) \
[**Raul Quilez Ruiz**](https://github.com/Quilez42) \
[**Rubén Expósito Vicente**](https://github.com/Rebirzt)

## Indice De Contenidos
### [Modelo Logico](https://github.com/Proyecto1K2024Grupo2/ProyectoGrupo2_2024/blob/main/Modelo%20Logico.md)
### [Modelo Fisico](https://github.com/Proyecto1K2024Grupo2/ProyectoGrupo2_2024/blob/main/Modelo%20Logico.md)
### [DDL](https://github.com/Proyecto1K2024Grupo2/ProyectoGrupo2_2024/blob/main/DDL.sql)
### [DML](https://github.com/Proyecto1K2024Grupo2/ProyectoGrupo2_2024/blob/main/DML.sql)


## Posibes consultas para la BD
-- 1. Devuelveme el nombre de empledado y sus numero de telefono.
```sql
SELECT nombre,telefono from empleado;
 -- +--------------------+-----------+
 -- | nombre             | telefono  |
 -- +--------------------+-----------+
 -- | Juan Pérez         | 600123456 |
 -- | María López        | 600234567 |
 -- ...
 -- | Cristina Martínez  | 801234567 |
 -- +--------------------+-----------+
 -- 40 rows in set (0.005 sec)
````


-- 2. Calcular el sueldo promedio de los empleados:
```sql
SELECT AVG(sueldo) AS sueldo_promedio FROM empleado;
 -- +-----------------+
 -- | sueldo_promedio |
 -- +-----------------+
 -- |     2310.000000 |
 -- +-----------------+
 -- 1 row in set (0.029 sec)
````

-- 3. Lista el nombre y el DNI de los clientes cuyo nombre sea Hugo.
```sql
SELECT dni, nombre FROM cliente WHERE nombre LIKE '%Hugo%';
 -- +-----------+-------------+
 -- | dni       | nombre      |
 -- +-----------+-------------+
 -- | 11111111C | Hugo López  |
 -- +-----------+-------------+
 -- 1 row in set (0.002 sec)
````

-- 4. devuelveme el nombre de los empleados recepcionuistas y su dni.
```sql
SELECT e.nombre, e.dni FROM empleado e JOIN recepcionista r ON e.dni = r.dni;
 -- +-------------------+-----------+
 -- | nombre            | dni       |
 -- +-------------------+-----------+
 -- | Juan Pérez        | 12345678A |
 -- | María López       | 12345678B |
 -- | Pedro González    | 12345678C |
 -- | Ana Martín        | 12345678D |
 -- | Luis García       | 12345678E |
 -- | Laura Sánchez     | 12345679A |
 -- | Carlos Martínez   | 12345680B |
 -- | Ana Gómez         | 12345681C |
 -- | Miguel Rodríguez  | 12345682D |
 -- | Elena Fernández   | 12345683E |
 -- +-------------------+-----------+
 -- 10 rows in set (0.004 sec)
````
-- 5. Muestra cuantas citas han habido en el mes de Enero
```sql
SELECT COUNT(*) AS total_citas_diciembre FROM cita WHERE MONTH(fecha) = 1;
 -- +-----------------------+
 -- | total_citas_diciembre |
 -- +-----------------------+
 -- |                     5 |
 -- +-----------------------+
 -- 1 row in set (0.005 sec)
````
-- 6. Devuelveme los veterinarios que trabajan en el centro 3.
```sql
SELECT e.nombre, e.dni FROM empleado e JOIN veterinario v ON e.dni = v.dni JOIN trabajar t ON e.dni = t.dniEmpleado WHERE t.codCentro = 3;
 -- +------------------+-----------+
 -- | nombre           | dni       |
 -- +------------------+-----------+
 -- | Paula Fernández  | 12345678H |
 -- | Juan Pérez       | 12345688J |
 -- +------------------+-----------+
 -- 2 rows in set (0.005 sec)
````

-- 7. Mostrar todas las salas ordenadas por el nombre del centro asociado:
```sql
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
````

-- 8. Listar cuantos empleado trabajan en cada centro.
```sql
SELECT c.nombre AS nombre_centro, c.cod AS codigo_centro, COUNT(t.dniEmpleado) AS numero_empleados FROM centro c
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
````

-- 9.Muestra los clientes que han tenido cita el mes de Enero
```sql
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
````

-- 10. Mostrar tratamientos realizados por un veterinario Laura
```sql
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
