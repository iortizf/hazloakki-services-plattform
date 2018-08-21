CREATE TABLE negocio (
  id VARCHAR(255) PRIMARY KEY,
  nombre varchar(45) DEFAULT NULL,
  id_categoria NUMERIC,
  email varchar(45) DEFAULT NULL,
  descripcion varchar(45) DEFAULT NULL,
  telefono varchar(45) DEFAULT NULL,
  domicilio varchar(45) DEFAULT NULL,
  latitud varchar(45) DEFAULT NULL,
  longitud varchar(45) DEFAULT NULL,
  estatus BOOLEAN NOT NULL DEFAULT FALSE,
  codigo_postal varchar(45) DEFAULT NULL,
  delegacion varchar(45) DEFAULT NULL,
  colonia varchar(45) DEFAULT NULL,
  calle varchar(45) DEFAULT NULL,
  numero_exterior varchar(45) DEFAULT NULL,
  horario varchar(45) DEFAULT NULL,
  responsable varchar(45) DEFAULT NULL,
  id_cuenta varchar(255) DEFAULT NULL
);

CREATE TABLE cat_metodo_pago (
 id VARCHAR(255) PRIMARY KEY,
 nombre varchar(255) DEFAULT NULL,
 descripcion varchar(255) DEFAULT NULL,
 estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into cat_metodo_pago(id, nombre, valor, estatus) VALUES(1,'pago_efectivo','pagos realizados en efectivo',true);
insert into cat_metodo_pago(id, nombre, valor, estatus) VALUES(2,'monedero_electronico','pagos realizados en efectivo',true);
insert into cat_metodo_pago(id, nombre, valor, estatus) VALUES(3,'metodo_transferencia','pagos realizados en efectivo',true);
insert into cat_metodo_pago(id, nombre, valor, estatus) VALUES(4,'tarjeta','pagos realizados en efectivo',true);
insert into cat_metodo_pago(id, nombre, valor, estatus) VALUES(5,'cheque','pagos realizados en efectivo',true);

CREATE TABLE negocios_metodo_pago(
	 id_negocio VARCHAR(255) PRIMARY KEY,
	 id_pago VARCHAR(255) PRIMARY KEY
);


CREATE TABLE cat_servicios(
 	id VARCHAR(255) PRIMARY KEY,
	nombre varchar(255) DEFAULT NULL,
 	descripcion varchar(255) DEFAULT NULL,
 	estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into cat_servicios(id, nombre, valor, estatus) VALUES(1,'servicio a domicilio','te llevan tus solicitudes a casa',true);
insert into cat_servicios(id, nombre, valor, estatus) VALUES(2,'estacionamiento','zona para estacionarse',true);
insert into cat_servicios(id, nombre, valor, estatus) VALUES(2,'internet','wifi gratis',true);
insert into cat_servicios(id, nombre, valor, estatus) VALUES(2,'reservaciones','admite reservaciones',true);
insert into cat_servicios(id, nombre, valor, estatus) VALUES(2,'modo_llevar','puede solicitar llevarse los productos',true);


CREATE TABLE negocios_servicios(
	 id_negocio VARCHAR(255) PRIMARY KEY,
	 id_servicio VARCHAR(255) PRIMARY KEY
);

CREATE TABLE tipo_tarjeta(
 	id VARCHAR(255) PRIMARY KEY,
	nombre varchar(255) DEFAULT NULL,
 	descripcion varchar(255) DEFAULT NULL,
 	estatus BOOLEAN NOT NULL DEFAULT FALSE
);

insert into tipo_tarjeta(id, nombre, valor, estatus) VALUES(1,'visa','tarjetas de tipo visa',true);
insert into tipo_tarjeta(id, nombre, valor, estatus) VALUES(1,'master-card','tarjetas de tipo mastercard',true);


CREATE TABLE negocios_tarjetas(
	 id_negocio VARCHAR(255) PRIMARY KEY,
	 id_tarjeta VARCHAR(255) PRIMARY KEY
);
