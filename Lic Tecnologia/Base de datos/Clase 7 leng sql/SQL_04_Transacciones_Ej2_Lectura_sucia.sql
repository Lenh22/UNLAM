-- Actualización  LECTURA SUCIA
-- Para el presente ejemplo utilizaremos AdventureWorks2019
use AdventureWorks2019;

-- 1 - Ejecutar las siguiente consulta, nos devolverá la cantidad de personas cuyo nombre es 'Aaron' con apellido distinto

SELECT 
    COUNT(DISTINCT LastName) DistinctLastNameBeforeBeginTran
FROM Person.Person
WHERE FirstName = 'Aaron';
 
-- 2 - Ejecutar la siguiente transacción desde una terminal de SQL Server Managment Studio
-- Actualiza el apellido de todas las personas a 'Hotchner' y luego realiza un ROLLBACK

BEGIN TRANSACTION;
 
UPDATE Person.Person
SET LastName = 'Hotchner'
WHERE FirstName = 'Aaron'
;
 
SELECT 
    COUNT(DISTINCT LastName) DistinctLastNameInTransaction
FROM Person.Person
WHERE FirstName = 'Aaron';
 
WAITFOR DELAY '00:00:10.000';
 
ROLLBACK TRANSACTION;
 
SELECT 
    COUNT(DISTINCT LastName) DistinctLastNameAfterRollback
FROM Person.Person
WHERE FirstName = 'Aaron';


-- 3 - Inmediatamente después ejecutar la siguiente transacción desde una terminal de SQL Server Managment Studio distinta a la anterior
-- nos devolverá la cantidad de personas cuyo nombre es 'Aaron' con apellido distinto

SELECT 
    COUNT(DISTINCT LastName) SecondSessionResults
FROM Person.Person
WHERE FirstName = 'Aaron';

-- Como resultado vemos que la segunda terminal se queda esperando a que finalice la ejecución de la transacción en la terminal 1

-- 4 - Ejecutar la siguiente sentencia en la terminal 2 y repetir los pasos 2 y 3

SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

-- Como resultado en la terminal 2 tenemos una lectura errónea o lectura sucia.