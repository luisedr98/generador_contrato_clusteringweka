/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

BASE DE DATOS:

Para el funcionamiento del “Contrato”, necesita las siguientes consideraciones:
• Tener instalado la base de datos PostGreSql
• Crear una base de datos
• Configurar los datos necesarios en el archivo database.properties, para que la aplicación pueda conectarse a la base de datos. (El archivo está ubicado en ..src\java\accesodatos)

Ejemplo de configuración del archivo database.properties:
driver = org.postgresql.Driver
user = postgres
password = root
url= jdbc:postgresql://127.0.0.1:5432/test

Se necesita agregar el JDBC de PostgreSQL al proyecto, disponible 
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

1. Para generar el informe de los casos de prueba se debe  jecutar los casos de pruebas, se encuentran disponible en el paquete
"Test Package"/"funciones_20170823_115532". Los archivos de test se llaman "FDocenteTest" y "FContrato"

Ingresar a la carpeta Test Package"/"funciones" para seguir con los siguientes pasos:

2. Se debe ejecutar la clase "Ejecutable.java", pero se debe configurar la ruta estática de la carpeta que contiene los casos de prueba. Posteriormente se generara la clase "SuiteExample.java"

3. Ejecutar la clase "SuiteExample.java" esta clase se encarga de ejecutar automaticamente los casos de prueba y generar el informe de los casos de prueba en formato .csv


/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
LOCALIZACIÓN DEL INFORME:
El informe se genera en la raíz del proyecto. El nombre del archivo es "informe.csv"


/*----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
JDK necesario 1.8

