 -- CREATE DATABASE Tarea02;
USE Tarea02;
/*
create table vuelo(nro_vuelo smallint not null primary key,
					desde varchar(40) not null,
                    hasta varchar(40) not null,
                    fecha date,
                    nro_avion smallint,
                    foreign key (nro_avion) references avion(nro_avion)
                    );
insert into vuelo (nro_vuelo,desde,hasta,fecha,nro_avion) values
(1,'Argentina','Estados Unidos','2021-06-22',1),
(2,'Buenos Aires','Florida','2021-03-21',2),
(3,'Florida','Buenos Aires','2022-07-13',3);

create table avion (nro_avion smallint not null primary key,
					tipo_avion varchar(40) not null,
                    modelo varchar(40) not null
                    );
insert into avion(nro_avion,tipo_avion,modelo) values
(1,'Mercaderia','B12'),
(2,'Pasajero','B14'),
(3,'Pasajero','B15');

create table pasajero(nro_vuelo smallint not null,
					doc smallint not null primary key,
                    nombre varchar(40) not null,
                    foreign key (nro_vuelo) references vuelo(nro_vuelo)
                    );
                    
insert into pasajero (nro_vuelo,doc,nombre) values
(1,34567876,'Alejandro'),
(2,41693526,'Leandro'),
(3,43543677,'Kayra');
*/
/*
Vuelo (nro_vuelo, desde, hasta, fecha, nro_avion)
Avion(nro_avion, tipo_avion, modelo)
Pasajero(nro_vuelo, documento, nombre)
*/
-- --------------------------------------------------------------------
/*Vuelo (nro_vuelo, desde, hasta, fecha, nro_avion)
Avion(nro_avion, tipo_avion, modelo)
Pasajero(nro_vuelo, documento, nombre)*/
-- 1Hallar los números de vuelo desde el origen A hasta el destino F
select v.nro_vuelo
		from vuelo v
        where v.desde='A' and v.hasta='F';
-- 2Hallar los nombres de pasajeros y números de vuelo para aquellos pasajeros que viajan desde A a D.
select p.nombre, p.nro_vuelo
	from pasajero p join vuelvo v on p.nro_vuelo=v.nro_vuelo
    where v.desde='A' and v.hasta='D';
-- 3Hallar los tipos de avión para vuelos que parten desde C.
select a.tipo_avion
		from avion join vuelo v on a.nro_avion=v.nro_avion
        where v.desde='C';
-- 4Listar los distintos tipo y nro. de avión que tienen a H como destino
select a.tipo_avion, a.nro_avion
	from avion a 
    where a.hasta='H';
-- 5Mostrar por cada Avión (número y modelo) la cantidad de vuelos en que se encuentra registrado.
select a.nro_avion, a.modelo, count(*)
	from avion a join vuelo v on a.nro_vuelo=v.nro_vuelo
    group by a.nro, a.modelo;
-- 6Cuántos pasajeros diferentes han volado en un avión de modelo ‘B-777’
select distinct count(*)
	from pasajero p 
    where nro_vuelo=(select nro_vuelo v 
							from vuelo join avion on a.nro_avion=v.nro_avion
							where a.modelo='B-777');
-- 7Listar la cantidad promedio de pasajeros transportados por los aviones de la compañía, por tipo de avión.
SELECT vcp.tipo_avion, AVG(cant_pasajeros) PROM
	FROM (SELECT avion.tipo_avion, COUNT(*) cant_pasajeros
			 FROM avion JOIN vuelo ON avion.nro_avion = vuelo.nro_avion
			 JOIN pasajero ON vuelo.nro_vuelo = pasajero.nro_vuelo
			 GROUP BY pasajero.nro_vuelo, avion.tipo_avion) vcp
	GROUP BY vcp.tipo_avion;

-- 8Hallar los tipos de avión que no son utilizados en algún vuelo que pase por B.
select a.tipo_avion 
	 from avion a join vuelo v on a.nro_avion=v.nro_avion
     where a.nro_avion NOT IN (SELECT nro_avion
			 FROM vuelo
			 WHERE (desde = 'B'
			 OR hasta = 'B')
			 AND v.nro_avion = a.nro_avion)
		GROUP BY a.nro_avion;
     
                