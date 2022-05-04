



Nombre: Camilo Joaquin Navarrete Portiño

Mail: camilonavarreteportino@gmail.com

<a href="https://linkedin.com/in/camilo-navarrete-portino/" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="camilo-navarrete-portino/" height="20" width="40" /></a>



## <u>**Desafío 1 PreviRed Nivel 3.**</u>

#### **Recuperación de fechas perdidas a partir de consumo API GDD**



<h3 align="left">Lenguajes: Java SpringBoot</h3>
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>



**Instrucciones:**



<u>Existen dos posibilidades:</u>

- Ejecutar directamente importando proyecto en un IDE de su preferencia
- Compilar proyecto en JAR y ejecutarlo desde una terminal.



Se debe tener habilitado el puerto 8081 (Designado para levantar via SpringBoot web)

Si se desea cambiar el puerto como la ruta de la API generadora de fechas, acceder a los archivos de configuracion aplication.properties y config.properties en la carpeta resources del proyecto para modificar.



Si desea ejecutarlo desde su IDE de preferencia, descargar el proyecto en conjunto con la API generador de fechas y alojarlos dentro de un directorio raiz.



![image-20220504180733448](img/image-20220504180733448.png)



Importar el proyecto como proyecto maven (Se utilizara IntellJ como ejemplo) y descargar las dependencias.
![image-20220504181002188](img/image-20220504181002188.png)



Este será reconocido como proyecto Maven (se debe tener previamente instalado Maven), detectando los servicios a ejecutar. Iniciar ambos servicios.

![image-20220504181205240](img/image-20220504181205240.png)



En caso de ejecutar el JAR:

Abrimos una terminal en la carpeta raíz del proyecto ejecutando el comando <u>**mvn clean package**</u> y esperamos una compilación exitosa.

![image-20220504181644832](img/image-20220504181644832.png)

![image-20220504181746131](img/image-20220504181746131.png)



Vamos a la carpeta target del proyecto, copiamos el nombre del jar generado y levantamos la aplicacion con el comando java **-jar target/fechasperdidas-0.0.1-SNAPSHOT.jar**

![image-20220504181838068](img/image-20220504181838068.png)

![image-20220504182030874](img/image-20220504182030874.png)





Con la aplicacion arriba podemos ejecutarla mediante 3 opciones: Navegador, Postman, Swagger UI



**Navegador:**

Introducimos la direccion local del equipo junto a su ruta API  ([localhost:8081/api/obtener-fechas-perdidas](http://localhost:8081/api/obtener-fechas-perdidas))

![image-20220504182706483](img/image-20220504182706483.png)

**Postman:** Colocamos la ruta (localhost:8081/api/obtener-fechas-perdidas) bajo peticion GET y consultamos con Send.

![image-20220504182746449](img/image-20220504182746449.png)



**Swagger:** Abrimos el navegador y colocamos la ruta (http://localhost:8081/swagger-ui.html), que nos abrira una interfaz grafica de Swagger para consultar el endpoint.

Seleccionamos fechas-perdidas-controller y presionamos GET.

![image-20220504182923368](img/image-20220504182923368.png)



Presionamos el boton TryOut y luego Execute dandonos la respuesta a la peticion con las fechas recuperadas.

![image-20220504183142769](img/image-20220504183142769.png)





