package com.rest.ppr.ws.validarPeriodos.objetos;

/**
 * Clase que representa la conexion con el servicio de validacion de firmas.
 * @author Rodrigo.Pérez
 */
public class ConexionServicio {

    /**
     * Direccion del servicio.
     */
    private String direccion;
    /**
     * Puerto del servicio.
     */
    private String puerto;
    /**
     * Endpoint.
     */
    private String endpoint;
    /**
     * Metodo que permite obtener la direccion del servicio.
     * @return Direccion.
     */
    public final String getDireccion() {
        return direccion;
    }

    /**
     * Metodo que permite setear la direccion del servicion.
     * @param direccionIn Direccion.
     */
    public final void setDireccion(final String direccionIn) {
        this.direccion = direccionIn;
    }

    /**
     * Metodo que permite obtener el puerto del servicio.
     * @return Puerto.
     */
    public final String getPuerto() {
        return puerto;
    }

    /**
     * Metodo que permite setear el puerto del servicio.
     * @param puertoIn Puerto.
     */
    public final void setPuerto(final String puertoIn) {
        this.puerto = puertoIn;
    }

    /**
     * Metodo que permite obtener el endpoint del servicio.
     * @return Endpoint.
     */
    public final String getEndpoint() {
        return endpoint;
    }

    /**
     * Metodo que permite setear el endpoint del servicio.
     * @param endpointIn Endpoint.
     */
    public final void setEndpoint(final String endpointIn) {
        this.endpoint = endpointIn;
    }
}
