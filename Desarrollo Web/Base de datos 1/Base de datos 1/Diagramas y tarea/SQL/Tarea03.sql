Create database if not exists Tarea03;

use Tarea03;

create table producto(id_producto int not null primary key,
					descripcion varchar(40),
                    estado varchar(40),
                    id_proveedor int,
                    foreign key (id_proveedor)references proveedor(id_proveedor)
                    );
create table proveedor(id_proveedor int not null primary key,
						nombre varchar(40) not null,
                        cuit int not null
						);
create table cliente(id_cliente int not null primary key,
					nombre varchar(40) not null
                    );
                    
-- ------------------------------------------------
/*Producto (id_producto, descripcion, estado, id_proveedor)
Proveedor (id_proveedor, nombre, cuit)
Cliente (id_cliente, nombre)
Vendedor (id_empleado, nombre, apellido, dni)
Venta (nro_factura, id_cliente, fecha, id_vendedor)
Detalle_Venta (nro_factura, nro_detalle, id_producto, cantidad, precio_unitario)*/
-- 1. Listar la cantidad de productos que tiene la empresa.
SELECT COUNT(producto.id_producto) AS cant_productos
FROM producto;
-- 2. Listar la descripción de productos en estado 'en stock' que tiene la empresa.
SELECT producto.descripcion
	FROM producto
	WHERE estado = 'activo';
-- 3. Listar los productos que nunca fueron vendidos.
SELECT producto.id_producto
	FROM producto
	WHERE producto.id_producto NOT IN (SELECT detalle_venta.id_producto
	 FROM detalle_venta);
-- 4. Listar la cantidad total de unidades que fueron vendidas de cada producto (descripción).
SELECT producto.descripcion, SUM(detalle_venta.cantidad) AS cant_vendida
	FROM producto JOIN detalle_venta ON producto.id_producto = detalle_venta.id_producto
	GROUP BY producto.descripcion;

-- 5. Listar el nombre de cada vendedor y la cantidad de ventas realizadas en el año 2015.
SELECT vendedor.nombre, COUNT(venta.nro_factura) AS cant_ventas
	FROM vendedor JOIN venta ON vendedor.id_vendedor = venta.id_vendedor
	WHERE venta.fecha LIKE '2015%'
	GROUP BY vendedor.nombre;
-- 6. Listar el monto total vendido por cada cliente (nombre)
SELECT cliente.nombre, SUM(detalle_venta.precio_unitario * detalle_venta.cantidad) AS cant_comprada
	FROM cliente JOIN venta ON cliente.id_cliente = venta.id_cliente
	JOIN detalle_venta ON venta.nro_factura = detalle_venta.nro_factura
	GROUP BY cliente.nombre;
-- 7. Listar la descripción de aquellos productos en estado ‘sin stock’ que se hayan vendido en el mes de Enero de 2015
SELECT producto.descripcion
	FROM producto JOIN detalle_venta ON producto.id_producto = detalle_venta.id_producto
	JOIN venta ON detalle_venta.nro_factura = venta.nro_factura
	WHERE venta.fecha LIKE '2015-01%'
	AND producto.estado = 'Sin stock';
