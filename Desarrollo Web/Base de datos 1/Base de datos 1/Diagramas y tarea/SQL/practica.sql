/*Socio (DNI, Nombre_Apellido, FechaNacimiento, Activo)
Aclaración: Activo es Si/No.
Practica (DNI, CodDeporte)
Deporte (CodDep, Deporte, EnEquipo)
Aclaración: EnEquipo es Si/No.
Equipo (IdEquipo, CodDeporte, Denominación, Categoría, Año)
Jugador (IdEquipo, Numero, DNI, Apodo)
Torneo (IdTorneo, Titulo, Categoría, Año)
Posicion (IdTorneo, IdEquipo, Posición, Fecha_Edicion)*/
-- 
/*Practica.DNI->Socio.DNI
Practica.CodDeporte-> Deporte.CodDep
Equipo.CodDeporte-> Deporte.CodDep
Jugador.IdEquipo-> Equipo.IdEquipo
Jugador.DNI-> Socio.DNI
Posicion.IdTorneo-> Torneo.IdTorneo
Posicion.IdEquipo->  Equipo.IdEquipo*/
DROP DATABASE if exists practica;
CREATE DATABASE if not exists practica;
USE practica;
/*Generar el código DML correspondiente para actualizar un deporte de tu
elección (poner la descripción toda en mayúsculas) y entonces inscribirse como
socio/a para practicar el mismo.
*/

update deporte
set deporte= "a mi seleccion"
where deporte="a mi seleccion tmb";

insert into Socio values (41693526, "Leandro Alonso", "22-01-1999", "Si");

/*Determinar los socios (DNI y nombre) que practican algún deporte y no son
jugadores de ningún equipo.*/
select s.dni, s.nombre
	from Socio s join Practica p on s.dni=p.dni
				join Deporte d on p.codDep= d.codDep
    where  deporte is not null and d.EnEquipo="No";

/*Listar los torneos con la mayor cantidad de equipos*/

select t.idTorneo, count(p.idEquipo) as 'cantDeEquiposEnTorneo'
	from Torneo t join Posicion p on t.idTorneo=p.idTorneo
    group by t.idTorneo
    having count(*)=(select max(total)
					from (select count(idEquipo) as "total"
                    from posicion p
                    group by p.idTorneo)alias
                    );
    
/*Encontrar para todos los equipos (nombre) que hicieron podio (de primer a
tercer lugar), los torneos en los que sucedió.  Listar equipo, torneo y posición. */
select p.idEquipo, p.idTorneo, p.posicion, e.denominacion
					from Equipo e 	
                    join Posicion p on e.idEquipo=p.idEquipo 
					join Torneo t on p.idTorne=t.idTorneo
group by p.idEquipo, p.idTorneo, p.posicion, e.denominacion
having p.posicion in (1,2,3);

/*Determinar los jugadores que practican todos los deportes ofrecidos en el club*/
SELECT P.dni
		FROM Practica P 
        JOIN Deporte D ON p.dni = p.dni
GROUP BY P.nro
HAVING COUNT(*) = ( SELECT COUNT(*)
					FROM Deporte);
                    
/*Se quiere premiar con dinero a todos los jugadores que entraron al podio
en los torneos del verano pasado, para ello necesitamos saber la máxima
posición obtenida por cada uno.*/

-- DICHO MEJOR: Indica la posicion maxima de los equipos por cada torneo

select p.idEquipo, max(p.pocision)
	from Torneo t 
	join Posicion p on t.idTorneo=p.idTorneo
group by p.idEquipo, t.idTorneo;

/*Listar los Socios que juegan en equipos con categoría "Profesional”*/
select s.dni, s.nombre_apellido
	from Socio s
    where s.dni in( select j.dni    
					from Jugador j 
                    join Equipo e on j.idEquipo=e.idEquipo
                    where e.categoria="Profesional");
                    
select s.dni, s.nombre_apellido
		from Socio s 
        join Jugador j on j.dni=s.dni
        join Equipo e on j.idEqupo=e.idEquipo
        where e.categoria="Profesional";
        
/*Listar cada Deporte con cantidad de equipos y jugadores totales actuales con nombre "A".*/
select p.codDep,  count(j.dni), count(e.idEquipo)
	from Practica p
	join Jugador j on j.dni=p.dni
    join Equipo e on j.idEquipo=e.idEquipo
group by p.codDep, e.idEquipo;

/*Lista de torneos en los que se participó en los últimos 3 años por cada
deporte.
*/
select t.Titulo
	from Torneo t 
    join Equipo e on e.idEquipo=t.idEquipo
    join Deporte d on e.codDep=d.codDep
where t.año between '01012019' and '31122021'
group by d.idDepor,t.idTorneo;

-- “Listar el promedio de precios de los artículos por cada almacén (nombre)”
 SELECT alm.nombre as 'almacen', AVG(art.precio) as 'precio promedio'
	 FROM almacen alm JOIN contiene c ON alm.nro = c.nro
	 JOIN Articulo art ON art.cod_art = c.cod_art
	GROUP BY alm.nro, alm.nombre;



    



 


 






	