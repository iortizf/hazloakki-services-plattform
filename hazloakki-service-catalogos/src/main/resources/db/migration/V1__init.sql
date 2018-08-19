CREATE TABLE cat_categoria_negocios (
  id_categoria NUMERIC PRIMARY KEY,
  nombre varchar(255) DEFAULT NULL,
  descripcion varchar(255) DEFAULT NULL,
  estatus  BOOLEAN NOT NULL DEFAULT FALSE,
  fecha varchar(255) DEFAULT NULL
);

INSERT INTO cat_categoria_negocios (id_categoria,nombre,descripcion,estatus,fecha) VALUES (1,'restaurante','restaurante de mariscos',true,'2018-07-07');
INSERT INTO cat_categoria_negocios (id_categoria,nombre,descripcion,estatus,fecha) VALUES (2,'hotel','hotel 5 estrellas',true,'2018-07-07');


