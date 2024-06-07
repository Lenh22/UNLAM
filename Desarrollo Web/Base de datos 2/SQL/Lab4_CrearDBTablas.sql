-- 1. Crear la base de datos MusicaDB a través del siguiente script: 
--Create database MusicaDB 
--on primary (	
--NAME = 'Musica',
--FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Musica.mdf',
--SIZE = 5000KB, -- quise poner 4096kb pero deja como minimo 5MB
--MAXSIZE= 20480KB,
--FILEGROWTH = 1024 KB
--)
--log on (
--NAME = 'Musica_log',
--FILENAME =  'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Musica_log.ldf' ,
--SIZE = 2048KB,
--MAXSIZE = 10240KB,
--FILEGROWTH = 10%
--);

--2. Responder la siguientes preguntas verificando cómo ha quedado la base de 
--datos creada: 
--2.1. ¿Qué se ha definido como política de retención de log? 
-- RESPUESTA: Se ha puesto como retencion el tamaño con el cual comienza, su tamaño maximo y como crecera la base de datos

--2.2. ¿Se crearán estadísticas automáticamente? 
-- RESPUESTA: Se crean automaticamente ya que AUTO_CREATE_STATISTICS esta predeterminado en ON

--2.3. ¿Será compatible con una base de datos de SQL Server 2000? 
-- RESPUESTA: Para que sea compatible con diferentes versiones deberia hacerce una alteracion a la base de datos como Ej:
-- ALTER DATABASE MusicaDB SET COMPATIBILITY_LEVEL = 80
-- El numero 80 es el versionado de SQL Server 2000

--2.4. ¿Cuál es el juego de caracteres que se utilizará y qué significa? 
-- Al darle click derecho a la BD -> Propiedades, te saldra el juego de caracteres (Collation en sqlServer en ingles)
--En este caso es Modern_Spanish_CI_AS
--Significa español moderno, sin distincion de mayusculas con minusculas, sin distincion tambien de acentos

--3. Crear el esquema discos.
 --CREATE SCHEMA Discos;

-- 4. Se desea crear el siguiente modelo relacional. Recordar que se deben crear 
--cada una de las tablas involucradas y de sus relaciones. 

 CREATE TABLE [Discos].[Artista]( 
 artno smallint NOT NULL, 
 nombre varchar(50) NULL, 
 clasificacion char(1) NULL, 
 bio text NULL, 
 foto image null, 
 CONSTRAINT PK_Artista PRIMARY KEY CLUSTERED (artno) 
);

CREATE TABLE Discos.Album(
Titulo varchar(250) NOT NULL,
artno smallint NOT NULL,
itemno smallint NOT NULL primary key,
CONSTRAINT FK_Artista FOREIGN KEY (artno) REFERENCES Discos.Artista (artno)
); 

CREATE TABLE Discos.Stock(
itemno smallint NOT NULL,
tipo char(1) NOT NULL,
precio decimal(5,2) NOT NULL,
cantidad int NOT NULL,
CONSTRAINT PK_Stock PRIMARY KEY (itemno),
CONSTRAINT FK_Album FOREIGN KEY (itemno) REFERENCES Discos.Album(itemno)
);

CREATE TABLE Discos.Orden(
itemno smallint NOT NULL,
timestamp timestamp NOT NULL
);



CREATE TABLE Discos.Concierto (
artno smallint NOT NULL,
fecha datetime NOT NULL,
ciudad varchar(25) NOT NULL,
CONSTRAINT PK_Concierto PRIMARY KEY (fecha),
CONSTRAINT FK_ArtistaConcierto FOREIGN KEY (artno) REFERENCES Discos.Artista (artno)
);

ALTER TABLE Discos.Orden 
ADD CONSTRAINT FK_Stock FOREIGN KEY (itemno) REFERENCES Discos.Stock(itemno);

ALTER TABLE Discos.Concierto
ADD CONSTRAINT PK_ConciertoArtNo PRIMARY KEY (artno);

ALTER TABLE Discos.Stock
ADD CONSTRAINT FK_Orden FOREIGN KEY (itemno) REFERENCES Discos.Orden(itemno);

ALTER TABLE Discos.Orden
ADD CONSTRAINT PK_Orden PRIMARY KEY (itemno);

ALTER TABLE Discos.Orden
ADD CONSTRAINT FK_StockOrden FOREIGN KEY (itemno) REFERENCES Discos.Stock(itemno);

--6. Realizar los siguientes cambios en el modelo: 
--6.1. Cambiar el tamaño de campo ciudad en la tabla ciudad para que sea de 
--30 en lugar de 25. 
ALTER TABLE Discos.Concierto
ALTER COLUMN ciudad varchar(30);

--6.2. En la tabla de Stock, colocar el precio con un valor por defecto en 0 
--(cero). 
ALTER TABLE Discos.Stock
ADD DEFAULT 0 FOR precio;

--6.3. En la tabla de álbumes el nombre del título no puede ser nulo.
-- Habia ya hecho que todos no sean null pero seria asi
ALTER TABLE Discos.Album
ALTER COLUMN Titulo varchar(50) NOT NULL;

--7. Agregar los siguientes registros dentro de la base de datos creada: 
--- 3 artistas 
INSERT INTO Discos.Artista (artno, nombre, clasificacion, bio, foto)VALUES (1,'Pepe Argento', 'A', 'Pepe Argento de Casados Con Hijos', 'Aqui iria una foto');
INSERT INTO Discos.Artista VALUES (2,'Moni Argento', 'A', 'Moni Argento de Casados Con Hijos', 'Aqui iria una foto'); -- Si te acordas el orden se puede asi
INSERT INTO Discos.Artista VALUES (3,'Paola Argento', 'B', 'Paola Argento de Casados Con Hijos', 'Aqui iria una foto');
--- 2 conciertos por cada uno de los artistas en diferentes fechas y ciudades 
INSERT INTO Discos.Concierto (artno, fecha, ciudad) 
VALUES	(1, 22-01-2023,'Moron'),
		(2, 09-09-2022,'La Plata'),
		(3, 14-02-2025, 'San Justo');
INSERT INTO Discos.Concierto (artno, fecha, ciudad) 
VALUES	(1, 23-01-2023,'Haedo'),
		(2, 10-09-2022,'Once'),
		(3, 15-02-2025, 'San Fernando');
--- 2 álbumes por cada uno de los artistas 
INSERT INTO Discos.Album (Titulo, artno, itemno)
VALUES	('Taratara-Tararatara',1,1),
		('Pasen',1,2),
		('Ay Pepe',2,3),
		('Cafecito',2,4),
		('Buenoo...',3,5),
		('Que te pasa a vo loco eh',3,6);
--- Stock sólo de 2 álbumes de diferentes artistas
INSERT INTO Discos.Stock (itemno, tipo, precio, cantidad)
VALUES	(1, 'A', 250.2, 10),
		(4, 'M', 340.3, 5);