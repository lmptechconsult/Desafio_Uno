<p align="center">
  <img src="LogoTC.jpg" width="180" title="Tech Consult">
</p>

#Requisitos de entorno de desarrollo

Para ambientar un equipo y comenzar a desarrollar es necesario contar con las siguientes herramientas y tecnologías:

1. Java 8
2. Maven version 3.6.X.
3. Git para el control de versiones
4. IDE para el desarrollo con java

# Compilar y ejecutar el proyecto
Para poder levantar el servicio localmente se deben seguir los siguientes pasos:

1. Importar los fuentes del respositorio mediante git
2. Compilar  con maven mediante el siguiente comando:

    ```bash
    mvn package
    ```
3. Para levantar el servicio ingresar al directorio target generado y ejecutar el siguiente comando:

    ```bash
    java -jar .\periodos-0.0.1-SNAPSHOT.jar
    ```
4. El servicio corre por defecto sobre el puerto 8090.

5. Para probar el servicio bastara con consultar  el enpoint en postman

    ```bash
    GET http://localhost:8090/periodos/obtener-fechas-faltantes
    ```
6. Para visualizar la documentación en ambiente local Swagger
    ```bash
    http://localhost:8090/swagger-ui.html
    ```
7. Se adjunta json con respuesta respuesta.json   
#Autor
   - Nombre: Valeria Constanzo Riveros
   - Correo: vconstanzor@gmail.com
   - LinkedIn: https://www.linkedin.com/in/vconstanzor/   
   
# Desafío 1: Periodos perdidos

El desafío consiste en lo siguiente:

-   Existe un servicio REST que llamaremos Generador De Datos o GDD.
    -   El servicio responde con una lista de fechas generadas aleatoriamente. Estas fechas se encuentran en un lapso definidos por dos valores: fechaCreacion y fechaFin.
    -   Cada fecha generada corresponde al primer día de un mes.
    -   La respuesta contienen un máximo de 100 fechas. 
    -   El servicio no entrega todas las fechas dentro del periodo, omite algunas de forma también aleatoria.
-   El objetivo de este ejercicio es que determines cuáles son los periodos que faltan.

Este es un ejemplo de la respuesta que entrega este servicio:

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

Acá se puede apreciar que el servicio generó fechas entre el 1 de agosto de 1968 y el 1 de junio de 1971. Sólo se generaron 4 fechas en este caso. 
De acuerdo a esto, faltarían fechas, 5 de 1968, 9 fechas de 1969, 5 fechas de 1971, etc.
Una versión del GDD se encuentra en este repositorio en GitHub:
https://github.com/lmptechconsult/Generador_Datos_Desafio_Uno

El desafío puede ser resuelto de tres maneras distintas. 
Tú eliges cuál es la que más te acomoda entre estos tres niveles:



## Nivel 3:

Implementar un nuevo servicio REST. Este servicio REST debe invocar al servicio GDD y entregar la respuesta en formato JSON con las fechas recibidas y las fechas faltantes.
Ejemplo de la respuesta que debería entregar:

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

REQUISITOS:
-   Se pueden implementar las soluciones en cualquier lenguaje y framework. Aunque recomendamos usar: Java(con o sin Spring Boot), Go y Python.
-   La solución debe ser enviada vía un pull request a este repositorio.
-   La solución debe contener un README.md con las instrucciones para compilar e instalar.
-   Puedes implementar cualquiera de los 3 niveles, no es necesario implementar los 3.
-   Hay bonus si usas SWAGGER.
-   Junto con la solución debes entregar un archivo con la entrada y con la salida en formato JSON.
- Por ultimo en el detalle del commit debes indicar los siguientes datos
   - Nombre Completo.
   - Correo Electrónico.
   - Vía por la que te entérate del desafío. Estas pueden ser: Empresa de outsourcing (indicar cuál), twitter, LinkedIn, etc.


NOTA:
Todos los pull reuqests serán rechazados, esto no quiere decir que ha sido rechazada la solución, sino que es una forma de que otros postulantes no copien tu código.

