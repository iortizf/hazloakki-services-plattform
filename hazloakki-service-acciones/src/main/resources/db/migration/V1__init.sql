CREATE TABLE cat_acciones (
 id_accion INT PRIMARY KEY,
 nombre varchar(255) DEFAULT NULL,
 descripcion varchar(255) DEFAULT NULL,
 estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(1,'Comer','pagos realizados en efectivo',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(2,'Beber','pagos realizados en efectivo',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(3,'Bailar','pagos realizados en efectivo',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(4,'Cantar','pagos realizados en efectivo',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(5,'Descanzar','pagos realizados en efectivo',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(6,'Viajar','pagos realizados en efectivo',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(7,'Leer','pagos realizados en efectivo',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(8,'Nadar','pagos realizados en efectivo',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(9,'Divertirme','pagos realizados en efectivo',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(10,'Comprar','pagos realizados en efectivo',true);
insert into cat_acciones(id_accion, nombre, descripcion, estatus)  VALUES(11,'Dormir','pagos realizados en efectivo',true);
