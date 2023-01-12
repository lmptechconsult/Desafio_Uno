<p align="center">
</p>

# Desarrollo Desafio Uno - Nivel 3 - Javier Zambrano

Este proyecto es la solucion del Nivel 3 de https://github.com/lmptechconsult/Desafio_Uno:


Este proyecto es una api rest que devuelve la siguiente informacion
*id*: identificador
*fechaCreacion*: Fecha de inicio de la secuencia
*fechaFin*: Fecha de fin de la secuencia
*fechas*: Lista de fechas que están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin”
*fechasFaltantes*: Lista de fechas Faltantes que no devolvio el servicio GDD de Periodos, los periodos devueltos están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin” y no aparences en la lista del campo “fechas”
Ejemplo.
```json
{
    "id": 6,
    "fechaCreacion": "2022-06-01",
    "fechaFin": "2023-01-01",
    "fechas": [
      "2022-06-01",
      "2022-08-01",
      "2022-09-01",
      "2022-12-01"]
	  ],
	"fechasFaltantes": [
        "2022-07-01",
        "2022-10-01",
        "1982-11-01",
		"2023-01-01"
	]
}
```
*Nota*:
El formato de las fechas es yyyy-MM-dd
El servicio entrega 1 periodos, el periodo contiene una fecha inicial una fecha final una lista fechas aleatorias, y una lista de fecha faltantes que no aparencen en la lista de fechas.

# Detalle de los sistemas

Swagger Codegen 2.3.1 (OpenApi 2.0)
Java 8
Spring-Boot 1.5.11.RELEASE
Maven 3


# Compilar y ejecutar el proyecto

Para copilar el proyecto se requiere Java y Maven instalado.
Ingresar al directorio *ApiPeriodos* ejecutar el siguiente comando *maven*

```bash
mvn package
```

Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
cd ./target
java -jar .\test_desafio_uno.jar
```
*Nota*:
Se debe Levantar la API api-periodos https://github.com/lmptechconsult/Generador_Datos_Desafio_Uno
si Se desea cambiar La url de la Api-periodos se encuentra en el archivo properties "application.properties" del proyecto test_desafio_uno:
		previred.api.periodos.uri=http://127.0.0.1:8080/periodos/api
Debe estar disponible el puerto *8092* en el PC donde se ejecute esta API 

# Visualizar Documentación y consumir la API

La documentación swagger del API (una vez que se levanta el API) queda disponible en

http://127.0.0.1:8092/desafio-uno/swagger-ui.html

Para consumir el servicio se debe primeramente levantar la API "api-periodos", una vez funcionando las 2 API se debe invocar la siguiente URL

```bash
curl -X GET --header 'Accept: application/json' 'http://127.0.0.1:8092/desafio-uno/api'
```
