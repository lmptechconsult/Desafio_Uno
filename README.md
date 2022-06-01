# Detalle de los sistemas

Java 17
Spring-Boot 2.7.0
Maven 3


# Compilar y ejecutar el proyecto

Para copilar el proyecto se requiere Java y Maven instalado.
Ingresar al directorio *DesafioUno* ejecutar el siguiente comando *maven*

```bash
mvn package
```

Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
java -jar -DURL_GENERADOR=URL-GENERADOR-DATOS-DESAFIO-UNO DesafioUno-0.0.1.jar

Ejemplo:
java -jar -DURL_GENERADOR=http://127.0.0.1:8080 DesafioUno-0.0.1.jar
```

*Nota*:
Debe estar disponible el puerto *8081* en el PC donde se ejecute esta API

# Consumir la API

Para consumir el servicio se debe invocar la siguiente URL

```bash
'http://127.0.0.1:8081/DesafioUno/fechas'
```
