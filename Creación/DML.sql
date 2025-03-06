
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
INSERT INTO animal (dni_cliente, nombre, especie, raza, edad) VALUES
('11111111A', 'Max', 'Perro', 'Labrador', 3),
('11111111B', 'Mia', 'Gato', 'Siames', 2),
('11111111C', 'Rocky', 'Perro', 'Bulldog', 4),
('11111111D', 'Luna', 'Gato', 'Persa', 1),
('11111111E', 'Charlie', 'Conejo', 'Enano', 5),
('11111111F', 'Toby', 'Perro', NULL, 4),
('11111111G', 'Nala', 'Gato', 'Bengala', NULL),
('11111111H', 'Simba', 'Perro', NULL, NULL),
('11111111I', 'Daisy', 'Gato', 'Angora', 2),
('11111111J', 'Bella', 'Conejo', 'Enano', NULL),
('11111111K', 'Max', 'Perro', 'Boxer', 6),
('11111111L', 'Lola', 'Gato', NULL, NULL),
('11111111M', 'Rocky', 'Perro', 'Husky', NULL),
('11111111N', 'Luna', 'Gato', 'Persa', 2),
('11111111O', 'Charlie', 'Pájaro', NULL, 1),
('11111111P', 'Coco', 'Pájaro', 'Loro', NULL),
('11111111Q', 'Milo', 'Perro', NULL, NULL),
('11111111R', 'Kira', 'Gato', 'Europeo', NULL),
('11111111S', 'Bruno', 'Perro', NULL, 2),
('11111111T', 'Mia', 'Conejo', NULL, NULL);

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
