-- DDL

-- CREATE DATABASE Tarea01;
USE Tarea01;
create table if not exists almacen (	nro smallint primary key not null,
						nombre varchar(30) not null ,
						responsable varchar(30) not null);
insert into almacen (nro,nombre,responsable) values
(0,'Chubut', 'Juanito'),
(1,'Rosario', 'Alberto'),
(2,'La Plata', 'Gaston'),
(3,'Capital Federal', 'Martín Gómez'),
(4,'Zarate', 'Fernando'),
(5,'Almacen 10', 'Juan Carlos'),
(6,'Almacen 20', 'Pepe');

create table if not exists articulo (	cod_art smallint primary key not null,
						descripcion varchar(30)not null,
						precio decimal(10,2) not null);
insert into articulo (cod_art,descripcion,precio) values
(0,'Licuadora', '500.00'),
(1,'Heladera', '23000.00'),
(2,'Aire  Acondicionado', '20000.00'),
(3,'TV 23\"', '15000.00'),
(4,'TV 24\"', '17000.00'),
(5,'TV 32\"', '25000.00'),
(6,'PC', '40000.00'),
(7,'PC2', '50000.00'),
(8,'Aspiradora', '7000.00'),
(9,'Aspiradora 2', '8900.00'),
(10,'Escritorio ', '35000.00'),
(11,'Exprimidora',500.00);

create table if not exists material (cod_mat smallint primary key not null,
						descripcion varchar(30)not null);
insert into material (cod_mat, descripcion) values
(1, 'Material 1'),
(2, 'Material 2'),
(3, 'Material 3'),
(4, 'Componente 4'),
(5, 'Componente 5'),
(6, 'Componente 6'),
(7, 'Material 7'),
(8, 'Material 8'),
(9, 'Componente 9'),
(10, 'Componente 10'),
(18, 'Material 18');
drop table ciudad;
create table if not exists ciudad (	cod_ciu smallint primary key not null,
						nombre varchar(30) not null);
insert into ciudad (cod_ciu, nombre) values
(1, 'La Plata'),
(3, 'Cordoba'),
(4, 'Capital Federal '),
(7, 'Misiones'),
(8, 'Viedma'),
(20, 'Rosario'),
(25, 'Zarate');
drop table proveedor;
create table if not exists proveedor (cod_prov smallint primary key not null,
						nombre varchar(30) not null,
                        domicilio varchar(50),
                        fecha_alta date,
                        cod_ciu smallint not null,
						foreign key (cod_ciu) references ciudad(cod_ciu));
insert into proveedor (cod_prov, nombre, domicilio, fecha_alta, cod_ciu) values
(1, 'Pepito Hermanos', '', '2021-05-22', 25),
(2, 'Pollo Loco Hermanos', 'domicilio2', '2021-05-22',3),
(15, 'Los hermanos rosarinos', 'domicilio3', '2021-05-02', 20),
(10, 'Los hermanos de la Plata', 'En Suipacha, pero no en 2001', '2021-03-03', 1),
(100, 'Los de Suipacha', 'Suipacha y Cangallo (Si es correcto)', '2001-05-02', 4);

create table if not exists contiene(nro smallint  not null,
						cod_art smallint not null,
                        foreign key (nro) references almacen(nro),
                        foreign key(cod_art) references articulo(cod_art));
INSERT INTO contiene (nro, cod_art) VALUES
(0, 0),
(0, 1),
(0, 2),
(0, 3),
(0, 4),
(1, 5),
(1, 6),
(1, 7),
(2, 8),
(2, 9); 
create table if not exists compuesto_por(	cod_art smallint   not null,
							cod_mat smallint  not null,
							foreign key(cod_art) references articulo(cod_art),
                            foreign key(cod_mat) references material(cod_mat));
INSERT INTO `Compuesto_por` (`cod_art`, `cod_mat`) VALUES
(0, 1),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 6),
(6, 7),
(7, 8),
(8, 9),
(9, 10);
drop table provisto_por;
create table if not exists provisto_por(	cod_mat smallint  not null,
							cod_prov smallint  not null,
                            foreign key(cod_mat)references material(cod_mat),
                            foreign key(cod_prov)references proveedor(cod_prov));
INSERT INTO provisto_por (cod_prov, cod_mat) VALUES
(1,2),
(1,3),
(15,2),
(15,4),
(10,8),
(100,5),
(1,7),
(2,9);
-- ---------------------------------------------------------------
/*
Almacen (nro, nombre, responsable)
Articulo (cod_art, descripción, precio)
Material (cod_mat, descripción)
Proveedor (cod_prov, nombre, domicilio, cod_ciu, fecha_alta)
Ciudad (cod_ciu, nombre)
Contiene (nro, cod_art)
Compuesto_por (cod_art, cod_mat)
Provisto_por (cod_mat, cod_prov)
*/
-- 1 Listar los números de artículos cuyo precio se encuentre entre $100 y $1000 y su descripción comience con la letra A
   SELECT cod_art , descripcion
				FROM articulo 
                WHERE precio BETWEEN 100 
                AND 1000 AND descripcion LIKE 'A%' ;
-- 2 Listar todos los datos de todos los proveedores   
   SELECT * 
			FROM proveedor;
-- 3Listar la descripción de los materiales de código 1, 3, 6, 9 y 18.
   SELECT descripcion 
			FROM material 
            WHERE cod_mat IN (1,3,6,9,18);
-- 4Listar código y nombre de proveedores de la calle Suipacha, que hayan sido dados  de alta en el año 2001.
   SELECT cod_prov, nombre 
			FROM proveedor 
            WHERE domicilio 
            LIKE '%Suipacha%' 
            AND fecha_alta<'2002-01-01' AND fecha_alta>='2001-01-01';
-- 5Listar nombre de todos los proveedores y de su ciudad. (Forma Explicita) (Usa 2 tablas)
   SELECT PRO.nombre, CIU.nombre 
			FROM proveedor PRO 
            LEFT JOIN ciudad CIU ON PRO.cod_ciu=CIU.cod_ciu;
-- 6Listar los nombres de los proveedores de la ciudad de La Plata. (Forma implicita) (Usa 2 tablas)
   SELECT pro.nombre, ciu.nombre 
			FROM proveedor pro, ciudad ciu 
            WHERE pro.cod_ciu= ciu.cod_ciu 
            AND ciu.nombre='La Plata';
-- 7Listar los números de almacenes que almacenan el artículo de descripción A (Usa 3 tablas)
   SELECT AL.nro 
				FROM almacen AL 
                JOIN contiene C ON AL.nro=C.nro 
                JOIN articulo ART ON ART.cod_art=C.cod_art 
                WHERE ART.descripcion='A';
-- 8Listar los materiales (código y descripción) provistos por proveedores de la ciudad de Rosario
   SELECT M.cod_mat, M.descripcion 
				FROM material M 
                JOIN provisto_por P ON M.cod_mat=P.cod_mat 
                JOIN proveedor Pro ON Pro.cod_prov=P.cod_prov 
				JOIN ciudad CIU ON Pro.cod_ciu=CIU.cod_ciu 
                WHERE CIU.nombre='Rosario';
-- 9Listar los nombres de los proveedores que proveen materiales para artículos ubicados en almacenes que Martín Gómez tiene a su cargo.
   SELECT DISTINCT PRO.nombre 
				FROM proveedor PRO 
                JOIN provisto_por P ON PRO.cod_prov=P.cod_prov 
                JOIN material M ON P.cod_mat=M.cod_mat
				JOIN compuesto_por COM ON M.cod_mat=COM.cod_mat 
                JOIN articulo ART ON ART.cod_art=COM.cod_art 
				JOIN contiene C ON ART.cod_art=C.cod_art 
                JOIN almacen ALM ON ALM.nro=C.nro 
                WHERE ALM.responsable LIKE '%Martin%Gomez%';
-- 10 Mover los artículos almacenados en el almacén de número 10 al de número 20.
	UPDATE contiene
			SET nro=20
            WHERE nro=10;
-- 11 Eliminar a los proveedores que contengan la palabra ABC en su nombre
	DELETE FROM proveedor 
		WHERE  nombre LIKE '%ABC%';
	
-- 12 Indicar la cantidad de proveedores que comienzan con la letra F
   SELECT count(*) as 'Nombres con F' 
				FROM proveedor 
                WHERE nombre LIKE 'F%';
-- 13Listar el promedio de precios de los artículos por cada almacén (nombre)
   SELECT ALM.nombre as'Almacenes',  AVG(ART.precio) as'PrecioPromedio' 
				FROM almacen ALM 
                JOIN contiene C ON ALM.nro=C.nro 
                JOIN articulo ART ON ART.cod_art=C.cod_art 
                GROUP BY ALM.nro, ALM.nombre;
-- 14Listar la descripción de artículos compuestos por al menos 2 materiales
   SELECT A.descripcion 
				FROM articulo A 
                JOIN compuesto_por C ON A.cod_art=C.cod_art 
                GROUP BY A.cod_art, A.descripcion 
                HAVING COUNT(*)>=2;
-- 15Listar cantidad de materiales que provee cada proveedor (código, nombre y domicilio)
   SELECT p.cod_prov, p.nombre, p.domicilio, 
   COUNT(pp.cod_mat) AS 'cantidad de materiales' 
				FROM proveedor p 
                LEFT JOIN provisto_por pp ON p.cod_prov = pp.cod_prov 
                GROUP BY p.cod_prov, p.nombre, p.domicilio;
-- 16Cuál es el precio máximo de los artículos que proveen los proveedores de la ciudad de Zárate
SELECT max(a.precio) FROM proveedor p 
				JOIN provisto_por pp ON p.cod_prov = pp.cod_prov
				JOIN compuesto_por cp ON pp.cod_mat = cp.cod_mat
				JOIN articulo a ON cp.cod_art = a.cod_art
				JOIN ciudad c ON c.cod_ciu = p.cod_ciu
				WHERE c.nombre = 'Zarate';
-- 17Listar los nombres de aquellos proveedores que no proveen ningún material
SELECT P.nombre 
				FROM proveedor P 
                WHERE NOT EXISTS (SELECT 1 
										FROM Provisto_por pp 
                                        WHERE pp.cod_prov=P.cod_prov);
-- 18Listar los códigos de los materiales que provea el proveedor 10 y no los provea el proveedor 15.
SELECT pp.cod_mat 
				FROM provisto_por pp 
                WHERE pp.cod_prov=10 
                AND pp.cod_mat NOT IN(SELECT pp2.cod_mat 
											FROM provisto_por pp2 
                                            WHERE pp2.cod_prov=15);
-- 19Listar número y nombre de almacenes que contienen los artículos de descripción A y los de descripción B (ambos).
SELECT a.nro, a.nombre 
				FROM almacen a 
                WHERE a.nro IN (SELECT c.nro 
										FROM contiene c 
                                        JOIN articulo a ON c.cod_art=a.cod_art 
                                        WHERE a.descripcion='A') 
				AND a.nro IN (SELECT c.nro 
										FROM contiene c 
                                        JOIN articulo a ON c.cod_art=a.cod_art 
                                        WHERE a.descripcion='B');
-- 20)Listar la descripción de artículos compuestos por todos los materiales.
SELECT a.descripcion 
				FROM articulo a 
                JOIN compuesto_por cp ON a.cod_art=cp.cod_art 
                GROUP BY a.cod_art, a.descripcion 
                HAVING COUNT (cp.cod_mat)=(SELECT(cod_mat) 
													FROM material);
-- 21Hallar los códigos y nombres de los proveedores que proveen al menos un material que se usa en algún artículo cuyo precio es mayor a $100.
SELECT p.cod_prov, p.nombre 
				FROM proveedor p 
                WHERE EXISTS (SELECT 1 
									FROM provisto_por pp 
                                    WHERE p.cod_prov=pp.cod_prov 
                                    AND EXISTS (SELECT 1 
														FROM compuesto_por cp 
                                                        JOIN articulo a ON cp.cod_art=a.cod_art 
                                                        WHERE a.precio>100 AND pp.cod_mat=cp.cod_mat));
-- 22Listar la descripción de los artículos de mayor precio.
SELECT a.descripcion 
				FROM articulo a
				WHERE precio=(SELECT MAX(precio) 
									FROM articulo);
-- 23)Listar los nombres de proveedores de Capital Federal que sean únicos proveedores de algún material.
SELECT p.nombre
				FROM proveedor p JOIN ciudad c ON p.cod_ciu= c.cod_ciu
                WHERE c.nombre='Capital Federal' 
                AND p.cod_prov IN (SELECT MIN(pp.cod_prov)
										FROM provisto_por pp
                                        group by pp.cod_mat
                                        having count(*)=1);
-- 24Listar los nombres de almacenes que almacenan la mayor cantidad de artículos.
SELECT a.nombre
				from almacen a join contiene c on a.nro=c.nro
                group by a.nro, a.nombre
                having count(*)=(SELECT MAX(total)
								from(select count(*)total
								from contiene c 
                                group by c.nro)
                                alias);

-- 25Listar la ciudades donde existan proveedores que proveen todos los materiales
SELECT c.nombre
			FROM ciudad c join proveedor p on c.cod_ciu= p.cod_ciu
            group by c.nombre
            having count(*)=(SELECT MAX(total)
								from(select count(*) total
								from provisto_por pp
								group by pp.cod_mat)
								alias);
-- 26Listar los números de almacenes que tienen todos los artículos que incluyen el material con código 123.
SELECT a.nro 
	from almacenes a join contiene c  on a.cod_art=c.cod_art
    group by numeroDeAlmacen
    having count(*)=(SELECT art.cod_art 
		from articulo art join compuesto_por cp on art.cod_art=cp.cod_art
        where  cp.cod_mat=123);
    





