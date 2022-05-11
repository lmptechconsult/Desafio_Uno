Instrucciones:


1. Abrir la consola y clonar el repositorio con el siguiente comando:

git clone https://github.com/lmptechconsult/Desafio_Uno.git

2. Situarse en el directorio raiz del proyecto con:

cd Desafio_Uno

3. Ejecutar el siguiente comando para compilar el proyecto:

mvn package

4. Una vez lista la compilacion sin errores, ejecutamos la app con el siguiente comando:

java -jar target/desafio-1.0.jar'



A considerar:

1. Esta aplicacion por defecto funciona en el puerto 8090, si se requiere cambiar, ir al archivo applicacion.properties de la ruta /Desafio_Uno/src/main/resources y 
cambiar el valor de server.port, luego compilar.

2. Si se requiere cambiar la direccion que apunta a la api GDD, ir al archivo applicacion.properties de la ruta /Desafio_Uno/src/main/resources y 
cambiar el valor de previred.api.url, luego compilar.


Requisitos:

Para realizar esta instalación y posterior despliegue, es necesario tener maven instalado.

Para revisar la documentación de la api, basta con ir a la siguiente dirección http://localhost:8080/swagger-ui.html#/
