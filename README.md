# Desafio periodos perdidos - nivel 3
Este proyecto permite consume un servicio rest de fechas generadas al azar y devuelve las fechas faltantes dentro del período entregado.

# Compilar y ejecutar el proyecto

Para compilar y ejecutar el proyecto, se necesita tener Java y Maven instalados en el equipo.

En un terminal ir hasta el directorio *nivelTres* y ejecutar los comandos *maven*
```
mvn clean
```
```
mvn install
```
```
mvn package
```

# Antes de continuar, se debe levantar el servicio Rest Generador de datos(GDD) en el puerto 8080.

Luego de compilar el proyecto, se debe ingresar al directorio *target* y ejecutar el comando *java*
```
java -jar .\nivelTres-0.0.1-SNAPSHOT.jar
```

En mac el comando es:
```
java -jar nivelTres-0.0.1-SNAPSHOT.jar
```

*Nota*
Para ejecutar el proyecto debe estar disponible el puerto *8081*

Para consumir el servicio rest, se debe invocar a la siguiente URL
```bash
curl -X GET --header "Accept:application/json" "http://localhost:8081/rest/missedPeriods"
```

Resultado en formato JSON:
```{
"id": 1,
    "fechaCreacion": "2015-07-01",
    "fechaFin": "2021-10-01",
    "fechas": [
        "2015-12-01",
        "2017-03-01",
        "2017-07-01",
        "2018-08-01",
        "2019-07-01",
        "2020-04-01",
        "2020-05-01",
        "2020-06-01",
        "2021-01-01",
        "2021-05-01",
        "2021-08-01",
        "2021-09-01"
    ],
    "fechasFaltantes": [
        "2015-07-01",
        "2015-08-01",
        "2015-09-01",
        "2015-10-01",
        "2015-11-01",
        "2016-01-01",
        "2016-02-01",
        "2016-03-01",
        "2016-04-01",
        "2016-05-01",
        "2016-06-01",
        "2016-07-01",
        "2016-08-01",
        "2016-09-01",
        "2016-10-01",
        "2016-11-01",
        "2016-12-01",
        "2017-01-01",
        "2017-02-01",
        "2017-04-01",
        "2017-05-01",
        "2017-06-01",
        "2017-08-01",
        "2017-09-01",
        "2017-10-01",
        "2017-11-01",
        "2017-12-01",
        "2018-01-01",
        "2018-02-01",
        "2018-03-01",
        "2018-04-01",
        "2018-05-01",
        "2018-06-01",
        "2018-07-01",
        "2018-09-01",
        "2018-10-01",
        "2018-11-01",
        "2018-12-01",
        "2019-01-01",
        "2019-02-01",
        "2019-03-01",
        "2019-04-01",
        "2019-05-01",
        "2019-06-01",
        "2019-08-01",
        "2019-09-01",
        "2019-10-01",
        "2019-11-01",
        "2019-12-01",
        "2020-01-01",
        "2020-02-01",
        "2020-03-01",
        "2020-07-01",
        "2020-08-01",
        "2020-09-01",
        "2020-10-01",
        "2020-11-01",
        "2020-12-01",
        "2021-02-01",
        "2021-03-01",
        "2021-04-01",
        "2021-06-01",
        "2021-07-01"
] }
```
