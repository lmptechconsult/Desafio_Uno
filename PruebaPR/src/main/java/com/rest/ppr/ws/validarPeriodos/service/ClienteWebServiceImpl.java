package com.rest.ppr.ws.validarPeriodos.service;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/** Clase que permite enviar solicitud a ValidadorFirmas.
 * @author Rodrigo.Pérez */
public class ClienteWebServiceImpl implements ClienteWebService {

    /** Logger de la clase. */
    private static final Logger LOGGER = Logger.getLogger("PruebaPR");
    /** Variable privada estatica String de la clase. */
    private static final String STRING_CLASE = "[ClienteWebServiceImpl] ";
    /** Instancia de Gson para convertir objetos a formato JSON. */
    private static final Gson gson = new Gson();

    /** Constructor de la clase ClienteWebService. */
    public ClienteWebServiceImpl() {

        //
    }

    @Override
    public String enviarSolicitudGDD(String endpoint) {
        final String nombreMetodo = STRING_CLASE + "[enviarSolicitudGDD] ";
        LOGGER.debug(nombreMetodo + endpoint);
        try {
            int minimalTimeOut = 5000;
            Unirest.setTimeouts(minimalTimeOut, minimalTimeOut);
            final HttpResponse<JsonNode> jsonResponse = Unirest.get(endpoint).header("accept", "application/json").asJson();
            final JsonNode body = jsonResponse.getBody();
            // Unirest.shutdown();
            return body.toString();
        } catch (UnirestException e) {
            LOGGER.error(nombreMetodo + "Error al enviar solicitud al ws : ", e);
        }
        return null;
    }
}
