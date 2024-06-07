-- 1- Listar los c�digos y descripciones de todos los productos 
select ProductDescriptionID, Description from Production.ProductDescription;
-- 2- Listar los datos de la subcategor�a n�mero 17
select * from Production.ProductSubcategory where ProductSubcategoryID = 17;
-- 3- Listar los productos cuya descripci�n comience con D (Ayuda: like �D%�)
select * from Production.ProductDescription  where Description like 'D%';
-- 4- Listar las descripciones de los productos cuyo n�mero finalice con 8 (Ayuda: ProductNumber like �%8�)
SELECT PP.ProductID AS Id, PP.ProductNumber AS number, PD.Description AS descrciption
FROM Production.Product PP 
JOIN Production.ProductModel PM ON PP.ProductModelID=PM.ProductModelID 
JOIN Production.ProductModelProductDescriptionCulture PDMC ON PDMC.ProductModelID=PP.ProductModelID
JOIN Production.ProductDescription PD ON PD.ProductDescriptionID=PDMC.ProductDescriptionID
WHERE PP.ProductNumber LIKE '%8';
-- 5- Listar aquellos productos que posean un color asignado. Se deber�n excluir todos aquellos que no posean ning�n valor (Ayuda: is not null) 
select * from Production.Product where Color is not null;
-- 6 Listar el c�digo y descripci�n de los productos de color Black (Negro) y que posean el nivel de stock en 500. (Ayuda: SafetyStockLevel = 500)
select PP.ProductID, PD.Description
FROM Production.Product PP
JOIN Production.ProductModel PM ON PP.ProductModelID=PM.ProductModelID 
JOIN Production.ProductModelProductDescriptionCulture PDMC ON PDMC.ProductModelID=PP.ProductModelID
JOIN Production.ProductDescription PD ON PD.ProductDescriptionID=PDMC.ProductDescriptionID
where PP.Color='Black' and SafetyStockLevel = 500;
--7- Listar los productos que sean de color Black (Negro) � Silver (Plateado).
select * from Production.Product where Color = 'Black' or Color = 'Silver';
--8- Listar los diferentes colores que posean asignados los productos. S�lo se deben listar los colores. (Ayuda: distinct) 
select distinct Color From Production.Product;
--9- Contar la cantidad de categor�as que se encuentren cargadas en la base. (Ayuda: count) 
select COUNT(*) from Production.ProductCategory;
--10- Contar la cantidad de subcategor�as que posee asignada la categor�a 2. 
select COUNT(*) from Production.ProductSubcategory where ProductCategoryID = 2;
--11- Listar la cantidad de productos que existan por cada uno de los colores. 
select Color , COUNT(*) from Production.Product group by Color;
--12- Sumar todos los niveles de stocks aceptables que deben existir para los productos con color Black. (Ayuda: sum) 
select sum(SafetyStockLevel) from Production.Product where Color = 'Black';
--13- Calcular el promedio de stock que se debe tener de todos los productos cuyo c�digo se encuentre entre el 316 y 320. (Ayuda: avg) 
select avg(SafetyStockLevel) from Production.Product where ProductID between 316 and 320;
--14- Listar el nombre del producto y descripci�n de la subcategor�a que posea asignada. (Ayuda: inner join) 
select Name, Description from Production.Product join Production.ProductDescription on ProductID = ProductDescriptionID;
--15- Listar todas las categor�as que poseen asignado al menos una subcategor�a. Se deber�n excluir aquellas que no posean  ninguna.
select * from Production.ProductCategory PC 
join Production.ProductSubcategory PS on PC.ProductCategoryID = PS.ProductCategoryID
where PS.ProductCategoryID is not null; 
--16- Listar el c�digo y descripci�n de los productos que posean fotos asignadas. (Ayuda: Production.ProductPhoto) 
select PP.ProductID, PD.Description, PPH.ThumbnailPhotoFileName from Production.Product PP 
join Production.ProductProductPhoto PPP on PP.ProductID = PPP.ProductID
join Production.ProductPhoto PPH on PPP.ProductPhotoID= PPH.ProductPhotoID
JOIN Production.ProductModel PM ON PP.ProductModelID=PM.ProductModelID 
JOIN Production.ProductModelProductDescriptionCulture PDMC ON PDMC.ProductModelID=PP.ProductModelID
JOIN Production.ProductDescription PD ON PD.ProductDescriptionID=PDMC.ProductDescriptionID;
--17- Listar la cantidad de productos que existan por cada una de las Clases (Ayuda: campo Class) 
select count (Class), Class from Production.Product group by Class;
--18- Listar la descripci�n de los productos y su respectivo color. S�lo nos interesa caracterizar al color con los valores: Black, Silver u Otro. Por lo cual si no es ni silver ni black se debe indicar Otro. (Ayuda: utilizar case).
Select
CASE
    WHEN Color = 'Black' THEN 'Black'
    WHEN Color = 'Silver' THEN 'Silver'
    ELSE 'Otro'
END AS Color, PD.Description
from Production.Product  PP
JOIN Production.ProductModel PM ON PP.ProductModelID=PM.ProductModelID 
JOIN Production.ProductModelProductDescriptionCulture PDMC ON PDMC.ProductModelID=PP.ProductModelID
JOIN Production.ProductDescription PD ON PD.ProductDescriptionID=PDMC.ProductDescriptionID;
--19- Listar el nombre de la categor�a, el nombre de la subcategor�a y la descripci�n del producto. (Ayuda: join) 
Select PC.Name as Categoria, PS.Name as SubCategoria, PD.Description
FROM Production.Product PP 
JOIN Production.ProductModel PM ON PP.ProductModelID=PM.ProductModelID 
JOIN Production.ProductModelProductDescriptionCulture PDMC ON PDMC.ProductModelID=PP.ProductModelID
JOIN Production.ProductDescription PD ON PD.ProductDescriptionID=PDMC.ProductDescriptionID
Join Production.ProductSubcategory PS on PS.ProductSubcategoryID = PP.ProductSubcategoryID
join Production.ProductCategory PC on PC.ProductCategoryID = PS.ProductCategoryID;
--20- Listar la cantidad de subcategor�as que posean asignado los productos. (Ayuda: distinct).
select count(distinct ProductSubcategoryID) from Production.Product;






