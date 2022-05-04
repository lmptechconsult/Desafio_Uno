<p align="center">
  <img src="LogoTC.jpg" width="180" title="Tech Consult">
</p>

# Buscar Fechas Faltantes

Este proyecto expone un API REST que entrega la siguiente información:

*id*: identificador
*fechaCreacion*: Fecha de inicio de la secuencia
*fechaFin*: Fecha de fin de la secuencia
*fechas*: Lista de fechas que están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin”
*fechasFaltantes*: Lista de fechas que están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin” sin considerar el listado de "fechas" ya encontrados previamente.
Ejemplo.
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
*Nota*:
El formato de las fechas es yyyy-MM-dd
El servicio entrega 1 periodos, el periodo contiene una fecha inicial una fecha final, una lista de fechas y otra lista de fechas que no se encuentra en el listado anterior de fechas.

# Compilar y ejecutar el proyecto

Para compilar el proyecto se requiere Java y Maven instalado.
Ingresar al directorio *desafio* ejecutar el siguiente comando *maven*

```bash
mvn package
```

Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
java -jar .\desafio-0.0.1-SNAPSHOT.jar
```
*Nota*:
Debe estar disponible el puerto *8081* en el PC donde se ejecute esta API

# Visualizar Documentación y consumir la API

La documentación swagger del API (una vez que se levanta el API) queda disponible en

http://localhost:8081/swagger-ui/

Para consumir el servicio se debe invocar la siguiente URL

```bash
curl -X GET "http://localhost:8081/periodos/faltantes" -H "accept: */*"
```