#Proyecto "rest-nivel3"
##Descripción

rest-nivel3 es un aplicativo desarrollado con el fin de resolver el desafío de nivel 3.
Está construido con la ayuda del marco de trabajo Spring Boot en Java 8.

##Dependencias principales
* Spring Boot Starter Web 
* Spring Boot Starter Webflux 
* Springdoc Openapi Starter Webmvc UI 
* Springfox Swagger2 
* Springfox Swagger UI 

##Compilación y ejecución del proyecto

Para copilar el proyecto se requiere Java y Maven instalado.
Ingresar al directorio *rest-nivel3* ejecutar el siguiente comando *maven*

```bash
mvn package
```

Una vez compilado el proyecto, navegar al directorio *target* y ejecutar el comando *java* como se muestra a continuación: 

```bash
java -jar .\rest-nivel3-1.0.0.jar
```
Es importante que el puerto *9093* esté disponible en el PC donde se ejecuta esta API y tambien que esté el servicio *api-periodos* escuchando en el puerto *8080*.


##Documentación

Para ingresar a la documentación, se requiere tener ejecutada el aplicativo como anteriormente se señala e ingresar al siguiente link.

http://localhost:9093/swagger-ui/

Para consumir el servicio se invoca a la siguiente URL

```bash
curl -X GET "http://localhost:9093/api/obtener" -H "accept: application/json"
```

La URL del Request

```bash
http://localhost:9093/api/obtener
```
