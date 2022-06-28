<p align="center">
</p>


API Periodos Perdidos

El servicio Periodos Perdidos, permite obtener una lista
de fechas que no se encuentran en la lista inicial, cuyo 
resultado es la consulta al servicio GDD.

A través de SWAGGER-UI (localhost:8081), es posible ejecutar el proceso que permite obtener la data en formato JSON.

Tener en cuenta que para la correcta ejecución del servicio,
es necesario contar con la API Periodo en ejecución (localhost:8080). 

Parámetros Importantes en .properties

1. server.port=8081
2. url.api.gdd=http://localhost:8080/periodos/api/

Compilación y Ejecución

1. mvn compile
2. java -jar api-periodos-perdidos-1.0.jar

