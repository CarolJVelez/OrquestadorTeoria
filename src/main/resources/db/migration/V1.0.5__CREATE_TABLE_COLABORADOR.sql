CREATE TABLE MA_COLABORADOR
(
   COLABORADOR_ID    SERIAL primary key        NOT NULL,
   NOMBRE                   VARCHAR(100)       NOT NULL,
   MARCA_COMERCIAL          VARCHAR(100)       NOT NULL,
   NIT                      VARCHAR(30)        NOT NULL,
   DIRECCION                VARCHAR(100)       NOT NULL,
   CONCEDENTE               VARCHAR(100)       NOT NULL,
   CONTRATO_CONCESION       VARCHAR(100)       NOT NULL,
   NOMBRE_CONCESIONARIO     VARCHAR(100)       NOT NULL,
   NIT_CONCESIONARIO        VARCHAR(30)        NOT NULL,
   DIRECCION_CONCESIONARIO  VARCHAR(100)       NOT NULL,
   CODIGO                   VARCHAR(3)         NOT NULL,
   ACTIVO                   BOOLEAN            NOT NULL
 );