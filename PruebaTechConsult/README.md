# Desafio de Periodos Faltantes
Proyecto que consume un servicio rest con fechas generadas al azar, 
devolviendo fechas faltantes dentro del periodo recibido 

Para compilar y ejecutar el proyecto, es necesario poseer Java y Maven instalados.
Preferentemente con JDK V.8

## PASOS PARA LEVANTAMIENTO DE PROYECTO GDD LOCAL ##
https://github.com/lmptechconsult/Generador_Datos_Desafio_Uno 

1-. clonar el repositorio GDD de forma local 
2-. Abrir una consola de comandos e ingresar al directorio ApiPeriodos para ejecutar el comando: mvn package
3-. Una vez compilado el proyecto, moverse al directorio target y ejecutar el siguiente comando: java -jar .\api-periodos-1.0.0.jar
4-. Esto levantará el proyecto de forma automática en el puerto 8080 y para visualizar la documentación puede dirigirse a la
    URL: http://127.0.0.1:8080/periodos/swagger-ui.html#/

# NOTA:
En caso de presentarse el error javax.xml.bind.annotation does not exist al momento de la compilación del generador

será necesario incorporar el siguiente codigo en el archivo pom.xml del proyecto GDD, dentro de las etiquetas <dependencies>
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.1</version>
</dependency>

Una vez agregado el código correspondiente, repetir los pasos 1, 2 y 3 para compilar el proyecto GDD

PASOS PARA LEVANTAMIENTO DE PROYECTO DESAFIO DE FORMA LOCAL 

1-. Abrir una consola de comandos e ingresar al directorio PruebaTechConsult para ejecutar el comando: mvn install
2-. Una vez construido el proyecto, debería aparecer la carpeta target; por lo que deben moverse dentro de este directorio
    y asegurarse de que se haya generado correctamente el archivo PruebaTechConsult-V1.0.jar
3-. Dentro de la consola de comando, asegurarse de encontrarse dentro del directorio target para ejecutar el comando:  
    java -jar pruebaTechConsult-V1.0.jar
4-. De levantarse correctamente, se hará sobre el puerto 8081 y podrá visualizarse desde: http://127.0.0.1:8081/busca-fechas

## NOTA: 

Para que el código funcione de forma adecuada, es necesario tener levantado el proyecto GDD en el puerto 8080 
y la búsqueda de datos en el puerto 8081, en caso de levantar el proyecto GDD en un puerto diferente deberá reemplazarse 
la línea de código private final static String URL = "http://127.0.0.1:8080/periodos/api"; 
por private final static String URL = "http://127.0.0.1:puerto/periodos/api";
esto debe hacer en la ruta: PruebaTechConsult/src/main/java/com/test/periodos/service/FechaService.java

En caso de tener ocupado el puerto 8081 para el levantamiento de la busqueda de periodos, debe reemplazarse
server.port:8081 por server.port:puerto
esto debe realizarse en la ruta PruebaTechConsult/src/main/resources/application.properties


## EJEMPLO DE SALIDA DE DATOS

{
    "id":1,
    "fechaCreacion":"2001-05-01",
    "fechaFin":"2017-05-01",
    "fechas":[
        "2001-05-01",
        "2001-07-01",
        "2001-09-01",
        "2001-11-01",
        "2002-01-01",
        "2002-02-01",
        "2002-03-01",
        "2002-06-01",
        "2002-08-01",
        "2002-09-01",
        "2002-10-01",
        "2002-11-01",
        "2002-12-01",
        "2003-01-01",
        "2003-02-01",
        "2003-05-01",
        "2003-07-01",
        "2003-08-01",
        "2003-10-01",
        "2004-02-01",
        "2004-06-01",
        "2004-07-01",
        "2004-09-01",
        "2004-11-01",
        "2005-01-01",
        "2005-03-01",
        "2005-04-01",
        "2005-05-01",
        "2005-06-01",
        "2005-08-01",
        "2005-11-01",
        "2005-12-01",
        "2006-03-01",
        "2006-04-01",
        "2006-05-01",
        "2006-06-01",
        "2006-09-01",
        "2006-10-01",
        "2007-05-01",
        "2007-06-01",
        "2007-07-01",
        "2007-09-01",
        "2007-10-01",
        "2007-11-01",
        "2007-12-01",
        "2008-01-01",
        "2008-08-01",
        "2008-09-01",
        "2008-10-01",
        "2008-11-01",
        "2009-02-01",
        "2009-03-01",
        "2009-04-01",
        "2009-06-01",
        "2009-07-01",
        "2009-09-01",
        "2009-11-01",
        "2010-01-01",
        "2010-02-01",
        "2010-03-01",
        "2010-07-01",
        "2010-10-01",
        "2010-12-01",
        "2011-01-01",
        "2011-06-01",
        "2011-08-01",
        "2012-01-01",
        "2012-02-01",
        "2012-03-01",
        "2012-04-01",
        "2012-05-01",
        "2012-09-01",
        "2012-12-01",
        "2013-02-01",
        "2013-06-01",
        "2013-07-01",
        "2013-10-01",
        "2013-12-01",
        "2014-01-01",
        "2014-02-01",
        "2014-03-01",
        "2014-08-01",
        "2014-09-01",
        "2014-12-01",
        "2015-02-01",
        "2015-04-01",
        "2015-05-01",
        "2015-07-01",
        "2015-08-01",
        "2015-12-01",
        "2016-03-01",
        "2016-04-01",
        "2016-05-01",
        "2016-06-01",
        "2016-09-01",
        "2016-11-01",
        "2017-03-01"
    ],
    "fechasFaltantes":[
        "2001-06-01",
        "2001-08-01",
        "2001-10-01",
        "2001-12-01",
        "2002-04-01",
        "2002-05-01",
        "2002-07-01",
        "2003-03-01",
        "2003-04-01",
        "2003-06-01",
        "2003-09-01",
        "2003-11-01",
        "2003-12-01",
        "2004-01-01",
        "2004-03-01",
        "2004-04-01",
        "2004-05-01",
        "2004-08-01",
        "2004-10-01",
        "2004-12-01",
        "2005-02-01",
        "2005-07-01",
        "2005-09-01",
        "2005-10-01",
        "2006-01-01",
        "2006-02-01",
        "2006-07-01",
        "2006-08-01",
        "2006-11-01",
        "2006-12-01",
        "2007-01-01",
        "2007-02-01",
        "2007-03-01",
        "2007-04-01",
        "2007-08-01",
        "2008-02-01",
        "2008-03-01",
        "2008-04-01",
        "2008-05-01",
        "2008-06-01",
        "2008-07-01",
        "2008-12-01",
        "2009-01-01",
        "2009-05-01",
        "2009-08-01",
        "2009-10-01",
        "2009-12-01",
        "2010-04-01",
        "2010-05-01",
        "2010-06-01",
        "2010-08-01",
        "2010-09-01",
        "2010-11-01",
        "2011-02-01",
        "2011-03-01",
        "2011-04-01",
        "2011-05-01",
        "2011-07-01",
        "2011-09-01",
        "2011-10-01",
        "2011-11-01",
        "2011-12-01",
        "2012-06-01",
        "2012-07-01",
        "2012-08-01",
        "2012-10-01",
        "2012-11-01",
        "2013-01-01",
        "2013-03-01",
        "2013-04-01",
        "2013-05-01",
        "2013-08-01",
        "2013-09-01",
        "2013-11-01",
        "2014-04-01",
        "2014-05-01",
        "2014-06-01",
        "2014-07-01",
        "2014-10-01",
        "2014-11-01",
        "2015-01-01",
        "2015-03-01",
        "2015-06-01",
        "2015-09-01",
        "2015-10-01",
        "2015-11-01",
        "2016-01-01",
        "2016-02-01",
        "2016-07-01",
        "2016-08-01",
        "2016-10-01",
        "2016-12-01",
        "2017-01-01",
        "2017-02-01",
        "2017-04-01"
    ]
}
 