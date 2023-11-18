USE [abm2015]
GO
/****** Object:  StoredProcedure [dbo].[SP_EMPLEADOS_ABM_Ejemplo4]    Script Date: 11/05/2015 20:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =====================================================================
-- Autor:		Cintia Gioia	
-- Fecha de creación: 4/10/2015
-- Descripción:	ABM de Empleados
-- =====================================================================
ALTER PROCEDURE [dbo].[SP_EMPLEADOS_ABM_Ejemplo4]    
	@ACCION CHAR(1)='A',   
	@ID NUMERIC(18, 0), 
	@NOMBRE VARCHAR(100)='NOMBRE', 
	@APELLIDO VARCHAR(100), 
	@FECHA_NAC DATETIME, 
	@EDAD SMALLINT, 
	@DNI INT
AS
BEGIN
	
SET NOCOUNT ON /*Evita que se devuelva el mensaje que muestra el recuento del número de filas
afectadas por una instrucción o un procedimiento almacenado de Transact-SQL
como parte del conjunto de resultados.*/

DECLARE @DESCRIPCIONERROR VARCHAR(MAX)

BEGIN TRY
	
	BEGIN TRANSACTION
	
	SELECT @ACCION = UPPER(@ACCION)

	SELECT @DESCRIPCIONERROR = 'Id Inválido'
	IF @ID IS NULL OR @ID<=0
	BEGIN
		 THROW 50000,@DESCRIPCIONERROR,1 --LANZA ERROR AL CATCH, PORQUE EL SP TIENE TRY CATCH
	END	
	
	IF @ACCION = 'A' 
	BEGIN
		SELECT @DESCRIPCIONERROR = 'Id ya existente'
		IF EXISTS (SELECT 1 FROM EMPLEADO WHERE ID =@ID)
		BEGIN
		 THROW 50000,@DESCRIPCIONERROR,1
		END
	
	END
	
	IF @ACCION = 'B' OR @ACCION = 'M'
	BEGIN
	
		SELECT @DESCRIPCIONERROR = 'Id inexistente '
		IF NOT EXISTS (SELECT 1 FROM EMPLEADO WHERE ID =@ID)
		BEGIN
		 THROW 50000,@DESCRIPCIONERROR,1
		END	
	END
	
	IF @ACCION = 'A' OR @ACCION = 'M'
	BEGIN
		SELECT @DESCRIPCIONERROR = 'Nombre inválido'
		IF @NOMBRE IS NULL OR LTRIM(RTRIM(@NOMBRE))=''
		BEGIN
		 THROW 50000,@DESCRIPCIONERROR,1
		END	
	END
		
	IF @ACCION ='A' 
		BEGIN
			SELECT @DESCRIPCIONERROR = 'Error al insertar EMPLEADO '

			INSERT INTO dbo.EMPLEADO
			(ID, NOMBRE, APELLIDO, FECHA_NAC, EDAD, DNI) 
			VALUES 
			(@ID,@NOMBRE, @APELLIDO, @FECHA_NAC, @EDAD, @DNI) 			

			SELECT 'Cantidad de Filas insertadas: ' + CONVERT(VARCHAR(10),@@ROWCOUNT)
		END 

	IF @ACCION ='B'
		BEGIN	

		    SELECT @DESCRIPCIONERROR = 'Error al eliminar EMPLEADO - ID: '	 + CAST(@ID AS VARCHAR(20))  
		
			DELETE dbo.EMPLEADO			
			WHERE ID = @ID
			
			SELECT 'Cantidad de Filas borradas: ' + CONVERT(VARCHAR(10),@@ROWCOUNT)
		END 

	IF @ACCION ='M' 
		BEGIN

			SELECT @DESCRIPCIONERROR = 'Error al actualizar EMPLEADO - ID: '	 + CAST(@ID AS VARCHAR(20)) 

			UPDATE dbo.EMPLEADO	
			SET NOMBRE=@NOMBRE,
			APELLIDO=@APELLIDO, 
			FECHA_NAC=@FECHA_NAC,
			EDAD=@EDAD,
			DNI=@DNI
			WHERE ID = @ID
			
			SELECT 'Cantidad de Filas modificadas: ' + CONVERT(VARCHAR(10),@@ROWCOUNT)
		END 
		
		COMMIT TRANSACTION		
		
END TRY

BEGIN CATCH

	ROLLBACK TRAN
 
    INSERT INTO LOGERRORES 
	(DESCRIPCION, ERROR, FILA, 
	ERROR_LINE, ERROR_MESSAGE, ERROR_PROCEDURE, 
	ERROR_NUMBER, ERROR_SEVERITY, ERROR_STATE, FECALT, USERID
	)  
	VALUES (@DESCRIPCIONERROR,  
	@@ERROR, @@ROWCOUNT, --estas 2 variables de entorno se pisan con cada sentencia ejecutada en el SP, por lo cual en este paso siempre van a devolver cero
	ERROR_LINE(), ERROR_MESSAGE(), ERROR_PROCEDURE(), 
	ERROR_NUMBER(), ERROR_SEVERITY(),ERROR_STATE(),
	GETDATE(),SYSTEM_USER )       
	
	THROW 50000,@DESCRIPCIONERROR,1  

END CATCH

END
