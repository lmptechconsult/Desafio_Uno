
# Generador de Fechas faltantes desafio uno

la app tiene la funcion de consultar en el generador de datos 
(facilitado desde https://github.com/lmptechconsult/Generador_Datos_Desafio_Uno)
se recomienda acceder y ejecutar para el correcto funcionamiento de la presente aplicacion

durante las pruebas se detecto un problema de memoria en java, 
asi como de rendimiento por lo que se mantuvo una cantidad limitada de numeros encontrados a 100
para cualquier duda, se puede retirar la validacion de las lineas 53 y 61 de DesafioUnoController.java

# Compilar y ejecutar el proyecto

Para copilar el proyecto se requiere Java y Maven instalado.
Para ejecutar el proyeto se requiere de tener el proyecto *ApiPeriodos* corriendo en el puerto 8080
Ingresar al directorio *DesafioUno* ejecutar el siguiente comando *maven*

```bash
mvn package
```
Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
java -jar .\desafiouno-0.0.1-SNAPSHOT.jar --server.port=8090
```

la app se inicia en el puerto 8090 para evitar modificar el proyecto que hace entrega de la informacion
Por lo tanto se requeriran de los puertos 8080 y 8090 para la ejecucion

api - http://localhost:8090/desafio_uno/fechas

swagger - http://localhost:8090/swagger-ui.html