CREATE TABLE DE_CHANCE_PRODUCTO
(
   CHANCE_PROCUTO_ID    SERIAL primary key NOT NULL,
   CHANCE_ID            BIGINT             NOT NULL,
   NUMERO_APOSTADO      VARCHAR(30)        NOT NULL,
   VALOR_APOSTADO       INTEGER            NOT NULL,
   MODO_JUEGO           VARCHAR(30)        NOT NULL
 );

 ALTER TABLE DE_CHANCE_PRODUCTO
 ADD CONSTRAINT FK_TR_CHANCE FOREIGN KEY (CHANCE_ID) REFERENCES TR_CHANCE (CHANCE_ID);