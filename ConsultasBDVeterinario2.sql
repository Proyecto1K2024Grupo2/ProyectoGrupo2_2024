--Los telefonos y dni de los clientes que tienen gatos
SELECT t.dniCliente, t.telefono
from telefono t 
join cliente c on t.dniCliente=c.dni
join animal a on c.dni=a.dni_cliente
WHERE a.especie LIKE 'Gato';

--Todos los clientes que han tenido una cita el 25 de cicembre de 2024
SELECT c.dni 
from cliente c 
JOIN animal a ON c.dni=a.dni_cliente 
JOIN historial h ON a.id=h.id_animal
JOIN cita ci ON h.id_cita=ci.id 
WHERE ci.fecha='2024-12-25';

--Dinero que nos gastamos en sueldos segun los centros
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

--Todas las operaciones de 2019
SELECT id 
from tratamiento
where YEAR(fechaCirujano)=2019;
