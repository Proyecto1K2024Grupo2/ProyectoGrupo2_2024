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


-- Devuelveme el nombre de empledado y sus numero de telefono.
SELECT nombre,telefono from empleado;

--Calcular el sueldo promedio de los empleados:
SELECT AVG(sueldo) AS sueldo_promedio FROM empleado;

-- Lista el nombre y el DNI de los clientes cuyo nombre sea Hugo.
SELECT dni, nombre FROM cliente WHERE nombre LIKE '%Hugo%';

-- devuelveme el nombre de los empleados recepcionuistas y su dni.
SELECT e.nombre, e.dni FROM empleado e JOIN recepcionista r ON e.dni = r.dni;

-- Muestra cuantas citas han habido en el mes de Enero

SELECT COUNT(*) AS total_citas_diciembre FROM cita WHERE MONTH(fecha) = 1;

-- Devuelveme los veterinarios que trabajan en el centro 3.
SELECT e.nombre, e.dni FROM empleado e JOIN veterinario v ON e.dni = v.dni JOIN trabajar t ON e.dni = t.dniEmpleado WHERE t.codCentro = 3;

-- Mostrar todas las salas ordenadas por el nombre del centro asociado:
SELECT s.nombre AS sala, c.nombre AS centro FROM sala s
JOIN centro c ON s.cod_centro = c.cod
ORDER BY c.nombre;

-- Listar cuantos empleado trabajan en cada centro.
SELECT c.nombre AS nombre_centro, c.cod AS codigo_centro, COUNT(t.dniEmpleado) AS numero_empleados FROM centro c
LEFT JOIN trabajar t ON c.cod = t.codCentro
GROUP BY c.cod, c.nombre
ORDER BY numero_empleados DESC;

--Muestra los clientes que han tenido cita el mes de Enero
SELECT DISTINCT cl.*
FROM cliente cl
JOIN animal an ON cl.dni = an.dni_cliente
JOIN historial hi ON hi.id_animal = an.id
JOIN cita ci ON ci.id = hi.id_cita
WHERE MONTH(ci.fecha) = 1;

-- Mostrar tratamientos realizados por un veterinario Laura
SELECT t.id AS id_tratamiento, t.tratamiento, t.medicamento, t.posologia, t.fechaVeterinario, t.horaVeterinario, e.nombre AS nombre_veterinario
FROM tratamiento t
JOIN veterinario v ON t.dni_veterinario = v.dni
JOIN empleado e ON v.dni = e.dni
WHERE e.nombre = 'Laura Sanchez'
ORDER BY t.fechaVeterinario DESC, t.horaVeterinario DESC;







