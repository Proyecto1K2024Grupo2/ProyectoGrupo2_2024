-- CONSULTAS AGREGADAS

--Los teléfonos y dni de los clientes que tienen gatos.
SELECT DISTINCT(t.dniCliente, t.telefono)
from telefono t 
join cliente c on t.dniCliente=c.dni
join animal a on c.dni=a.dni_cliente
WHERE a.especie LIKE 'Gato';

--Todos los clientes que han tenido una cita el 25 de diciembre de 2024.
SELECT c.dni 
from cliente c 
JOIN animal a ON c.dni=a.dni_cliente 
JOIN historial h ON a.id=h.id_animal
JOIN cita ci ON h.id_cita=ci.id 
WHERE ci.fecha='2024-12-25';

--Dinero  invertido en sueldos por cada centro.
SELECT t.codCentro, SUM(e.sueldo)
from trabajar t 
join empleado e on t.dniempleado=e.dni 
GROUP BY t.codCentro;

--Todos los recepcionistas que han asignado más de 10 citas
SELECT e.dni, e.nombre , COUNT(c.id) as CitasConcedidas
FROM empleado e 
JOIN recepcionista r ON e.dni=r.dni 
JOIN cita c on r.dni=c.dniRecepcionista
GROUP BY r.dni 
HAVING CitasConcedidas>10;

--Animal o animales que han tenido más cirujías 
select h.* 
  from historial h join tratamiento t on h.id_tratamiento = t.id 
  where dni_cirujano is not null;

--Mostrar los historiales, nombres y tratamientos de cada animal.
SELECT HISTORIAL.id, ANIMAL.nombre, TRATAMIENTO.tratamiento 
FROM HISTORIAL
JOIN ANIMAL ON HISTORIAL.id_animal = ANIMAL.id
JOIN TRATAMIENTO ON HISTORIAL.id_tratamiento = TRATAMIENTO.id;

-- Devuelve los centros que no ha tenido citas en los ultimos 7 días.
select c.cod from centro c
join sala s on c.cod=s.cod_centro
LEFT join cita ci on s.nombre=ci.nombre_sala
where fehca < DATE_SUB(CURRENT_DATE, INTERVAL 7 DAY);

-- FALTA CONSULTA --

--Empleado que trabajan en más de un centro.
SELECT e.dni, e.nombre, COUNT(t.codCentro) AS total_centros
FROM empleado e
JOIN trabajar t ON e.dni = t.dniEmpleado
GROUP BY e.dni, e.nombre
HAVING COUNT(t.codCentro) > 1;

-- Veterinarios que han realizado más de 5 tratamientos en el último año.

SELECT v.dni, e.nombre, COUNT(t.id) AS total_tratamientos
FROM veterinario v
JOIN empleado e ON v.dni = e.dni
JOIN tratamiento t ON v.dni = t.dni_veterinario
WHERE t.fecha >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
GROUP BY v.dni, e.nombre
HAVING COUNT(t.id) > 5;

-- Nombre de los cirujanos y la cantidad de citas que han tenido en los últimos 6 meses.

SELECT c.dni, e.nombre, COUNT(ci.id) AS total_citas
FROM cirujano c
JOIN empleado e ON c.dni = e.dni
JOIN tratamiento t ON c.dni = t.dni_cirujano
JOIN historial h ON t.id = h.id_tratamiento
JOIN cita ci ON h.id_cita = ci.id
WHERE ci.fecha >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH)
GROUP BY c.dni, e.nombre;

--Los animales que mas tratamientos han tenido.
SELECT a.id, a.nombre, COUNT(h.id_tratamiento),
RANK() OVER (ORDER BY COUNT(h.id_tratamiento) DESC) as ranking_tratamientos
FROM historial h 
JOIN animal a ON h.id_animal = a.id
GROUP BY a.id;

--Información de las citas.
CREATE VIEW vista_citas AS (
SELECT c.id, c.nombre_sala, c.fecha, c.hora, e.nombre
FROM cita c
JOIN recepcionista r ON c.dniRecepcionista = r.dni
JOIN empleado e ON r.dni = e.dni
);

--Datos de los clientes y sus animales.
CREATE VIEW vista_clientes_mascotas AS (
SELECT c.dni, c.nombre, a.nombre, a.especie, a.raza, a.edad
FROM cliente c
JOIN animal a ON c.dni = a.dni_cliente
);
