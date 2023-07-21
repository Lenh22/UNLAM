/*Persona (nro_persona, nombre, calle, ciudad, nro_supervisor)
Empresa(nro_empresa, razon_social, calle, ciudad)
Trabaja (nro_persona, nro_empresa, salario, fecha_ingreso)
Nota: las claves primarias se marcaron en negrita, y las claves foráneas subrayadas*/
-- 1. Listar el nombre y ciudad de todas las personas que trabajan en la empresa “Banelco”.
SELECT persona.nombre, persona.ciudad
	FROM persona JOIN trabaja ON persona.nro_persona = trabaja.nro_persona
	JOIN empresa ON trabaja.nro_empresa = empresa.nro_empresa
	WHERE empresa.razon_social = 'Banelco';
-- 2. Listar el nombre, calle y ciudad de todas las personas que trabajan para la empresa “Paulinas” y ganan más de $1500.
SELECT persona.nombre, persona.calle, persona.ciudad
	FROM persona JOIN trabaja ON persona.nro_persona = trabaja.nro_persona
	JOIN empresa ON trabaja.nro_empresa = empresa.nro_empresa
	WHERE empresa.razon_social = 'Paulinas'
	AND trabaja.salario > 1500;

-- 3. Listar el nombre de personas que viven en la misma ciudad en la que se halla la empresa en donde trabajan.
SELECT persona.nombre
	FROM persona JOIN trabaja ON persona.nro_persona = trabaja.nro_persona
	JOIN empresa ON trabaja.nro_empresa = empresa.nro_empresa
	WHERE persona.ciudad = empresa.ciudad
	GROUP BY persona.nombre;
-- 4. Listar número y nombre de todas las personas que viven en la misma ciudad y en la misma calle que su supervisor.
SELECT pp.nro_persona, pp.nombre
	FROM persona p JOIN persona pp ON p.nro_persona = pp.nro_supervisor
	WHERE p.ciudad = pp.ciudad
	AND p.calle = pp.calle
	AND p.nro_persona != pp.nro_persona;
-- 5. Listar el nombre y ciudad de todas las personas que ganan más que cualquier empleado de la empresa “Tecnosur”.
SELECT persona.nombre, persona.ciudad, trabaja.salario
	FROM persona JOIN trabaja ON persona.nro_persona = trabaja.nro_persona
	JOIN empresa ON trabaja.nro_empresa = empresa.nro_empresa
	WHERE trabaja.salario > (SELECT MAX(trabaja.salario)
							FROM trabaja JOIN empresa ON trabaja.nro_empresa = empresa.nro_empresa
							 WHERE empresa.razon_social = 'Tecnosur');
-- 6. Listar las ciudades en las que todos los trabajadores que vienen en ellas ganan más de $1000.
SELECT persona.ciudad, COUNT(*) cant_empleados
	FROM persona JOIN trabaja ON persona.nro_persona = trabaja.nro_persona
	GROUP BY persona.ciudad;
	SELECT persona.ciudad, COUNT(*) cant_salarios
	FROM trabaja JOIN persona ON trabaja.nro_persona = persona.nro_persona
	WHERE trabaja.salario > 1000
	GROUP BY .ciudad;
-- 7. Listar el nombre de los empleados que hayan ingresado en mas de 4 Empresas en el periodo 01-01-2000 y 31-03-2004
SELECT persona.nombre, COUNT(*) cant_ingresos
		FROM persona JOIN trabaja ON persona.nro_persona = trabaja.nro_persona
		JOIN empresa ON trabaja.nro_empresa = empresa.nro_empresa
		WHERE persona.nro_persona IN (SELECT trabaja.nro_persona
										 FROM trabaja
										 WHERE trabaja.fecha_ingreso
										BETWEEN '2000-01-01' AND '2004-03-31'
										 GROUP BY trabaja.nro_persona)
		GROUP BY persona.nro_persona;