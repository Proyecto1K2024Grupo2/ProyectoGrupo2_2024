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
    edad INT,
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
    CONSTRAINT fk_idTratamiento FOREIGN KEY (id_tratamiento) REFERENCES tratamiento(id)
        ON UPDATE no action
        ON DELETE no action,
    PRIMARY KEY (id_cita, id_animal, id_tratamiento)
);
