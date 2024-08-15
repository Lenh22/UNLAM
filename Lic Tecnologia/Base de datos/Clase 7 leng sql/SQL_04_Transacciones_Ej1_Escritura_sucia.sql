-- Actualización  PERDIDA
-- 1 - Ejecutar las siguientes sentencias para crear la tabla BankAccounts e insertar un registro

DROP TABLE IF EXISTS BankAccounts;

CREATE TABLE BankAccounts(
    AccountId		INT IDENTITY(1,1),
    BalanceAmount   INT
);
 
insert into BankAccounts (
    BalanceAmount
)
SELECT 1500
;

-- 2 - Ejecutar la siguiente transacción desde una terminal de SQL Server Managment Studio
-- Simula al empleado 1 actualizando el valor de BalanceAmount para sumarle 1600

DECLARE @CustomerBalance	INT ;
DECLARE @BalanceDifference	INT ;
 
SET @BalanceDifference = 1600 ;
 
BEGIN TRANSACTION ;
	-- Getting back current balance value
	SELECT @CustomerBalance = BalanceAmount
	FROM BankAccounts
	WHERE AccountId = 1 ;
	PRINT 'Read Balance value: ' + CONVERT(VARCHAR(32),@CustomerBalance);
 
	-- adding salary amount
	SET @CustomerBalance = @CustomerBalance + @BalanceDifference ;
 
	-- Slowing down transaction to let tester the time
	-- to run query for other session
	PRINT 'New Balance value: ' + CONVERT(VARCHAR(32),@CustomerBalance);
 
	WAITFOR DELAY '00:00:10.000';
 
	-- updating in table
	UPDATE BankAccounts
	SET BalanceAmount = @CustomerBalance 
	WHERE AccountId = 1 ;
 
	-- display results for user
	SELECT BalanceAmount as BalanceAmountSession1
	FROM BankAccounts
	WHERE AccountId = 1 ;
COMMIT ;



-- 3 - Inmediatamente después ejecutar la siguiente transacción desde una terminal de SQL Server Managment Studio distinta a la anterior
-- Simula al empleado 2 actualizando el valor de BalanceAmount para sumarle 40
 
DECLARE @CustomerBalance	INT ;
DECLARE @BalanceDifference	INT ;
 
SET @BalanceDifference = 40 ;
 
BEGIN TRANSACTION ;
	-- Getting back current balance value
	SELECT @CustomerBalance = BalanceAmount
	FROM BankAccounts
	WHERE AccountId = 1 ;
 
	PRINT 'Read Balance value: ' + CONVERT(VARCHAR(32),@CustomerBalance);
 
	-- adding salary amount
	SET @CustomerBalance = @CustomerBalance + @BalanceDifference ;
 
PRINT 'New Balance value: ' + CONVERT(VARCHAR(32),@CustomerBalance);
 
	-- updating in table
	UPDATE BankAccounts
	SET BalanceAmount = @CustomerBalance 
	WHERE AccountId = 1 ;
 
	-- display results for user
	SELECT BalanceAmount as BalanceAmountSession2
	FROM BankAccounts
	WHERE AccountId = 1 ;
COMMIT ;

-- como resultado verán que solo la transacción 1 actualizo los valores, perdiendo la suma de 40 al balance