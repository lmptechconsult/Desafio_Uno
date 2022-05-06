package com.rest.ppr.ws.validarPeriodos.service;


/**
 * Interface ClienteWebService
 * @author Gabriel.Gamboa
 */
public interface ClienteWebService {

    /**
     * Metodo que permite enviar un comando en formato json utilizando Unirest.
     * @param endpoint Endpoint de conexion
     * @param comandoValidadorFirma Comando de validacion de firma.
     * @param timeout Tiempo de espera para cerrar conexion.
     * @return Respuesta del servicio.
     */
    String enviarSolicitudGDD(final String endpoint);
}
