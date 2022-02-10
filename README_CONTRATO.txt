/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

BASE DE DATOS:

Se necesita generar la base de datos para "CONTRATO", está configurado para trabajar con Postgress SQL. 
El nombre de la base de datos por defecto es "test". Se necesita agregar el JDBC de Postgress al proyecto disponible 
en: https://mvnrepository.com/artifact/org.postgresql/postgresql/42.2.16

		CREATE TABLE public.docente
		(
		codigo integer,
		ci text,
		nombre text,
		apellidos text,
		direccion text,
		telefono text,
		fecha_nacimiento date,
		primary key(codigo)
		);
		ALTER TABLE IF EXISTS public.docente
  	  	OWNER to postgres;

		CREATE TABLE public.contrato
		(
		codigo integer,
		docente integer,
		fecha_contrato date,
		sueldo integer,
		primary key(codigo),
		foreign key(docente) references public.docente
		)
		;

		ALTER TABLE IF EXISTS public.contrato
	   	OWNER to postgres;



/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
GENERACIÓN DE INFORME DE CASOS DE PRUEBA:

Para generar el informe de los casos de prueba se debe ejecutar los casos de pruebas, se encuentran disponible en el paquete
"Test Package"/"funciones_20170823_115532". Los archivos de test se llaman "FDocenteTest" y "FContrato"


LOCALIZACIÓN DEL INFORME:
El informe se genera en la raíz del proyecto. El nombre del archivo es "informe.txt"

