package com.desafio.periodos.config.exceptions;


public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = 6739276549855640282L;
    private String mensaje;
    private ExceptionBody cuerpoExcepcion;

    public ServiceException(String message) {
        super(message);
    }

    public ExceptionBody getCuerpoExcepcion() {
        return this.cuerpoExcepcion;
    }

    public void setCuerpoExcepcion(ExceptionBody cuerpoExcepcion) {
        this.cuerpoExcepcion = cuerpoExcepcion;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
