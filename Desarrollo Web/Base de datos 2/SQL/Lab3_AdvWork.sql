--1. Realizar una consulta que permita devolver la fecha y hora actual 
Declare @fecha date = getdate();
select @fecha as Fecha;
--2. Realizar una consulta que permita devolver únicamente el año y mes actual: 
Declare @mes date = getdate();
Declare @anio date = getdate();
SELECT YEAR(@anio) as Año, MONTH(GETDATE()) as Mes; -- dos maneras
--3. Realizar una consulta que permita saber cuántos días faltan para el día de la 
--primavera (21-Sep) 
Declare @primavera date = '2022-09-21';
select DATEDIFF(DAY, GETDATE(), @primavera); -- DATEDIFF(mes/dia/año, una_fecha , fecha_a_diferenciar);
--4. Realizar una consulta que permita redondear el número 385,86 con 
--únicamente 1 decimal. 
declare @numero float(10) = 385.86;
select ROUND(@numero,1) as Redondeo; --ROUND(numero, cantidad_de_decimales);
--5. Realizar una consulta permita saber cuánto es el mes actual al cuadrado. Por 
--ejemplo, si estamos en Junio, sería 62
declare @fechaActual date = getdate();
declare @mesActual int = Month(@fechaActual); --Month(fechaDate) return INT
select POWER(@mesActual,2) as MesActual --POWER ( exprecion , elevacion )  
--6. Devolver cuál es el usuario que se encuentra conectado a la base de datos 
SELECT SESSION_USER Sesion, 
       CURRENT_USER UsuarioActual, 
       SYSTEM_USER  UsuarioDelSitema, 
       ORIGINAL_LOGIN() Logeado, 
       SUSER_SNAME() LogeadoALaSesion;
--7. Realizar una consulta que permita conocer la edad de cada empleado 
--(Ayuda: HumanResources.Employee)
select DATEDIFF(YEAR, he.BirthDate, GETDATE())  from HumanResources.Employee he;
--8. Realizar una consulta que retorne la longitud de cada apellido de los 
--Contactos, ordenados por apellido. En el caso que se repita el apellido 
--devolver únicamente uno de ellos.
--select substring(pc.Name,1,charindex(' ',pc.Name,1)-1) as Apellido, len(substring(pc.Name,1,charindex(' ',pc.Name,1)-1)) as Tamaño from Person.ContactType pc  -- No pude --
select pp.LastName, len(pp.LastName) as Tamaño from Person.Person pp 
join Sales.PersonCreditCard sp on pp.BusinessEntityID = sp.BusinessEntityID
join Sales.CreditCard sc on sp.CreditCardID = sc.CreditCardID
join Person.BusinessEntityContact pb on sc.CreditCardID = pb.PersonID
join Person.ContactType pc on pb.ContactTypeID = pc.ContactTypeID;

--9. Realizar una consulta que permita encontrar el apellido con mayor longitud. 
select pp.LastName as 'Mayor longitud'  from Person.Person pp 
join Sales.PersonCreditCard sp on pp.BusinessEntityID = sp.BusinessEntityID
join Sales.CreditCard sc on sp.CreditCardID = sc.CreditCardID
join Person.BusinessEntityContact pb on sc.CreditCardID = pb.PersonID
join Person.ContactType pc on pb.ContactTypeID = pc.ContactTypeID
where len(pp.LastName) = (select MAX(LEN(pp2.LastName)) from Person.Person pp2 )
group by pp.LastName;

--10.Realizar una consulta que devuelva los nombres y apellidos de los contactos 
--que hayan sido modificados en los últimos 3 años. 
declare @3AnioAtras int = YEAR(getdate())-3;
select pp.FirstName, pp.LastName, pp.ModifiedDate from Person.Person pp 
join Sales.PersonCreditCard sp on pp.BusinessEntityID = sp.BusinessEntityID
join Sales.CreditCard sc on sp.CreditCardID = sc.CreditCardID
join Person.BusinessEntityContact pb on sc.CreditCardID = pb.PersonID
join Person.ContactType pc on pb.ContactTypeID = pc.ContactTypeID
where Year(pp.ModifiedDate) > @3AnioAtras;
--11.Se quiere obtener los emails de todos los contactos, pero en mayúscula. 
select upper(pe.EmailAddress) from Person.Person pp 
join Sales.PersonCreditCard sp on pp.BusinessEntityID = sp.BusinessEntityID
join Sales.CreditCard sc on sp.CreditCardID = sc.CreditCardID
join Person.BusinessEntityContact pb on sc.CreditCardID = pb.PersonID
join Person.ContactType pc on pb.ContactTypeID = pc.ContactTypeID
join Person.EmailAddress pe on pe.BusinessEntityID =  pp.BusinessEntityID
--12.Realizar una consulta que permita particionar el mail de cada contacto, 
--obteniendo lo siguiente: 
select pc.ContactTypeID, pe.EmailAddress, replace(pe.EmailAddress, '@adventure-works.com', ' ') from Person.Person pp 
join Sales.PersonCreditCard sp on pp.BusinessEntityID = sp.BusinessEntityID
join Sales.CreditCard sc on sp.CreditCardID = sc.CreditCardID
join Person.BusinessEntityContact pb on sc.CreditCardID = pb.PersonID
join Person.ContactType pc on pb.ContactTypeID = pc.ContactTypeID
join Person.EmailAddress pe on pe.BusinessEntityID =  pp.BusinessEntityID;
-- Otra manera
select pp.FirstName ,pe.EmailAddress ,
reverse(substring(reverse(pe.EmailAddress), 5,(charindex('@',reverse(pe.EmailAddress)))-5)) as dominio,
left(pe.EmailAddress, len(pe.EmailAddress) - (len(SUBSTRING (pe.EmailAddress, CHARINDEX( '@', pe.EmailAddress),
LEN(pe.EmailAddress))))) as nombre
from Person.Person pp join Person.EmailAddress pe on pp.BusinessEntityID=pe.BusinessEntityID;
--13. Devolver los últimos 3 dígitos del NationalIDNumber de cada empleado 
select RIGHT( he.NationalIDNumber,3) from HumanResources.Employee he;
--14.Se desea enmascarar el NationalIDNumbre de cada empleado, de la 
--siguiente forma ###-####-##: 
select he.NationalIDNumber,
SUBSTRING(he.NationalIDNumber,1,3)+'-'+SUBSTRING(he.NationalIDNumber,4,7)+'-'+SUBSTRING(he.NationalIDNumber,8,12)
 from HumanResources.Employee he;




--15. Listar la dirección de cada empleado “supervisor” que haya nacido hace más 
--de 30 años. Listar todos los datos en mayúscula. Los datos a visualizar son: 
--nombre y apellido del empleado, dirección y ciudad. 
select DATEDIFF(YEAR, he.BirthDate, GETDATE()) as Edad, UPPER(pp.FirstName) as Nombre,
 UPPER(pp.LastName) as Apellido, UPPER(pa.AddressLine1) as direccion, UPPER(pa.City) as ciudad
from HumanResources.Employee he 
join Person.Person pp on pp.BusinessEntityID = he.BusinessEntityID
join Person.BusinessEntity pb on pp.BusinessEntityID = pb.BusinessEntityID
join Person.BusinessEntityAddress pba on pb.BusinessEntityID = pba.BusinessEntityID
join Person.Address pa on pba.AddressID = pa.AddressID
where he.JobTitle = 'Production Supervisor - WC10'
and DATEDIFF(YEAR, he.BirthDate, GETDATE()) >30 ;
--16. Listar la cantidad de empleados hombres y mujeres, de la siguiente forma: 
--Nota: Debe decir, Femenino y Masculino de la misma forma que se muestra. 
select 
case
when he.Gender = 'M' then 'Masculino'
when he.Gender = 'F' then 'Femenino'
else he.Gender
end as Sexo , count(he.Gender) as Cantidad from HumanResources.Employee he group by he.Gender;
--17.Categorizar a los empleados según la cantidad de horas de vacaciones, 
--según el siguiente formato: 
--Alto = más de 50 / medio= entre 20 y 50 / bajo = menos de 2
select
case
when he.VacationHours >50 then 'Alto'
when he.VacationHours between 20 and 50 then 'Medio'
when he.VacationHours < 20 then 'Bajo'
end as 'Nivel vacacional' from HumanResources.Employee he;