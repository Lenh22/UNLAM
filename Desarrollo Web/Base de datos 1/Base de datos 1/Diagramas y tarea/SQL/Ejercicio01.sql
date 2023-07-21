DROP DATABASE if exists ejercicio01;
CREATE DATABASE if not exists ejercicio01;
USE ejercicio01;
 
CREATE TABLE almacen 
  ( 
     nro         SMALLINT UNSIGNED PRIMARY KEY, 
     nombre      VARCHAR(100) NOT NULL, 
     responsable VARCHAR(50)
  ); 
 
CREATE TABLE articulo 
  ( 
     cod_art     SMALLINT UNSIGNED PRIMARY KEY, 
     descripcion VARCHAR(100), 
     precio      DECIMAL(10, 2) NOT NULL 
  ); 
 
CREATE TABLE material 
  ( 
     cod_mat     SMALLINT UNSIGNED PRIMARY KEY, 
     descripcion VARCHAR(100) 
  ); 
 
CREATE TABLE ciudad 
  ( 
     cod_ciu SMALLINT UNSIGNED PRIMARY KEY, 
     nombre  VARCHAR(100) NOT NULL 
  ); 
 
CREATE TABLE proveedor 
  ( 
     cod_prov   SMALLINT UNSIGNED PRIMARY KEY, 
     nombre     VARCHAR(50) NOT NULL, 
     domicilio  VARCHAR(100), 
     cod_ciu    SMALLINT UNSIGNED, 
     fecha_alta DATE NOT NULL 
  ); 
 
ALTER TABLE proveedor 
  ADD FOREIGN KEY (cod_ciu) REFERENCES ciudad (cod_ciu); 
 
CREATE TABLE contiene 
  ( 
     nro     SMALLINT UNSIGNED, 
     cod_art SMALLINT UNSIGNED 
  ); 
 
ALTER TABLE contiene 
  ADD PRIMARY KEY (nro, cod_art); 
 
ALTER TABLE contiene 
  ADD FOREIGN KEY (nro) REFERENCES almacen(nro); 
 
ALTER TABLE contiene 
  ADD FOREIGN KEY (cod_art) REFERENCES articulo(cod_art); 
 
CREATE TABLE compuesto_por 
  ( 
     cod_art SMALLINT UNSIGNED, 
     cod_mat SMALLINT UNSIGNED 
  ); 
 
ALTER TABLE compuesto_por 
  ADD PRIMARY KEY (cod_art, cod_mat); 
 
ALTER TABLE compuesto_por 
  ADD FOREIGN KEY (cod_art) REFERENCES articulo(cod_art); 
 
ALTER TABLE compuesto_por 
  ADD FOREIGN KEY (cod_mat) REFERENCES material(cod_mat); 
 
CREATE TABLE provisto_por 
  ( 
     cod_mat  SMALLINT UNSIGNED, 
     cod_prov SMALLINT UNSIGNED 
  ); 
 
ALTER TABLE provisto_por 
  ADD PRIMARY KEY (cod_mat, cod_prov); 
 
ALTER TABLE provisto_por 
  ADD FOREIGN KEY (cod_mat) REFERENCES material(cod_mat); 
 
ALTER TABLE provisto_por 
  ADD FOREIGN KEY (cod_prov) REFERENCES proveedor(cod_prov); 
 
-- DML 
insert into almacen values (1,'A1','Martín Gómez');
insert into almacen values (2,'A2','Victor Machuca');
insert into almacen values (3,'A3','María Ángeles Zabaleta');
insert into almacen values (4,'A4','Ana Mellado');
insert into almacen values (5,'A5','Oscar Ivanov');
insert into almacen values (6,'A6','Javier Collazo');
 
insert into ciudad values (1,'Rosario');
insert into ciudad values (2,'Chascomus');
insert into ciudad values (3,'La Plata');
 
insert into articulo values (1, 'A', 100);
insert into articulo values (2, 'B', 15);
insert into articulo values (3, 'C', 150);
insert into articulo values (4, 'D', 1000);
insert into articulo values (5, 'E', 4000);
insert into articulo values (6, 'A', 5);
insert into articulo values (7, 'G', 5);
insert into articulo values (8, 'H', 4000);
 
insert into material values (1, 'M1');
insert into material values (2, 'M2');
insert into material values (3, 'M3');
insert into material values (4, 'M4');
insert into material values (5, 'M5');
insert into material values (6, 'M6');
insert into material values (7, 'M7');
insert into material values (8, 'M8');
 
insert into proveedor values (1, 'Roberto Perez', 'San Martin 189', 1, '2014-01-01');
insert into proveedor values (2, 'Karina Perez', 'Belgrano 1851', 1, '2014-01-04');
insert into proveedor values (3, 'Victor Ledesma', 'Rivadavia 690', 1, '2014-01-06');
insert into proveedor values (10, 'Juan Carlos Garcia', 'Sarmiento 2151', 2, '2014-01-01');
insert into proveedor values (15, 'Mariana Lopez', 'Suipacha 254', 2, '2001-01-07');
insert into proveedor values (20, 'Miguel Rodriguez', 'Piedras 254', 2, '2014-01-01');
insert into proveedor values (30, 'Oscar Perez', 'Av de Mayo 650', 3, '2014-01-01');
insert into proveedor values (31, 'Fernando Rivalta', 'Perón 6154', 3, '2014-01-01');
insert into proveedor values (32, 'Franco Martinez', 'Salta 333', 3, '2001-01-01');
insert into proveedor values (39, 'Maribel Gonzalez', 'Pueyrredon 1255', null, '1999-01-01');
 
insert into contiene values (1,1);
insert into contiene values (1,2);
insert into contiene values (1,4);
insert into contiene values (1,5);
insert into contiene values (3,1);
insert into contiene values (6,1);
insert into contiene values (6,4);
insert into contiene values (6,5);
insert into contiene values (6,6);
insert into contiene values (4,1);
insert into contiene values (4,2);
insert into contiene values (4,7);
insert into contiene values (4,8);
 
insert into compuesto_por values (1,1);
insert into compuesto_por values (1,4);
insert into compuesto_por values (2,1);
insert into compuesto_por values (2,2);
insert into compuesto_por values (2,3);
insert into compuesto_por values (3,5);
insert into compuesto_por values (3,1);
insert into compuesto_por values (5,2);
insert into compuesto_por values (5,5);
insert into compuesto_por values (7,2);
insert into compuesto_por values (8,1);
insert into compuesto_por values (8,2);
insert into compuesto_por values (8,3);
insert into compuesto_por values (8,4);
insert into compuesto_por values (8,5);
insert into compuesto_por values (8,6);
insert into compuesto_por values (8,7);
insert into compuesto_por values (8,8);
 
insert into provisto_por (cod_prov, cod_mat) values (1,2);
 
insert into provisto_por values (1,3);
insert into provisto_por values (2,3);
insert into provisto_por values (3,1);
insert into provisto_por values (3,3);
insert into provisto_por values (4,3);
insert into provisto_por values (5,3);
insert into provisto_por values (6,3);
insert into provisto_por values (7,3);
insert into provisto_por values (1,10);
insert into provisto_por values (2,10);
insert into provisto_por values (3,10);
insert into provisto_por values (6,10);
insert into provisto_por values (3,15);
insert into provisto_por values (4,15);
insert into provisto_por values (5,15);
insert into provisto_por values (6,15);
insert into provisto_por values (7,20);
insert into provisto_por values (1,31);
insert into provisto_por values (2,31);
insert into provisto_por values (3,31);
insert into provisto_por values (4,31);
insert into provisto_por values (5,31);
insert into provisto_por values (6,31);
insert into provisto_por values (7,31);
insert into provisto_por values (8,31);
-- ---------------------------------------------------------------------------							
select cod_art, descripcion
			from articulo
			where precio  between 100 and 1000 
            and descripcion like 'A%';
            
select *
		from proveedor;
select descripcion
		from material
        where cod_mat in (1,3,6,9,18);
select cod_prov, nombre
	from proveedor
    where  domicilio like '%Suipacha%'
		and fecha_alta between '2001-01-01' and '2002-01-01';
        
-- 5
select p.nombre, c.nombre as 'Ciudad'
			from proveedor p left join ciudad c
            on p.cod_ciu=c.cod_ciu;
select p.nombre
	from proveedor p, ciudad c 
    where p.cod_ciu=c.cod_ciu and c.nombre like 'La Plata';
    
select  distinct c.nro ,ar.descripcion
	from contiene c 
	join articulo ar on c.cod_art=ar.cod_art
	where ar.descripcion like 'A';
    
select m.cod_mat, m.descripcion
	from material m join provisto_por pp on m.cod_mat=pp.cod_mat
					join proveedor p on pp.cod_prov=p.cod_prov
                    join ciudad c on p.cod_ciu=c.cod_ciu
	where c.nombre like 'Rosario';
select  distinct p.nombre
	from proveedor p	join provisto_por pp on p.cod_prov=pp.cod_prov
-- 						join material m on pp.cod_mat=m.cod_mat
						join compuesto_por cp on pp.cod_mat=cp.cod_mat
--                      join articulo a on cp.cod_art=a.cod_art
                        join contiene c on cp.cod_art=c.cod_art
                        join almacen al on c.nro=al.nro
					where al.responsable like '%Martín%Gómez%';

update contiene 
set nro=20
where nro=10;
-- 11
delete from proveedor
where nombre like '%ABC%';
-- 12 Indicar cant de proveedores q comienzan con letra f
select count(*) as CantDeProveedorConLetraF
	from proveedor
    where nombre like "F%";
-- 13 Listar el promedio de precios de los artículos por cada almacén (nombre)
select a.nombre as 'Almacen', avg(art.precio) as 'PromedioPrecio'
	from almacen a join contiene c on a.nro=c.nro
					join articulo art on c.cod_art=art.cod_art
	group by a.nombre;

-- 14 Listar la descripción de artículos compuestos por al menos 2 materiales.
select art.descripcion
	from articulo art join compuesto_por cp on art.cod_art=cp.cod_art
    group by art.cod_art, art.descripcion
    having count(cod_mat)>=2;
-- 15 Listar cantidad de materiales que provee cada proveedor (código, nombre y domicilio)
select p.cod_prov as 'CodidoProveedor',p.nombre,p.domicilio, count(cod_mat) as 'Cantidad Productos'
	from proveedor p left join provisto_por pp on p.cod_prov=pp.cod_prov
    group by p.cod_prov;


-- 17
select p.nombre
from proveedor p
where not exists (select 1 
					from provisto_por pr
                    where pr.cod_prov=p.cod_prov);
-- manera 2
select p.nombre
from proveedor p left join provisto_por pp on p.cod_prov=pp.cod_prov
where pp.cod_mat is null;
-- 18 
select pp.cod_mat
from provisto_por pp
where pp.cod_prov=10
and not exists (select 1
				from provisto_por pp2
                where pp.cod_mat=pp2.cod_mat
                and pp2.cod_prov=15);
			
-- 19
select distinct  a.nombre, a.nro
from almacen a join contiene c on a.nro=c.nro
				join articulo ar on c.cod_art=ar.cod_art
where ar.descripcion = "A"
and exists (select 1
			 from contiene c2 join articulo ar2 on c2.cod_art = ar2.cod_art
			 WHERE a.nro = c2.nro
			 AND ar2.descripcion='B');
-- 20             
select art.descripcion
from compuesto_por cc join articulo art on cc.cod_art=art.cod_art
group by cc.cod_art, art.descripcion
having count(*) = (select count(*)
					from material);
-- 21 Hallar los códigos y nombres de los proveedores que proveen al menos un material
-- que se usa en algún artículo cuyo precio es mayor a $100.
select p.cod_prov,p.nombre
	from proveedor p 
		where exists (	select 1
						from provisto_por pp
                        where p.cod_prov=pp.cod_prov
                        and exists(select 1
									from compuesto_por cp join articulo a on cp.cod_art=a.cod_art
                                    where a.precio>100
                                    and pp.cod_mat=cp.cod_mat
									)
						);
-- 22 Listar la descripción de los artículos de mayor precio.
select a.descripcion
	from articulo a
    where precio=(select max(a2.precio)
					from articulo a2);
-- 23  Listar los nombres de proveedores de Capital Federal que sean únicos
-- proveedores de algún material.
select distinct p.nombre
	from proveedor p 	join provisto_por pp on p.cod_prov=pp.cod_prov
						join ciudad c on p.cod_ciu=c.cod_ciu
					
    where c.nombre like "Capital Federal"
	and pp.cod_mat in(select pp2.cod_mat
						from provisto_por pp2
                        group by pp2.cod_mat
                        having count(*)=1
    );
-- 24 Listar los nombres de almacenes que almacenan la mayor cantidad de artículos
	select a.nombre ,count(c.cod_art) as 'cantidadArticulo'
		from almacen a join contiene c on a.nro=c.nro
        group by a.nro,a.nombre
        having count(*)=(select  max(total)
                        from (select count(cod_art) as 'total'
						from contiene c
						group by c.nro)alias);
                        
-- 25 Listar la ciudades donde existan proveedores que proveen todos los materiales
	/*DIVISION*/
	SELECT c.nombre
	FROM ciudad c JOIN proovedor p ON c.cod_ciu = p.cod_ciu
	group by c.cod_ciu, c.nombre
    having count(*)=(select count(*)
					from material);
                            
                            
-- 26 Listar los números de almacenes que tienen todos los artículos que incluyen el
-- material con código 123.
	select c.nro
		from contiene c
        group by c.nro
        having count(*)=(select cp.cod_art
						from compuesto_por cp
						where cod_mat=123);
                            
	-- -------------------------------------- 
    /*En DESC en FECHA lo que hace es arriba el mas reciente, abajo el mas viejo*/

	

    
                 
                 

                        
                        

