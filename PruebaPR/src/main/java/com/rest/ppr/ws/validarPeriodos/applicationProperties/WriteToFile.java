package com.rest.ppr.ws.validarPeriodos.applicationProperties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/** Clase que setea las variables y genera el archivo application.properties ubicado en la ruta ./etc/application.properties
 * @author Rodrigo.Pérez */

public class WriteToFile {
    /** Objeto Logger: Se utiliza para activar el registro de logs */
    private static final Logger LOGGER = Logger.getLogger("PruebaPR");
    /** Variable privada estatica String de la clase. */
    private static final String STRING_CLASE = "[WriteToFile] ";

    /** setea las variables y las escribe en el archivo ./etc/application.properties */
    public void writeToFile() {

        Properties prop = new Properties();
        OutputStream output = null;
        final String nombreMetodo = STRING_CLASE + "[writeToFile] ";

        try {

            String sNomRutaServer;
            if (System.getProperty("jboss.server.config.dir") == null) {
                sNomRutaServer = "src/main/resources" + File.separator + "application.properties";
            } else {
                sNomRutaServer = System.getProperty("jboss.server.config.dir") + File.separator + "etc" + File.separator + "application.properties";
            }

            output = new FileOutputStream(sNomRutaServer);
            prop.setProperty("direccion", "http://localhost");
            prop.setProperty("endPoint", "/periodos/api");
            prop.setProperty("puerto", "8081");
            prop.setProperty("wsGDD", "http://svr.transporte.app2:8081/sam/rest/keystore/ObtenerKeyStore");
            prop.setProperty("spring.jmx.enabled", "false");
            prop.store(output, null);

        } catch (IOException io) {
            LOGGER.error(nombreMetodo + "Error al abrir archivo el FileOutputStream de application.properties. " + io);
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    LOGGER.error(nombreMetodo + "Error al intentar cerrar el FileOutputStream de application.properties. " + e);
                }
            }

        }
    }
}