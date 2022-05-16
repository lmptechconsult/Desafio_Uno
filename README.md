# API REST Desafio uno

Esta API REST, tiene como funcionalidad indentificar todas las fechas faltantes a partir de un listado de fechas entregadas (entre un periodo de determinado) por la API "Generador De Datos o GDD", una versión de GDD se encuentra en este repositorio en GitHub: https://github.com/lmptechconsult/Generador_Datos_Desafio_Uno.

A continuación se muestra un ejemplo de un mensaje entregado por GDD.
```json
{
    "id": 6,
    "fechaCreacion": "1970-08-01",
    "fechaFin": "1971-06-01",
    "fechas": [     
      "1970-09-01",
	  "1971-04-01",
      "1971-05-01"],
	"fechasFaltantes": [
      "1970-08-01",
      "1970-10-01",
	  "1970-11-01",
	  "1970-12-01",
      "1971-01-01",
	  "1971-02-01",
	  "1971-03-01",
      "1971-06-01"]
}
```

## Diseño API REST Desafio Uno
La API REST Desafio Uno, se compone principalmente de las siguientes clases y archivos de configuración (hay más pero solo se nombrarán las más importantes):
* ExternalApiCallerController.java
* IMissingDatesServices.java
* RestRepository.java
* ApiExceptionHandler.java
* application.properties
### ExternalApiCallerController
Esta clase se encarga de establecer un endpoint REST, "/periodos" usando la anotación @RequestMapping y además se encarga de realizar el llamado al servicio 	IMissingDatesServices

### IMissingDatesServices
Esta clase se encarga de realizar un llamado a la clase RestRepository y en base a lo que esta le entregue como resultado manipulará los datos para escribirlos en formato json en dos archivos (input.json y output.json), tambien se hacen llamados a dinstintas funcionalidades para calcular las fechas faltantes en los datos recibidos, una vez realizado todos los calculos se retorna un String en formato Json hacia ExternalApiCallerController.

### IMissingDatesServices
Esta clase es la encargada de consumir la api rest GDD y luego mapear todo lo que reciba de esta api a un objeto, el cual finalmente es retornado hacia el servicio IMissingDatesServices.

### ApiExceptionHandler
Esta clase es la encargada de manipular toda excepción creada durante el desarrollo de este proyecto.

### application.properties
Este archivo contiene campos los cuales pueden ser modificadas segun se requiera, **importante mencionar que el proyecto estaba almacenado en una carpeta llamada Desafio en el disco D, por lo que se recomienda cambiar las variables path.input.json y path.output.json para obtener de manera correcta los archivos de entrada y salida**.


## Como compilar y ejecutar API REST Desafio Uno
Para compilar el proyecto se requiere Java y Maven instalado. Ingresar al directorio desafio ejecutar el siguiente comando maven

	mvn package
Luego de compilar el proyecto ingresar al directorio target ejecutar el siguiente comando java **debe tener el puerto 8090 disponible**
			
	java -jar .\desafio-0.0.1-SNAPSHOT.jar

## Documentación mediante Swagger2

La documentación está disponible (mientras el proyecto esté en ejecución) en la siguiente url : http://localhost:8090/swagger-ui/

## Para consumir el servicio
	
	curl -X GET "http://localhost:8090/periodos" -H "accept: application/json"
	
