CREATE TABLE analitica_ofertas (
  id VARCHAR(255) PRIMARY KEY,
  id_oferta VARCHAR(255),
  id_negocio VARCHAR(255),
  estatus  BOOLEAN NOT NULL DEFAULT FALSE,
  num_vistas NUMERIC,
  num_megusta NUMERIC,
  num_nogusta NUMERIC,
  num_compartir NUMERIC,
  num_click NUMERIC,
  num_comentarios NUMERIC,
  num_comentarios_negativos NUMERIC,
  num_visualizacion_fotos NUMERIC,
  ubicacion_segmentada varchar(1000) DEFAULT NULL,
  sexo_femenino NUMERIC,
  sexo_masculino NUMERIC
);