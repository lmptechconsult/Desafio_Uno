
# Calculador de fechas fatante de un periodo

Este proyecto es una API REST que a su vez, consume la API REST expuesta por Tech Consult para Desafío de Previred.
Esta API entrega la siguiente información, que incluye los días faltantes del período:
```json
{
    "id": 6,
    "fechaCreacion": "1969-03-01",
    "fechaFin": "1970-01-01",
    "fechas": [
      "1969-03-01",
      "1969-05-01",
      "1969-09-01",
      "1970-01-01"],
    "fechasFaltantes": [
      "1969-04-01",
      "1969-06-01",
      "1969-07-01",
      "1969-08-01",
      "1969-10-01",
      "1969-11-01",
      "1969-12-01"]

}
```


# Detalle de los sistemas

Java 8
Maven 3.5.0 en consola de comandos.


# Apuntar el proyecto a la API GDD de Tech Consult

Esto se configura en el proyecto, en application.properties, actualmente:

service.gdd.uri=http://127.0.0.1:8080/periodos/api

# Configurar el puerto

En el 8080 estaría la API REST de GDD.
Entonces como esa API se instaló localmente, hubo que cambiar el puerto de este proyecto.
Esto se configura en application.properties, actualmente:
server.port=8081

# Compilar y ejecutar el proyecto

Para compilar el proyecto se requiere Java y Maven instalado.
Ingresar al directorio *periodos* y ejecutar el siguiente comando *maven*

```
mvn clean install
```

Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```
java -jar .\periodos-0.0.1-SNAPSHOT.jar
```

*Nota*:
Debe estar disponible el puerto *8081* en el PC donde se ejecute esta API.
En el 8080 estaría la API REST de GDD.
Esto se configura en application.properties, actualmente:
server.port=8081


# Consumir la API

Para consumir el servicio se debe invocar la siguiente URL, desde el navegador, Postman, u otros..:

http://localhost:8081/periodos/faltantes


# SWAGGER

Verificación:
http://localhost:8081/v2/api-docs

UI:
http://localhost:8081/swagger-ui/








