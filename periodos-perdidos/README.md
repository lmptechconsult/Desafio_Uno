# Prueba Blas Muñoz Sagredo
En esta solucion se implemento el Nivel 3, de lo enviado por lo que este programa es un Servicio Rest hecho en Spring Boot que consume la Api Rest GDD. Se adjunta en el folder JSON un ejemplo del response de esta API. 

### Instalacion y Ejecución 
Para la instalación se requiere maven y Java instalado. Una vez clonado el proyecto desde git, Ingresar al directorio *periodos-perdidos* y ejecutar 

```bash
mvn package
```

Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
java -jar periodos-perdidos-0.0.1.jar
```

### Consumo API
Para consumir esta API se debe invocar la siguiente URL:

```bash
http://localhost:8090/periodos-perdidos/api
```

*Nota:*
Para un correcto funcionamiento el puerto 8090 debe estar habilitado, ya que ese es el puerto por defecto en el que se ejecuta la API. 
