/*create database db_sysp_sec;*/
use db_sysp_sec;

CREATE TABLE Area
(
	id_area              INTEGER NOT NULL,
	nombre_corto         VARCHAR(20) NULL,
	nombre_largo         VARCHAR(50) NULL,
	area_superior        INTEGER NULL
);



ALTER TABLE Area
ADD PRIMARY KEY (id_area);



CREATE TABLE Empleado
(
	fecha_ingreso        DATE NULL,
	id_tipo_empleado     INTEGER NULL,
	id_tipo_contrato     INTEGER NULL,
	id_estado            INTEGER NULL,
	id_area              INTEGER NULL,
	id_empleado          INTEGER NOT NULL
);



ALTER TABLE Empleado
ADD PRIMARY KEY (id_empleado);



CREATE TABLE Motivo
(
	id_motivo            INTEGER NOT NULL,
	nombre_motivo        VARCHAR(100) NULL,
	id_grupo             INTEGER NULL
);



ALTER TABLE Motivo
ADD PRIMARY KEY (id_motivo);



CREATE TABLE Papeleta
(
	id_papeleta          INTEGER NOT NULL,
	num_ano              INTEGER NULL,
	num_papeleta         INTEGER NULL,
	fecha_inicio         DATE NULL,
	fecha_fin            DATE NULL,
	hora_inicio          VARCHAR(5) NULL,
	hora_fin             VARCHAR(5) NULL,
	des_observacion      VARCHAR(100) NULL,
	id_empleado          INTEGER NULL,
	id_motivo            INTEGER NOT NULL
);



ALTER TABLE Papeleta
ADD PRIMARY KEY (id_papeleta);



CREATE TABLE Persona
(
	id_persona           INTEGER NOT NULL,
	nombre               VARCHAR(20) NULL,
	apellido_1           VARCHAR(50) NULL,
	apellido_2           VARCHAR(50) NULL,
	id_tipo_doc          INTEGER NULL,
	num_doc              VARCHAR(10) NULL,
	id_genero            INTEGER NULL,
	fecha_nacimiento     DATE NULL
);



ALTER TABLE Persona
ADD PRIMARY KEY (id_persona);



CREATE TABLE Rol
(
	id_rol               INTEGER NOT NULL,
	rol_name             VARCHAR(30) NULL
);



ALTER TABLE Rol
ADD PRIMARY KEY (id_rol);



CREATE TABLE Usuario
(
	id_usuario           INTEGER NOT NULL,
	login_name           VARCHAR(20) NULL,
	password             VARCHAR(300) NULL,
	id_empleado          INTEGER NOT NULL
);



ALTER TABLE Usuario
ADD PRIMARY KEY (id_usuario);

ALTER TABLE Usuario
MODIFY login_name VARCHAR(20) NOT NULL;



CREATE TABLE Usuario_Roles
(
	id_usuario           INTEGER NOT NULL,
	id_rol               INTEGER NOT NULL
);



ALTER TABLE Area
ADD FOREIGN KEY R_14 (area_superior) REFERENCES Area (id_area);



ALTER TABLE Empleado
ADD FOREIGN KEY R_7 (id_area) REFERENCES Area (id_area);



ALTER TABLE Empleado
ADD FOREIGN KEY R_16 (id_empleado) REFERENCES Persona (id_persona);



ALTER TABLE Papeleta
ADD FOREIGN KEY R_14 (id_empleado) REFERENCES Empleado (id_empleado);



ALTER TABLE Papeleta
ADD FOREIGN KEY R_17 (id_motivo) REFERENCES Motivo (id_motivo);



ALTER TABLE Usuario
ADD FOREIGN KEY R_15 (id_empleado) REFERENCES Empleado (id_empleado);



ALTER TABLE Usuario_Roles
ADD FOREIGN KEY R_18 (id_usuario) REFERENCES Usuario (id_usuario);



ALTER TABLE Usuario_Roles
ADD FOREIGN KEY R_20 (id_rol) REFERENCES Rol (id_rol);




