/*Selecionar la base de datos*/
use db_sysp_sec;

/*Seteo de variable de control*/
set SQL_SAFE_UPDATES=0;
SET FOREIGN_KEY_CHECKS = 0; 

/*Borrado de tablas*/
TRUNCATE TABLE  papeleta; 
TRUNCATE TABLE  usuario; 
TRUNCATE TABLE  empleado; 
TRUNCATE TABLE area; 
TRUNCATE TABLE  motivo; 
TRUNCATE TABLE  persona; 


/*Insertar datos a la tabla areas*/
INSERT INTO area (id_area, nombre_corto, nombre_largo, area_superior) VALUES (1,'GG','Gerencia General',NULL);
INSERT INTO area (id_area, nombre_corto, nombre_largo, area_superior) VALUES (2,'ADM','Administración',1);
INSERT INTO area (id_area, nombre_corto, nombre_largo, area_superior) VALUES (3,'CONT','Unidad de Contabilidad',2);
INSERT INTO area (id_area, nombre_corto, nombre_largo, area_superior) VALUES (4,'TES','Unidad de Tesoreria',2);

/*Insertar datos a la tabla motivo*/
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (1,'Descanso Médico',1);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (2,'Cita Médica',1);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (3,'Capacitación Oficializada',1);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (4,'Comisión de servicios',1);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (5,'Onomastico',1);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (6,'Vacaciones',1);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (7,'Otro',1);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (8,'Permiso Particular',2);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (9,'Capacitación no oficial',2);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (10,'Otro',2);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (11,'Omisión de marcado',3);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (12,'Matrimonio',3);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (13,'Fallecimiento familiar',3);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (14,'Enfermedad familiar',3);
INSERT INTO motivo (id_motivo, nombre_motivo, id_grupo) VALUES (15,'Licencia paternidad',3);


/*Insertar datos a la tabla persona*/
INSERT INTO persona (id_persona, nombre, apellido_1, apellido_2, id_tipo_doc, num_doc, id_genero, fecha_nacimiento) VALUES (1,'Juan','Castro','Artica',1,'20090807',1,'1980-01-24');
INSERT INTO persona (id_persona, nombre, apellido_1, apellido_2, id_tipo_doc, num_doc, id_genero, fecha_nacimiento) VALUES (2,'Maria','Saenz','Yepes',1,'20010203',1,'1981-01-25');
INSERT INTO persona (id_persona, nombre, apellido_1, apellido_2, id_tipo_doc, num_doc, id_genero, fecha_nacimiento) VALUES (3,'Pedro','Escobar','Gomez',1,'20020304',1,'1982-02-07');
INSERT INTO persona (id_persona, nombre, apellido_1, apellido_2, id_tipo_doc, num_doc, id_genero, fecha_nacimiento) VALUES (4,'Ana','Soto','Lara',1,'20040506',1,'1978-03-08');

/*Insertar datos a la tabla empleado*/
INSERT INTO empleado (id_empleado, id_area, fecha_ingreso, id_tipo_empleado, id_tipo_contrato, id_estado) VALUES (1,2,'2015-12-01',1,1,1);
INSERT INTO empleado (id_empleado, id_area, fecha_ingreso, id_tipo_empleado, id_tipo_contrato, id_estado) VALUES (2,3,'2015-10-10',1,1,1);
INSERT INTO empleado (id_empleado, id_area, fecha_ingreso, id_tipo_empleado, id_tipo_contrato, id_estado) VALUES (3,3,'2016-12-03',1,1,1);
INSERT INTO empleado (id_empleado, id_area, fecha_ingreso, id_tipo_empleado, id_tipo_contrato, id_estado) VALUES (4,4,'2016-03-25',1,1,1);

/**Insertra datos Usuario**/
INSERT INTO usuario (id_usuario, login_name, password,id_empleado) VALUES (1, 'juan', '$2a$10$sq0gP3dXsSLzDc6WBS6zwe2yxyGJUY4hvWJX701wJuXroNUSdyvX.', 1);
INSERT INTO usuario (id_usuario, login_name, password,id_empleado) VALUES (2, 'maria', '$2a$10$sq0gP3dXsSLzDc6WBS6zwe2yxyGJUY4hvWJX701wJuXroNUSdyvX.', 2);
INSERT INTO usuario (id_usuario, login_name, password,id_empleado) VALUES (3, 'pedro', '$2a$10$sq0gP3dXsSLzDc6WBS6zwe2yxyGJUY4hvWJX701wJuXroNUSdyvX.', 3);
INSERT INTO usuario (id_usuario, login_name, password,id_empleado) VALUES (4, 'admin', '$2a$10$sq0gP3dXsSLzDc6WBS6zwe2yxyGJUY4hvWJX701wJuXroNUSdyvX.', 4);

/**Insertra datos Usuario**/

INSERT INTO rol (id_rol,rol_name) VALUES(1, 'ADMIN');
INSERT INTO rol (id_rol,rol_name) VALUES(2, 'USER');
INSERT INTO rol (id_rol,rol_name) VALUES(3, 'EDITOR');

INSERT INTO usuario_roles (id_usuario,id_rol) VALUES(1,2);
INSERT INTO usuario_roles (id_usuario,id_rol) VALUES(1,3);
INSERT INTO usuario_roles (id_usuario,id_rol) VALUES(2,2);
INSERT INTO usuario_roles (id_usuario,id_rol) VALUES(3,2);
INSERT INTO usuario_roles (id_usuario,id_rol) VALUES(4,1);


/*Confirmacion y restauracion de valores*/
COMMIT;
set SQL_SAFE_UPDATES=1;
SET FOREIGN_KEY_CHECKS = 1;
