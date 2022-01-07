# Obtener fechas faltantes a partir de la respuesta del generador de datos.

Este proyecto expone un API REST que entrega la siguiente información:

*fechaCreacion*: Fecha de inicio de la secuencia <br>
*fechaFin*: Fecha de fin de la secuencia <br>
*fechas*: Lista de fechas que están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin” <br>
*fechas faltantes*: Fechas que debío entregar el generador de datos pero no entrego <br><br>
Ejemplo.

```json
{
  "id": 1,
  "fechaCreacion": "1997-01-07",
  "fechaFin": "1998-01-07",
  "fechas": [
    "1984-08-01",
    "1984-10-01",
    "1985-01-01",
    "1985-02-01",
    "1985-11-01",
    "1986-05-01",
    "1986-07-01",
    "1987-03-01",
    "1987-05-01",
    "1987-08-01",
    "1988-03-01",
    "1989-02-01",
    "1989-05-01",
    "1990-07-01",
    "1990-09-01",
    "1991-10-01",
    "1992-06-01",
    "1992-07-01",
    "1993-06-01",
    "1993-08-01",
    "1993-09-01",
    "1993-11-01",
    "1994-04-01",
    "1994-09-01",
    "1995-01-01",
    "1995-05-01",
    "1995-07-01",
    "1995-08-01",
    "1996-01-01",
    "1996-12-01",
    "1997-01-01",
    "1997-07-01",
    "1997-08-01",
    "1997-12-01",
    "1998-01-01",
    "1998-02-01",
    "1998-05-01",
    "1998-07-01",
    "1999-04-01",
    "1999-06-01",
    "1999-11-01",
    "2000-02-01",
    "2000-04-01",
    "2000-05-01",
    "2000-09-01",
    "2001-03-01",
    "2001-11-01",
    "2001-12-01",
    "2002-01-01",
    "2002-05-01",
    "2002-10-01",
    "2003-03-01",
    "2003-04-01",
    "2003-07-01",
    "2003-09-01",
    "2004-01-01",
    "2004-07-01",
    "2004-10-01",
    "2004-12-01",
    "2005-02-01",
    "2005-03-01",
    "2005-09-01",
    "2005-10-01",
    "2006-04-01",
    "2006-07-01",
    "2006-10-01",
    "2007-03-01",
    "2007-05-01",
    "2007-09-01",
    "2007-11-01",
    "2008-03-01",
    "2008-10-01",
    "2009-04-01",
    "2009-12-01",
    "2010-02-01",
    "2010-03-01",
    "2010-04-01",
    "2010-05-01",
    "2010-07-01",
    "2010-08-01",
    "2010-11-01",
    "2011-02-01",
    "2011-08-01",
    "2012-07-01",
    "2012-12-01",
    "2013-04-01",
    "2013-05-01",
    "2013-09-01",
    "2013-11-01",
    "2014-04-01",
    "2014-05-01",
    "2014-06-01",
    "2014-07-01",
    "2014-11-01",
    "2015-09-01",
    "2016-04-01",
    "2016-06-01"
  ],
  "fechasFaltantes": [
    "1997-02-01",
    "1997-03-01",
    "1997-04-01",
    "1997-05-01",
    "1997-06-01",
    "1997-09-01",
    "1997-10-01",
    "1997-11-01"
  ]
}
```
*Nota*:
El formato de las fechas es yyyy-MM-dd
El servicio entrega 1 periodos, el periodo contiene una fecha inicial una fecha final y una lista fechas.

# Detalle de los sistemas

Swagger Codegen 2.3.1 (OpenApi 2.0) <br>
Java 8 <br>
Spring-Boot 1.5.11.RELEASE <br>
Maven 3 <br>

# Configuracion

Se debe modificar el archivo *ApiFaltantes/src/main/resources/application.properties* con la url del API generador de datos

```bash
api.destino.endpoint=http://localhost:8090/periodos/api
```
# Compilar y ejecutar el proyecto

Para copilar el proyecto se requiere Java y Maven instalado.
Ingresar al directorio *ApiFaltantes* ejecutar el siguiente comando *maven*

```bash
mvn package
```

Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
java -jar .\api-desafio-1.0.0.jar
```
*Nota*:
Debe estar disponible el puerto *8100* en el PC donde se ejecute esta API

# Visualizar Documentación y consumir la API

La documentación swagger del API (una vez que se levanta el API) queda disponible en

http://127.0.0.1:8100/desafio/swagger-ui.html#/

Para consumir el servicio se debe invocar la siguiente URL

```bash
curl -X GET --header 'Accept: application/json' 'http://127.0.0.1:8100/periodos/api?fechaInicio=1997-01-07&fechaFin=1998-01-07'
```

# Regenerar API a partir de yaml

Las siguientes instrucciones solo son para re-escribir el API si es necesario agregar una nueva funcionalidad a partir del *YAML*.

Bajar SwaggerCodeGen 2.3.1 en la raíz del proyecto, ejecutando el siguiente comando por consola.

```bash
wget http://oss.sonatype.org/content/repositories/releases/io/swagger/swagger-codegen-cli/2.3.1/swagger-codegen-cli-2.3.1.jar -O swagger-codegen-cli.jar
```

Para re-crear el código a partir de la definición del *YAML* de swagger ejecutar el siguiente comando

```bash
java -jar .\swagger-codegen-cli.jar generate -i .\swagger\faltantes.yaml -l spring -c .\swagger\config.json -o ApiPeriodos --ignore-file-override .\.swagger-codegen-ignore
```

*Nota*:
Esto creara toda la estructura de swagger y re-escribirá todas las clases que no estén declaradas en el archivo *.swagger-codegen-ignore*