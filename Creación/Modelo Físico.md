## Modelo Relacional

**EMPLEADO** (<u>dni</u>, nombre, telefono, numcuenta, sueldo)\
 PK: (dni)

 \
**VETERINARIO** (<u>dni*</u>)\
PK: (dni)\
FK: (dni) → EMPLEADO

\
**CIRUJANO** (<u>dni*</u>)\
PK: (dni)\
FK: (dni) → EMPLEADO

\
**CUIDADOR** (<u>dni*</u>)\
PK: (dni)\
FK: (dni) → EMPLEADO

\
**RECEPCIONISTA** (<u>dni*</u>)\
PK: (dni)\
FK: (dni) → EMPLEADO

\
**CENTRO** (<u>cod</u>, nombre, direccion, cp)\
 PK: (cod)

\
**TRABAJAR** (<u>dni_empleado*, cod_centro*</u>)\
PK: (dni_empleado, cod_centro)\
FK: (dni_empleado) → EMPLEADO\
FK: (cod_centro) → CENTRO

\
**SALA** (<u>cod_sala</u>, nombre, cod_centro*)\
PK: (cod_sala)\
FK: (cod_centro) → CENTRO

\
**CITA** (<u>id</u>, fecha, hora, nombreSala*, dniRecepcionista*)\
PK: (id)\
FK: (nombreSala) → SALA\
FK: (dniRecepcionista) → RECEPCIONISTA\

\
**CLIENTE** (<u>dni</u>, nombre,)\
 PK: (dni)

\
**TELEFONO** (<u>teléfono</u>, dniCliente*)\
 PK: (teléfono)\
 FK: (dniCliente) -> CLIENTE
 
\
**ANIMAL** (<u>id</u>, dni_cliente*, nombre, especie, raza, fnac)\
PK: (id)\
FK: (dni_cliente) → CLIENTE\
VNN: (dni_cliente)

\
**TRATAMIENTO** (<u>id</u>, tratamiento, medicina, posologia, dniCuidador*, fechaCuidador, horaCuidador, dniVeterinario*, fechaVeterinario, horaVeterinario, dniCirujano*, fechaCirujano, horaCirujano)\
PK: (id)\
FK: (dniCuidador) -> CUIDADOR\
FK: (dniVeterinario) -> VETERINARIO\
FK: (dniCirujano) -> CIRUJANO

\
**HISTORIAL** (<u>id_cita, id_tratamiento</u>, id_animal)\
PK: (id_cita, id_tratamiento)\
FK: (id_cita) → CITA\
FK: (id_tratamiento) → TRATAMIENTO\
FK: (id_animal) → ANIMAL


## Diccionario de datos

**EMPLEADO**

| Atributo  | Tipo         | Descripción                                      |
|-----------|--------------|--------------------------------------------------|
| dni       | VARCHAR (9)  | Clave primaria, identificador único del empleado |
| nombre    | VARCHAR (64) | Nombre del empleado                              |
| teléfono  | INT (9)      | Teléfono del empleado                            |
| numcuenta | VARCHAR (20) | Número de cuenta bancaria del empleado           |
| sueldo    | DOUBLE       | Sueldo del empleado                              |

\
**VETERINARIO**

| Atributo | Tipo           | Descripción                                           |
|----------|----------------|-------------------------------------------------------|
| dni      | VARCHAR (9)    | Clave primaria, clave foranea referencia a EMPLEADO   |

\
**CIRUJANO**

| Atributo | Tipo           | Descripción                                           |
|----------|----------------|-------------------------------------------------------|
| dni      | VARCHAR (9)    | Clave primaria, clave foranea referencia a EMPLEADO   |

\
**CUIDADOR**

| Atributo | Tipo           | Descripción                                           |
|----------|----------------|-------------------------------------------------------|
| dni      | VARCHAR (9)    | Clave primaria, clave foranea referencia a EMPLEADO   |

\
**RECEPCIONISTA**

| Atributo | Tipo           | Descripción                                           |
|----------|----------------|-------------------------------------------------------|
| dni      | VARCHAR (9)    | Clave primaria, clave foranea referencia a EMPLEADO   |

\
**CENTRO**

| Atributo  | Tipo         | Descripción                             |
|-----------|--------------|-----------------------------------------|
| cod       | INT          | Clave primaria, código único del centro |
| nombre    | VARCHAR (64) | Nombre del centro                       |
| dirección | VARCHAR (64) | Dirección del centro                    |
| cp        | INT (5)      | Código postal del centro                |

\
**TRABAJAR**

| Atributo     | Tipo          | Descripción                          |
|--------------|---------------|--------------------------------------|
| dni_empleado | VARCHAR (9)   | Clave foránea, referencia a EMPLEADO |
| cod_centro   | INT           | Clave foránea, referencia a CENTRO   |

\
**SALA**

| Atributo     | Tipo         | Descripción                                     |
|--------------|--------------|-------------------------------------------------|
| nombre       | VARCHAR (32) | Clave primaria, código identificador de la sala |
| Cod_centro   | INT          | Clave primaria, código único del centro         |

\
**CITA**

| Atributo          | Tipo         | Descripción                                                                       |
|-------------------|--------------|-----------------------------------------------------------------------------------|
| id                | INT          | Clave primaria, identificador único de la cita                                    |
| cod_sala          | INT          | Clave foránea, referencia a SALA                                                  |
| fecha             | DATE         | Fecha de la cita                                                                  |
| hora              | TIME         | Hora de la cita                                                                   |
| nombreSala        | VARCHAR (32) | Clave primaria, código identificador de la sala, clave foránea, referencia a SALA |
| dniRecepcionista  | VARCHAR (9)  | Clave foránea, referencia a RECEPCIONISTA                                         |

\
**CLIENTE**

| Atributo   | Tipo         | Descripción                                       |
|------------|--------------|---------------------------------------------------|
| dni        | VARCHAR (9)  | Clave primaria, código identificador del cliente. |
| nombre     | VARCHAR (64) | Nombre del cliente                                |

\
**TELEFONO**
| Atributo   | Tipo         | Descripción                                       |
|------------|--------------|---------------------------------------------------|
| telefono   | INT (9)      | Télefono del cliente                              |
| dniCliente | VARCHAR (9)  | DNI del dueño del telefono                        |

\
**ANIMAL**

| Atributo    | Tipo         | Descripción                                    |
|-------------|--------------|------------------------------------------------|
| id          | INT          | Clave primaria, identificador único del animal |
| dni_cliente | VARCHAR (9)  | Clave foránea, referencia a CLIENTE            |
| nombre      | VARCHAR (64) | Nombre del animal                              |
| especie     | VARCHAR (64) | Especie del animal                             |
| raza        | VARCHAR (64) | Raza del animal                                |
| fnac        | DATE         | Fecha de nacimento del animal                  |

\
**TRATAMIENTO**

| Atributo         | Tipo           | Descripción                                                       |
|------------------|----------------|-------------------------------------------------------------------|
| id               | INT            | Clave primaria, identificador del tratamiento                     |
| tratamiento      | VARCHAR (1500) | Descripción del tratamiento                                       |
| medicamento      | VARCHAR (64)   | Medicamento utilizado en el tratamiento                           |
| posología        | VARCHAR (64)   | Posología del medicamento                                         |
| dniCuidador      | VARCHAR (9)    | Clave foránea, referencia a CUIDADOR                              |
| fechaCuidador    | DATE           | Fecha del tratamienento proporcionado por el cuidador             |
| horaCuidador     | TIME           | Hora del tratamienento proporcionado por el cuidador              |
| dniVeterinario   | VARCHAR (9)    | Clave foránea, referencia a VETERINARIO                           |
| fechaVeterinario | DATE           | Fecha del tratamienento proporcionado por el veterinario          |
| horaVeterinario  | TIME           | Hora del tratamienento proporcionado por el veterinario           |
| dniCirujano      | VARCHAR (9)    | Clave foránea, referencia a CIRUJANO                              |
| fechaCirujano    | DATE           | Fecha del tratamienento proporcionado por el cirujano             |
| horaCirujano     | TIME           | Hora del tratamienento proporcionado por el cirujano              |

\
**HISTORIAL**

| Atributo       | Tipo  | Descripción                                           |
|----------------|-------|-------------------------------------------------------|
| id_cita        | INT   | Clave primaria, clave ajena identifica la cita        |
| id_tratamiento | INT   | Clave primaria, clave ajena identifica el tratamiento |
| Id_animal      | INT   | Clave primaria, clave ajena identifica al animal      |
