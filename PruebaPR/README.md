# Desafío 1: Periodos perdidos

Para compilar, desplegar y probar la solucion se describen los siguientes pasos.

NOTA: La solucion se desplegara en un servidor Wildfly. El quipo debe tener instalado JDK

Requisitos:
- Descargar el servidor wildfly del siguiente enlace: https://drive.google.com/file/d/14Zqpg7nr5NkW-riKPUs5TZiUi1BO7y8q/view?usp=sharing
- Extraer wildfly-10.1.0.Final

## Compilar: 

Una vez clonado el proyecto "PruebaPR" en nuestro equipo, ingresar por consola (cmd) al directorio PruebaPR del proyecto y ejecutar:
- mvn clean
- mvn install

Esto genera el .war (DesafioPreviRed-0.0.1.war) en el directorio ./target de nuestro proyecto.
- Copiar DesafioPreviRed-0.0.1.war y Pegar en el directorio ./deployments del servidor wildfly (wildfly-10.1.0.Final\standalone\deployments)
NOTA: Este paso se recomienda hacer manualmente (no por comandos cmd)

## Desplegar: 
Para iniciar el servidor wildfly ingresar por consola (cmd) al directorio ./bin (wildfly-10.1.0.Final\bin) y ejecutar:
- standalone.bat

Esto iniciara el servidor y desplegara lo que se encuentre en el directorio ./deployments
NOTA: Para verificar que el despliegue quedo OK, ir al directorio ./deployments y ver que se haya creado DesafioPreviRed-0.0.1.war.deployed


Para consumir el servicio se debe invocar la siguiente URL http://127.0.0.1:8080/DesafioPreviRed/validarPeriodos

## Adicional: 
- Se escribe archivo DesafioPreviRed.log del servicio en cada invocacion. Este esta disponible en el directorio ./log del servidor wildfly (wildfly-10.1.0.Final\standalone\log)
- Se generan archivos respuestaValidarPeriodos.json y respuestaValidarPeriodos.yml con la respuesta del servicio. Estos estan disponibles en el directorio ./bin del servidor wildfly (wildfly-10.1.0.Final\bin)
