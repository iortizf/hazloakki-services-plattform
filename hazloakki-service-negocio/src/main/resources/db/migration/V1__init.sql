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
  id_metodo_pago NUMERIC,
  tipo_tarjeta_credito varchar(45) DEFAULT NULL,
  servicio_domicilio BOOLEAN NOT NULL DEFAULT FALSE,
  estacionamiento BOOLEAN NOT NULL DEFAULT FALSE,
  wifi BOOLEAN NOT NULL DEFAULT FALSE,
  reservaciones BOOLEAN NOT NULL DEFAULT FALSE,
  modo_llevar BOOLEAN NOT NULL DEFAULT FALSE,
  estatus BOOLEAN NOT NULL DEFAULT FALSE,
  internet BOOLEAN NOT NULL DEFAULT FALSE,
  id_cuenta varchar(255) DEFAULT NULL
);

