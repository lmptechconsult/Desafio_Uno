Swagger enable: http://localhost:8080/swagger-ui.html#/

Desafio: 1 Fechas aleatorias dentro de 2 fechas, respuesta en json no ordenadas

    postman url
    GET: localhost:8080/api/v1/d1/gdd/schedule/randomdate?fechaInicio=1968-08-01&fechaFin=1971-06-01

-------

    postman url
    POST: localhost:8080/api/v1/n1/gdd/schedule/readfile

    lee un archivo en llamado "nombre_archivo_entrada" y crea un archivo de salida llamado "nombre_archivo_salida"


Nivel 2: Construir un programa que invoque al servicio REST GDD y escriba como salida un archivo con las fechas, los periodos recibidos y la lista de periodos faltantes. Ejemplo:

    postman url
    POST: localhost:8080/api/v1/n2/gdd/schedule/writetextplain


Nivel 3: Implementar un nuevo servicio REST. Este servicio REST debe invocar al servicio GDD y entregar la respuesta en formato JSON con las fechas recibidas y las fechas faltantes. Ejemplo de la respuesta que debería entregar:

    postman url
    POST: localhost:8080/api/v1/n3/gdd/schedule

Body
{
    "id": 6,
    "fechaCreacion": "1969-03-01",
    "fechaFin": "1970-01-01",
    "fechas": [
      "1969-03-01",
      "1969-05-01",
      "1969-09-01",
      "1970-01-01"]
}


Requisitos
tener instalado maven
tener instalado java jdk 11
    comando maven: mvn clean install
                   mvn package
    la compilacion queda en solucion/target/GDD-1.0.0-SNAPSHOT.jar

Para ejecutar en windows: doble click o por comando
    java -jar GDD-1.0.0-SNAPSHOT.jar


crear imagen para docker

crear un archivo con nombre DockerFile y agregar lo siguiente:
----
FROM azul/zulu-openjdk:13

# Run as non-root user
WORKDIR /opt/GDD

COPY GDD-1.0.0-SNAPSHOT.jar GDD-1.0.0-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Djdk.tls.client.protocols=TLSv1.1,TLSv1.2", "-Xmx2G", "-jar", "GDD-1.0.0-SNAPSHOT.jar"]
----

luego ejecutar el siguiente comando en un servidor docker en conjunto con el archivo .jar y el archivo DockerFile

docker build -t GDDRest .
