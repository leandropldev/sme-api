CREATE TABLE CUSTOMER(
	ID NUMBER(10) NOT NULL,
	NAME VARCHAR2(100) NOT NULL,
	EMAIL VARCHAR2(100) NOT NULL,
	CREATED_DATE DATE NOT NULL,
	CONSTRAINT CUSTOMER_PK PRIMARY KEY (ID)
);

CREATE SEQUENCE SMEAPI.SEQ_FILTRO
START WITH     1
INCREMENT BY   1
CACHE 500
NOCYCLE;
 
CREATE SEQUENCE SMEAPI.SEQ_CANAL
START WITH     1
INCREMENT BY   1
CACHE 500
NOCYCLE;
 
CREATE SEQUENCE SMEAPI.SEQ_MENU
START WITH     1
INCREMENT BY   1
CACHE 500
NOCYCLE;
 
CREATE SEQUENCE SMEAPI.SEQ_DDD
START WITH     1
INCREMENT BY   1
CACHE 500
NOCYCLE;
 
CREATE SEQUENCE SMEAPI.SEQ_REGIONAL
START WITH     1
INCREMENT BY   1
CACHE 500
NOCYCLE;
 
CREATE SEQUENCE SMEAPI.SEQ_CNL
INCREMENT BY   1
CACHE 500
NOCYCLE;
 
CREATE SEQUENCE SMEAPI.SEQ_SEGMENTO
INCREMENT BY   1
CACHE 500
NOCYCLE;
 
CREATE SEQUENCE SMEAPI.SEQ_CICLOFATURAMENTO
INCREMENT BY   1
CACHE 500
NOCYCLE;

CREATE SEQUENCE SMEAPI.SEQ_STATUSLINHA
INCREMENT BY   1
CACHE 500
NOCYCLE;

CREATE SEQUENCE SMEAPI.SEQ_MENSAGEM
INCREMENT BY   1
CACHE 500
NOCYCLE;

CREATE SEQUENCE SMEAPI.SEQ_CONJUNCAO
INCREMENT BY   1
CACHE 500
NOCYCLE;