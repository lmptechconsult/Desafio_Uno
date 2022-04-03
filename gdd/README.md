# Desafio Uno GDD

-   Solucion nivel 3 
	*  Java 17 
	*  Spring Boot 2.5.6
	*  swagger 2.9.2
-   Generador Datos Desafio Uno puerto 8080.

## Compilar y ejecutar el proyecto

Compilacion

*    mvn compile assembly:single

Levantar servicio

*   mvn spring-boot:run

#  Consumir la API

Los Servicios pueden ser consumido por medio de swagger

http://localhost:8080/swagger-ui.html


## Jobs RESTful API
Este comando ejecuta la aplicación rest-api disponible localmente en el puerto 8080
### Use of available endpoints
1.- Genera periodos aleatorios
```bash
curl -X GET "http://localhost:8080/api/v1/periodo/getPeriodoRandom" -H "accept: */*"
```
2.- Busca periodos faltantes segun JSON de entrada 
```bash
curl -X POST "http://localhost:8080/api/v1/periodo/getPeriodosByJson" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"fechaCreacion\": \"string\", \"fechaFin\": \"string\", \"fechas\": [ \"string\" ], \"id\": 0}"
```

El servicio para generacion fechas aleatorias GET

* http://localhost:8080/api/v1/periodo/getPeriodoRandom

El servicio Para obtencion de fechas restantes POST:

* http://localhost:8080/api/v1/periodo/getPeriodosByJson


## Carpeta Json contiene archivos con la entrada y salida correspondiente

# Datos personales
|  |  |
|--|--|
| **Nombre** | Francisco Javier Devaud Pizarro |
| **EMail** |francisco.devaud@gmail.com  |
|**Contacto postulacion**|Correo electronico, Base de reclutamiento ***techconsult***|








