#Evaluación de Previred

###Nombre: 
Roberto Salinas López 
###Email: 
roberto.ismael90@gmail.com 
###Linkedln
https://www.linkedin.com/in/robis-sallop
###Como me entere del desafio?
Me enteré de este desafío por una entrevista con Leonardo Miranda de Tech Consult

Este proyecto es un API REST que entrega la siguiente información:
-id: identificador
-fechaCreacion: Fecha de inicio de la secuencia
-fechaFin: Fecha de fin de la secuencia
-fechas: Lista de fechas que están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin”
-fechasFaltantes: Lista de fechas faltantes en el periodo, que son las fechas que fueron omitidas durante el proceso de generación aleatoria dentro del rango de fecha de la secuencia
-periodoCompleto: Lista completa de fechas del periodo ordenadas

Ejemplo:

	{
	    "id": 1,
	    fechaCreacion": "1990-08-01",
        "fechaFin": "2013-08-01",
        "fechas": [
	        "1990-08-01",
            "1991-02-01",
            "1991-04-01",
            "1992-10-01",
            "1993-02-01",
            "1993-03-01",
	        .
	        .
            .
	    ],
	    "fechasFaltates": [
            "1990-09-01",
            "1990-10-01",
            "1990-11-01",
            "1990-12-01",
            "1991-01-01",
            "1991-03-01",
            "1991-05-01",
	        .
	        .       
            .
	    ],
         "periodoCompleto": [
            "1990-08-01",
            "1990-09-01",
            "1990-10-01",
            "1990-11-01",
            "1990-12-01",
            "1991-01-01",
            "1991-02-01",
            "1991-03-01",
            "1991-04-01",
            "1991-05-01",
            .
            .
            .
	}

# Detalle de los Sistemas
Java 8 Spring-Boot 1.9.RELEASE
Maven 4 

# Compilar y ejecutar
Para copilar el proyecto se requiere Java y Maven instalado. Ingresar al directorio 'Desafio_Uno' y ejecutar el siguiente comando maven:

    mvn package

Luego de compilar el proyecto ingresar al directorio target ejecutar el siguiente comando java:

    java -jar .\Desafio_Uno-1.0-SNAPSHOT.jar

Nota:
1) Realizar despliegue de proyecto Generador_Datos_Desafio_Uno de acuerdo a lo indicado en:
   https://github.com/previred/Generador_Datos_Desafio_Uno
2) Debe estar disponible el puerto 8081 en el PC donde se ejecute esta API


# Consumo del servicio

Para consumir el servicio se debe invocar la siguiente URL:

	curl -X GET --header 'Accept: application/json' 'http://127.0.0.1:8081/desafio/periodosFaltantes'