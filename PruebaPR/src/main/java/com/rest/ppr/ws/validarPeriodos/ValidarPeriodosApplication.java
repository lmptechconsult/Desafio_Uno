package com.rest.ppr.ws.validarPeriodos;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.jdbc.*;

import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;

import javax.annotation.PostConstruct;

/** Clase principal.
 * @author Rodrigo.Pérez */
@SpringBootApplication(scanBasePackages = { "com.rest.ppr.ws.validarPeriodos", "com.rest.ppr.ws.validarPeriodos.controller", "com.rest.ppr.ws.validarPeriodos.service" })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableScheduling
public class ValidarPeriodosApplication extends SpringBootServletInitializer implements ApplicationContextAware {

    /** Objeto Logger: Se utiliza para activar el registro de logs */
    private static final Logger LOGGER = Logger.getLogger("DesafioPreviRed");
    /** Nombre del archivo de logger. */
    public static final String NOMBRE_ARCHIVO_LOG4J = "log4j.properties";
    /** OBjeto String con el nombre de la clase, usado para el log */
    private static final String STRING_CLASE = "[ValidarPeriodosApplication] ";

    /** Context: Contexto de la aplicacion **/
    private static ApplicationContext applicationContext;

    /** Metodo para setear el contexto de la aplicacion.
     * @param applicationContext
     * @throws BeansException */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /** MEtodo que inicia la aplicacion */
    @PostConstruct
    public static void init() {
        final String nombreMetodo = STRING_CLASE + "[init] ";
        final String log4jConfPath;
        if (System.getProperty("jboss.server.config.dir") == null) {
            log4jConfPath = "src/main/resources" + File.separator + NOMBRE_ARCHIVO_LOG4J;
        } else {
            log4jConfPath = System.getProperty("jboss.server.config.dir") + File.separator + "etc" + File.separator + NOMBRE_ARCHIVO_LOG4J;
        }

        PropertyConfigurator.configure(log4jConfPath);
        LOGGER.debug(nombreMetodo + "Arranca servicio ValidarPeriodos...");

    }
}
