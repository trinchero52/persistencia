CREATE DATABASE tp2Hibernate;
USE tp2Hibernate;

CREATE TABLE cuenta (
	id_cuenta INT NOT NULL AUTO_INCREMENT,
    numero VARCHAR (256),
    id_cliente LONG,
    PRIMARY KEY (id_cuenta)
);

CREATE TABLE cliente (
	id_cliente INT NOT NULL AUTO_INCREMENT,
    codigo VARCHAR (256),
    apellido VARCHAR (256),
    nombre VARCHAR (256),
    id_cuenta INT,
    LIST 
);