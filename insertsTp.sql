USE tpVentas;

INSERT INTO cliente VALUES (123, 234, 'pinyero', 'enrique'),
						   (456, 245, 'martinez', 'gonzalo'),
                           (789, 478, 'fica', 'enzo');
INSERT INTO cliente VALUES (420, 305, 'hernandez', 'sofia');
                           
INSERT INTO factura VALUES (1030, 123, '2020-10-20', 10),
						   (1031, 456, '2021-09-15', 11),
                           (1029, 789, '2019-04-19', 09);
                           
INSERT INTO factura VALUES (1032, 456, '2022-02-12', 13);
                           
INSERT INTO producto VALUES (1223, 420, 'notebook', 124),
							(7898, 452, 'smartTv', 423),
                            (7885, 412, 'bicicleta', 123);
                            
INSERT INTO precio VALUES (124, 140000.0, '2020-10-20', 1223),
						  (423, 80000.0, '2021-09-15', 7898),
                          (123, 35000.0, '2019-04-19',7885);
                          
INSERT INTO precio VALUES (125, 180000.0, '2021-08-16', 1223);
                          
INSERT INTO factura_producto VALUES (1030, 1223, 5),
									(1031, 7898, 3),
                                    (1029, 7885, 2);

INSERT INTO factura_producto VALUES (1032, 1223, 1);

-- 3
-- SELECT codigo, apellido, nombre, numero, fecha
-- FROM cliente INNER JOIN factura;

/*4. Realizar una consulta que detalle el historial de precios de un producto en particular
identificado por código.*/
-- SELECT monto, fecha, codigo
-- FROM producto 
-- INNER JOIN precio
-- WHERE producto.id_producto = precio.id_producto AND codigo = 'PUT';

/*5. Realizar una consulta que retorne la cantidad total de ventas de cada producto
ordenado de mayor a menor.*/
SELECT id_producto, SUM(cantidad) AS cantTotal
FROM factura_producto 
GROUP BY id_producto
ORDER BY cantTotal DESC;
-- forma franco 
SELECT producto.id_producto, SUM(cantidad) AS cantidad_de_ventas
FROM factura_producto INNER JOIN producto 
WHERE factura_producto.id_producto = producto.id_producto
GROUP BY id_producto
ORDER BY cantidad_de_ventas DESC; 

/*6. Realizar una consulta que retorne el monto total de ventas de cada producto
ordenado de mayor a menor.*/
SELECT  SUM(cantidad)*monto AS cantTotal
FROM factura_producto 
INNER JOIN precio
GROUP BY monto
ORDER BY cantTotal DESC;

# Ejercicio 6
SELECT producto.id_producto, SUM(monto*cantidad) AS monto_total
FROM factura_producto 
INNER JOIN producto 
INNER JOIN precio
WHERE factura_producto.id_producto = producto.id_producto AND producto.id_precio = precio.id_precio
GROUP BY producto.id_producto
ORDER BY monto_total DESC;

-- Ejercicio 7 
-- 7. Realizar una consulta que retorne la cantidad total de facturas por cliente ordenado
-- de mayor a menor incluyendo clientes que no tengan facturas cuya cantidad total será 0.
SELECT cliente.id_cliente, nombre, apellido, COUNT(cliente.id_cliente = factura.id_cliente) AS cantTotal
FROM cliente 
LEFT JOIN factura
ON cliente.id_cliente = factura.id_cliente
GROUP BY cliente.id_cliente
ORDER BY cantTotal DESC; 

-- 8. Realizar una vista llamada compras que retorne código, apellido y nombre del cliente,
-- número y fecha de todas las facturas, código, descripción, precio unitario, cantidad y
-- precio total de los productos incluidos en cada factura.
CREATE or replace VIEW view_compras 
AS SELECT cliente.codigo as cliente_codigo, apellido, nombre, numero, factura.fecha, producto.codigo, descripcion, monto, (monto * cantidad) AS precio_total
FROM cliente
INNER JOIN factura 
INNER JOIN precio
INNER JOIN producto
INNER JOIN factura_producto
ON cliente.id_cliente = factura.id_cliente
AND factura.id_factura = factura_producto.id_factura
AND factura_producto.id_producto = producto.id_producto
AND producto.id_precio = precio.id_precio 
GROUP BY (cliente_codigo);

-- 9. Realizar una consulta sobre la vista compras para un cliente en particular identificado por código.

SELECT * 
FROM view_compras
WHERE cliente_codigo = 478;

SELECT apellido
FROM view_compras
WHERE apellido LIKE '%ica%';

SELECT * FROM cliente;
SELECT * FROM precio;
SELECT * FROM producto;
DELETE FROM precio WHERE (id_precio = 1000);

-- 14
DELIMITER $$
CREATE PROCEDURE nueva_factura
(IN codigo_cliente INT, IN fecha_de_compra DATETIME, IN numero int, out id_out int)
BEGIN
declare exit handler for sqlexception rollback;
	start transaction;
INSERT INTO factura (id_cliente, fecha, numero) 
VALUES (codigo_cliente, fecha_de_compra, numero);
set id_out = last_insert_id();
commit;
END $$

DELIMITER $$
create procedure nueva_factura_producto
(IN p_id_de_factura INT, IN p_codigo_de_producto INT, IN p_cantidad_comprada INT)
begin
  declare exit handler for sqlexception rollback;
  start transaction;
    insert into factura_producto (id_factura, id_producto, cantidad) values (p_id_de_factura, p_codigo_de_producto, p_cantidad_comprada);
  commit;
end $$

select *from factura;

