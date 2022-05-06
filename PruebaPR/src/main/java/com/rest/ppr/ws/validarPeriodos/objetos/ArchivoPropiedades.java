package com.rest.ppr.ws.validarPeriodos.objetos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import java.io.FileInputStream;

/** Clase que carga el archivo de propiedades.
 * @author Rodrigo.Pérez */
public class ArchivoPropiedades {

    /** Archivo logger. */
    private static final Logger LOGGER = Logger.getLogger("DesafioPreviRed");
    /** Variable privada estatica String de la clase. */
    private static final String STRING_CLASE = "[ArchivoPropiedades] ";
    /** Nombre del archivo de properties. */
    public static final String NOMBRE_ARCHIVO_PROPERTIES = "application.properties";

    /** Metodo que permite cargar el archivo de propiedades.
     * @return Properties. */
    public Properties cargarArchivoPropiedades() {
        Properties prop = new Properties();
        InputStream input = null;
        String sNomRutaServer = "";
        final String nombreMetodo = STRING_CLASE + "[cargarArchivoPropiedades] ";
        LOGGER.debug(nombreMetodo + "Inicia metodo");
        try {
            if (System.getProperty("jboss.server.config.dir") == null) {
                sNomRutaServer = "src/main/resources" + File.separator + NOMBRE_ARCHIVO_PROPERTIES;
            } else {
                sNomRutaServer = System.getProperty("jboss.server.config.dir") + File.separator + "etc" + File.separator + NOMBRE_ARCHIVO_PROPERTIES;
            }

            input = new FileInputStream(sNomRutaServer);
            prop.load(input);
            LOGGER.debug(nombreMetodo + "Se obtuvieron propiedades");

        } catch (IOException ex) {
            LOGGER.error(nombreMetodo + "Error al cargar archivo application.properties. " + ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    LOGGER.error(nombreMetodo + "Error al cerrar InputStream application.properties. " + e);
                }
            }
        }
        return prop;
    }
}
