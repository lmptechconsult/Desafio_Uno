# Desarrollo aplicación desafío uno

#### Pre-requisitos
##### Técnicos 
> Para ejecutar el proyecto desarollado se requiere **JDK 11**, además comento que la versión de maven usada para la compilación fue: **Apache Maven 3.3.9**

##### Operacionales 
> Se requiere que el servicio de generación de fechas este disponible en la ruta **http://localhost:8080/periodos/api**, esta ruta esta configurada en la aplicación por defecto, si esta en otra ruta la api se puede cambiar dinámicamente al iniciar la aplicación

#### Instalación
> Para instalar la aplicación ingresar a la carpeta **app-rest-api** que esta en la raíz del repositorio y  ejecutar:  **mvn clean install** en la raíz del proyecto, la aplicación contiene un 1 test para probar las fechas faltantes, si no se requiere ejecutar el test para la instalación ejecutar el comando: **mvn clean install -DskipTests=true**

#### Ejecución
> Para ejecutar el proyecto entrar en la raíz del proyecto, luego ir a la carpeta **/target** generada al interior de la carpeta **app-rest-api** y ejecutar el comando: <br/><br/>
	**java -jar missing-date-api-1.0.0-SNAPSHOT.jar** 
	<br/><br/>
Por defecto la aplicación inicia en el puerto **8081**. Como se comentó en los pre-requisitos operacionales si se requiere cambiar la ruta de la api de generación de fechas se puede hacer iniciando la aplicación con el siguiente comando: <br/><br/>
	**java -jar -Dapi.rest.remote.host=HOST:PORT -Dapi.rest.remote.endpoint=ENDPOINT_URI missing-date-api-1.0.0-SNAPSHOT.jar**, 
ejemplo: java -jar -Dapi.rest.remote.host=http://localhost:7879 -Dapi.rest.remote.endpoint=/periodos/v2/api
missing-date-api-1.0.0-SNAPSHOT.jar 
<br/><br/>
Si se requiere activar el log DEBUG para las clases de la aplicación iniciar con el comando: <br/><br/>
	**java -jar -Dlogging.level.com.previred.app=DEBUG missing-date-api-1.0.0-SNAPSHOT.jar** 

#### Test API
> Para testar la api se puede ingresar a swagger en la url [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html) y ejecutar el endpoint GET /api/v1/search/missing/dates o se puede ir a la url [http://localhost:8081/api/v1/search/missing/dates](http://localhost:8081/api/v1/search/missing/dates) directamente, en ambos casos se invocará el servicio que busca las fechas en el geenerador de fechas y calcula las faltantes. <br/><br/>

#### Archivos
> En la raíz del repositorio hay dos archivos **INPUT.json** y **OUTPUT.json**, estos son los archivos de ejemplos solicitados donde el INPUT contiene la entrada de fechas aleatorias y el OUTPUT el json original más las fechas faltantes.
