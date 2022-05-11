DROP DATABASE IF EXISTS tpVentas;
CREATE DATABASE tpVentas;
USE tpVentas;
CREATE TABLE cliente (
	id_cliente INT PRIMARY KEY,
    codigo VARCHAR(255),
    apellido VARCHAR(255),
    nombre VARCHAR(255)
);

 CREATE INDEX idx_id_cliente ON cliente (id_cliente);

CREATE TABLE factura (
	id_factura INT ,
    id_cliente INT ,
    fecha DATETIME,
    numero INT,
    PRIMARY KEY(id_factura, id_cliente),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
);

CREATE TABLE producto (
	id_producto INT,
    codigo VARCHAR(16),
    descripcion VARCHAR(256),
    id_precio INT,
    PRIMARY KEY(id_producto)
);



CREATE TABLE factura_producto (
	id_factura INT,
    id_producto INT,
    cantidad INT,
    PRIMARY KEY(id_factura, id_producto),
    FOREIGN KEY (id_factura) REFERENCES factura (id_factura),
    FOREIGN KEY (id_producto) REFERENCES producto (id_producto)
);

CREATE TABLE precio (
	id_precio INT,
    monto DECIMAL(8.2),
    fecha DATE,
    id_producto INT,
    PRIMARY KEY(id_precio),
    FOREIGN KEY (id_producto) REFERENCES producto (id_producto)
);

ALTER TABLE producto 
ADD CONSTRAINT FOREIGN KEY (id_precio) REFERENCES precio(id_precio);
-- SELECT * FROM precio;

-- 3. Realizar una consulta que retorne: código, apellido y nombre del cliente, el número y
-- la fecha de sus facturas.
-- SELECT codigo, apellido, nombre, numero, fecha 
-- FROM cliente, factura;  