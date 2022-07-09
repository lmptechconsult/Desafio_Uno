
# Desafio 1 Previred


Primer desafío enviado por Previred para Proceso de Selección de Desarrolado Junior.

Programa escrito en Java con SpringBoot, que obtiene una lista de fechas a partir de un rango de fechas el cual genera una API Rest (local) escrita en Java Spring Boot.

# Requerimientos de Sistema


```
Sistema Operativo compatible con Java 8/SpringBoot/Maven3

JDK: jdk-8.0.332.9-hotspot

MAVEN: apache-maven-3.8.6

Spring Boot 2.7.1

Swagger Codegen (OpenApi 3.0)

Java 8
```

Antes de compilar y ejecutar. Levantar la API GDD siguiendo estos pasos:


- https://github.com/lmptechconsult/Generador_Datos_Desafio_Uno

# Compilar y ejecución de proyecto
Para copilar el proyecto se requiere Java y Maven instalado.

Ingresar al directorio raíz de la API y ejecutar el siguiente comando maven
```
mvn package
```
Luego de compilar el proyecto ingresar al directorio target ejecutar el siguiente comando java

```
java -jar .\desafio1-api-rest-0.0.1-SNAPSHOT.jar
```

*Nota*:
Debe estar disponible el puerto *8090* en el PC donde se ejecute esta API

# Consumir API

Para consumir el servicio se debe invocar la siguiente URL:

```
curl -X GET --header 'Accept: application/json' 'http://localhost:8090/api/desafio1'
```


# Visualizar Documentación y consumir la API

La documentación swagger del API (una vez que se levanta el API) queda disponible en

- http://localhost:8090/swagger-ui.html

