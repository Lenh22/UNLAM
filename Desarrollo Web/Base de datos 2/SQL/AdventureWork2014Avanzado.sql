--1. Listar los nombres de los productos y el nombre del modelo 
--que posee asignado. Solo listar aquellos que tengan asignado 
--algún modelo. 
Select Product.Name as Producto, ProductModel.Name as Modelo from Production.Product, Production.ProductModel where Product.ProductModelID = ProductModel.ProductModelID;

--2. Mostrar “todos” los productos junto con el modelo que tenga 
--asignado. En el caso que no tenga asignado ningún modelo, 
--mostrar su nulidad. 
Select PP.Name as Producto, PM.Name as Modelo from Production.Product PP left join Production.ProductModel PM on PP.ProductModelID = PM.ProductModelID;

--3. Ídem Ejercicio2, pero en lugar de mostrar nulidad, mostrar la 
--palabra “Sin Modelo” para indicar que el producto no posee un 
--modelo asignado. 
select pp.Name,
case 
when pm.Name is null then 'Sin modelo'
else pm.Name
end as 'Modelo'
From Production.Product pp left join Production.ProductModel pm on pp.ProductModelID = pm.ProductModelID;
--4. Contar la cantidad de Productos que poseen asignado cada 
--uno de los modelos. 
select pm.Name, count(pp.Name) as 'Cantidad de Productos' from Production.Product pp join Production.ProductModel pm on pp.ProductModelID = pm.ProductModelID
group by pm.Name;
--5. Contar la cantidad de Productos que poseen asignado cada 
--uno de los modelos, pero mostrar solo aquellos modelos que 
--posean asignados 2 o más productos. 
select pm.Name, count(pp.Name) as 'Cantidad de Productos' from Production.Product pp join Production.ProductModel pm on pp.ProductModelID = pm.ProductModelID
group by pm.Name
having count(pp.Name) > 2;
--6. Contar la cantidad de Productos que poseen asignado un 
--modelo valido, es decir, que se encuentre cargado en la tabla 
--de modelos. Realizar este ejercicio de 3 formas posibles: 
--“exists” / “in” / “inner join”. 
--select pm. Name as 'Modelo' , count(pp.Name) as 'Cantidad de Productos' from Production.Product pp, Production.ProductModel pm
--where exists (select pm.Name from Production.ProductModel pm2 where pp.ProductModelID = pm2.ProductModelID group by pm2.Name)
--group by pm.Name; erroneo

select pm. Name as 'Modelo', count(pp.Name) as 'Cantidad de Productos' from Production.Product pp, Production.ProductModel pm
where pp.ProductModelID in (select pm2.ProductModelID from Production.ProductModel pm2 where pm2.ProductModelID = pm.ProductModelID )
group by pm.Name;

select pm.Name as 'Modelo', count(pp.Name) as 'Cantidad de Productos' from Production.Product pp inner join Production.ProductModel pm on pp.ProductModelID = pm.ProductModelID
group by pm.Name;
--7. Contar cuantos productos poseen asignado cada uno de los 
--modelos, es decir, se quiere visualizar el nombre del modelo y 
--la cantidad de productos asignados. Si algún modelo no posee 
--asignado ningún producto, se quiere visualizar 0 (cero).
select pm.Name as 'Modelo', count(pp.Name) as 'Cantidad de Productos' from Production.Product pp right join Production.ProductModel pm on pp.ProductModelID = pm.ProductModelID
group by pm.Name;
--8. Se quiere visualizar, el nombre del producto, el nombre 
--modelo que posee asignado, la ilustración que posee asignada 
--y la fecha de última modificación de dicha ilustración y el 
--diagrama que tiene asignado la ilustración. Solo nos interesan 
--los productos que cuesten más de $150 y que posean algún 
--color asignado. 

select pp.Name as Producto, pm.Name as Modelo, pmi.IllustrationID, pri.ModifiedDate as UltimaModificacion, pri.Diagram as Diagrama, pp.ListPrice as Precio, pp.Color
		 from Production.Product pp join Production.ProductModel pm on pp.ProductModelID = pm.ProductModelID
		 join Production.ProductModelIllustration pmi on pm.ProductModelID = pmi.ProductModelID
		 join Production.Illustration pri on pmi.IllustrationID = pri.IllustrationID
		 where pp.Color is not null and pp.ListPrice >150;
--9. Mostrar aquellas culturas que no están asignadas a ningún 
--producto/modelo. 
--(Production.ProductModelProductDescriptionCulture) 
select pc.Name as Cultura , pc.CultureID
from Production.Culture pc
where pc.CultureID not in (select pmc.CultureID from Production.Product pp join Production.ProductModel pm on pp.ProductModelID = pm.ProductModelID
							join Production.ProductModelProductDescriptionCulture pmc on pm.ProductModelID = pmc.ProductModelID);
--10. Agregar a la base de datos el tipo de contacto “Ejecutivo de 
--Cuentas” (Person.ContactType) 
insert into Person.ContactType (Name, ModifiedDate) values('Ejecutivo de Cuentas','2022-09-02');
--11. Agregar la cultura llamada “nn” – “Cultura Moderna”. 
insert into Production.Culture (CultureID,Name, ModifiedDate) values('nn','Cultura Moderna', '2022-09-02');
--12. Cambiar la fecha de modificación de las culturas Spanish, 
--French y Thai para indicar que fueron modificadas hoy. 
update Production.Culture
set ModifiedDate = GETDATE() --Dia de hoy
where Name in ('Spanish','French','Thai');
--13. En la tabla Production.CultureHis agregar todas las culturas 
--que fueron modificadas hoy. (Insert/Select). 
Create table Production.CultureHis (CultureHisID varchar(2) not null primary key, Name varchar(255), ModifiedDate date) ; --creo la tabla
insert into  Production.CultureHis select * from Production.Culture pc where pc.ModifiedDate = GETDATE(); -- DATO: NUNCA SE VA A MODIFICAR YA QUE  pc.ModifiedDate CUENTA LOS SEGUNDOS TAMBIEN
--14. Al contacto con ID 10 colocarle como nombre “Juan Perez”. 
update Person.ContactType set Name = 'Juan Perez' where ContactTypeID = 10;
--15. Agregar la moneda “Peso Argentino” con el código “PAR” 
--(Sales.Currency) 
insert into Sales.Currency values ('PAR', 'Peso Argentino', GETDATE());
--16. ¿Qué sucede si tratamos de eliminar el código ARS 
--correspondiente al Peso Argentino? ¿Por qué? 
delete from Sales.Currency where Currency.CurrencyCode ='ARS'; --No se puede ya que esta en union con otra tabla
--17. Realice los borrados necesarios para que nos permita eliminar 
--el registro de la moneda con código ARS. 
delete from Sales.CountryRegionCurrency where CurrencyCode = 'ARS';
delete from Sales.Currency where Currency.CurrencyCode ='ARS'; -- ahora si
--18. Eliminar aquellas culturas que no estén asignadas a ningún 
--producto (Production.ProductModelProductDescriptionCulture)
delete from Production.Culture
where CultureID not in (select pmc.CultureID from Production.Product pp join Production.ProductModel pm on pp.ProductModelID = pm.ProductModelID
							join Production.ProductModelProductDescriptionCulture pmc on pm.ProductModelID = pmc.ProductModelID);