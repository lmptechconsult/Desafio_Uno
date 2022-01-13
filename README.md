<p align="center">
  <img src="LogoTC.jpg" width="180" title="Tech Consult">
</p>

# Desafio Previred (By Daniel San Martin)

Este proyecto expone una API REST, la cual contiene un método que retorna un
objeto tipo Periodo (model), con la respuesta de las fechas faltantes entregadas 
por la API "Generador_Datos_Desafio_Uno".

# Parametro de entrada (Json)
*id*: identificador.
*fechaCreacion*: Fecha de inicio de la secuencia.
*fechaFin*: Fecha de fin de la secuencia.
*fechas*: Lista de fechas que están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin”.
Ejemplo:
```json
{
  "id": 6,
  "fechaCreacion": "1968-08-01",
  "fechaFin": "1971-06-01",
  "fechas": [
    "1969-03-01",
    "1969-05-01",
    "1969-09-01",
    "1971-05-01"]
}
```

# Parametro de salida (Json)
*id*: identificador.
*fechaCreacion*: Fecha de inicio de la secuencia.
*fechaFin*: Fecha de fin de la secuencia.
*fechas*: Lista de fechas faltantes en el campo "fechas" del parámetro de entrada.
Ejemplo:
```json
{
  "id": 6,
  "fechaCreacion": "1968-08-01",
  "fechaFin": "1971-06-01",
  "fechas": [
    "1969-04-01",
    "1969-06-01",
    "1969-07-01",
    "1969-08-01",
    "1969-10-01",
    "1969-11-01",
    "1969-12-01",
    "1970-01-01",
    "1970-02-01",
    "1970-03-01",
    "1970-04-01",
    "1970-05-01",
    "1970-06-01",
    "1970-07-01",
    "1970-08-01",
    "1970-09-01",
    "1970-10-01",
    "1970-11-01",
    "1970-12-01",
    "1971-01-01",
    "1971-02-01",
    "1971-03-01",
    "1971-04-01"
  ]
}
```

# Ejecutar y probar la API

La documentación swagger de la API (una vez que se levanta en ambiente local) queda disponible en:

http://localhost:8082/desafioprevired/swagger-ui.html

*Nota*:
Debe estar disponible el puerto *8082* en el PC donde se ejecute esta API


# Instrucciones

- 1.- Entrar a la dirección de la documentación swagger ui.
- 2.- Expandir "Desafio Previred Controller".
- 3.- Clickear POST /fechasFaltantes.
- 4.- Clickear botón "Try it out". 
- 5.- Colocar Periodo Entrante en formato JSON.
- 6.- Clickear botón "Execute".
- 7.- Podrá ver en el recuadro "Response Body" el resultado de la operación.


# Herramientas y lenguajes usados

Swagger Codegen 2.9.2,
Java 11,
Spring-Boot 2.6.2,
Maven 4.

