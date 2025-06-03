## Sistema de Información
Nuestro negocio es una empresa formada por tres centros veterinarios.
De los centros se sabe el nombre, dirección y código postal. Cada centro está dividido en varias salas, como recepción, consultas, quirófano y salas de hospitalización, etc.
Cada centro cuenta con sus propios empleados, que incluye veterinarios, cirujanos, recepcionistas y cuidadores. De cada empleado se sabe: el DNI, nombre, teléfono, sueldo, número de cuenta.

El recepcionista de cada centro es responsable de gestionar la lista de clientes, de los cuales se sabe el DNI, nombre y teléfono. 
Cada cliente debe tener como mínimo una mascota registrada en el sistema. Las mascotas se clasifican en especies y razas. Además, de cada mascota se guarda información como su nombre, especie, raza, fecha de nacimiento y el historial médico (tratamientos previos, enfermedades, veterinario/cirujano que lo atendió…).


El recepcionista se encarga de gestionar las citas las cuales sabemos la (fecha, hora,  sala correspondiente y centro). Un tratamiento es una interacción de un trabajador con el animal, por ejemplo: cada operación es un tratamiento distinto, cada vez que el veterinario medique o interactúe cuenta como un tratamiento distinto o cada vez que un  cuidador tenga que cuidar al animal contará como un tratamiento. De cada tratamiento se sabe la fecha y la hora del mismo.

## Diagrama entidad relación hecho con ERDplus
![image (6)](https://github.com/user-attachments/assets/2c31f6bc-14a1-4a3b-8b8b-07eb9c0b11d7)


### Justificación de decisiones
Generalización\
Se ha utilizado la generalización en el ER para representar los diferentes tipos de empleados (VETERINARIO, CIRUJANO, CUIDADOR, RECEPCIONISTA) a partir de la entidad EMPLEADO.\
Lo que permite reutilizar atributos evitando redundancias, además de que cada tipo de empleado tiene sus funciones y relaciones particulares (como PROPORCIONAR tratamientos o GESTIONAR citas).

Agregación\
La agregación en HISTORIAL reúne toda la información sobre los tratamientos y visitas de cada animal en una sola entidad, además incluye la información sobre los tratamientos que se le han hecho, las fechas y motivos de sus citas. HISTORIAL hace más fácil el seguimiento de la información de los animales.

Entidad teléfono\
La entidad teléfono, es multivaluada en cliente pero en recepcionista no. Hemos decidido hacerlo así ya que a un cliente es más adecuado asignar un número de teléfono alternativo por si no está disponible, como en el caso de que el cliente sea un padre, trabaje por las mañanas y nos proporcione el número de su mujer que sí está disponible por las mañanas. En empleado es fijo ya que al empleado no le podemos asignar un número de teléfono alternativo.
