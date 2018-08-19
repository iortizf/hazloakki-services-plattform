CREATE TABLE cuenta (
  id VARCHAR(255) PRIMARY KEY,
  apellidos varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  estatus  BOOLEAN NOT NULL DEFAULT FALSE,
  fecha varchar(255) DEFAULT NULL,
  nombre varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  telefono varchar(255) DEFAULT NULL
);

