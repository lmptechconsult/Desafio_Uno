Willian Pacheco
DESAFIO

1.- Para copilar el proyecto se requiere Java y Maven instalado. Ingresar al directorio ApiDesafio y  ejecutar el siguiente comando maven:

	mvn package


2.- Luego de compilar el proyecto ingresar al directorio target ejecutar el siguiente comando java

	java -jar .\desafio-1.0.0.jar

NOTA: Debe estar disponible el purto 8081


3.- La documentación swagger del API (una vez que se levanta el API) queda disponible en

	http://127.0.0.1:8081/desafio/swagger-ui.html


4. Para consumir el servicio se debe invocar la siguiente URL

curl -X GET "http://localhost:8081/desafio/api/fechasFaltantes" -H "accept: application/json"

