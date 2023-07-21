/*Auto (patente, modelo, año)
Chofer (nro_chofer, nombre, fecha_ingreso, telefono)
Viaje (nro_chofer, nro_cliente, patente, fecha, km_totales, tiempo_espera)
Cliente (nro_cliente, nombre, domicilio, localidad)*/
-- 1. Cuál es el tiempo de espera promedio de los viajes del año 2005?
SELECT AVG(viaje.tiempo_espera) as prom_tiempo_espera
		FROM viaje
		WHERE viaje.fecha LIKE '2021%';
-- 2. Listar el nombre de los clientes que hayan viajado en todos los autos.
/*Division*/
	SELECT c.nombre
	FROM cliente c JOIN viaje v ON c.nro_cliente = v.nro_cliente
	WHERE v.patente IN (SELECT auto.patente
							FROM auto
							GROUP BY auto.patente);

	SELECT c.nombre
	FROM cliente c JOIN viaje v ON c.nro_cliente = v.nro_cliente
    group by c.nro_cliente
	having count(*)=(SELECT max(total)
							FROM (select count(*)as 'total'
									from auto
                                    group by patente)alias);
-- 3. Listar nombre y teléfono de los choferes que no manejaron algún vehículo de modelo posterior al año 2010.
SELECT chofer.nombre, chofer.telefono
	FROM chofer JOIN viaje ON chofer.nro_chofer = viaje.nro_chofer
	JOIN auto ON viaje.patente = auto.patente
	WHERE auto.anio NOT IN (SELECT auto.anio
							FROM auto
							WHERE auto.anio < 2010)
	GROUP BY chofer.nro_chofer;

-- 4. Listar los kilómetros realizados en viajes por cada auto (patente y modelo)
SELECT auto.patente, auto.modelo, SUM(viaje.km_totales)
	FROM auto JOIN viaje ON auto.patente = viaje.patente
	GROUP BY auto.patente;
-- 5. Mostrar el el costo promedio de los viajes realizados por cada auto (patente), para viajes de clientes de la localidad de Ramos Mejía.
SELECT viaje.patente, AVG(viaje.tiempo_espera)
	FROM viaje JOIN cliente ON viaje.nro_cliente = cliente.nro_cliente
	WHERE cliente.localidad = 'Ramos Mejía'
	GROUP BY viaje.patente;

-- 6. Listar el costo total de los viajes realizados por cada chofer (número y nombre) cuyo nombre comienza con la letra A.
SELECT chofer.nro_chofer, chofer.nombre, SUM(viaje.km_totales)
		FROM chofer JOIN viaje ON chofer.nro_chofer = viaje.nro_chofer
		WHERE chofer.nombre LIKE 'C%'
		GROUP BY chofer.nro_chofer;
-- 7. Mostrar la fecha de ingreso, el nombre del chofer y nombre de cliente, que hayan realizado el viaje más largo de la historia.
SELECT chofer.nombre AS chofer, cliente.nombre AS cliente, chofer.fecha_ingreso
	FROM chofer JOIN viaje ON chofer.nro_chofer = viaje.nro_chofer
	JOIN cliente ON viaje.nro_cliente = cliente.nro_cliente
	WHERE viaje.km_totales = (SELECT MAX(viaje.km_totales)
								FROM viaje);