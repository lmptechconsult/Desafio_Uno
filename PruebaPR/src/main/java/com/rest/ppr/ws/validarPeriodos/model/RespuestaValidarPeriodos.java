package com.rest.ppr.ws.validarPeriodos.model;

import java.util.List;

public class RespuestaValidarPeriodos {
    private RespuestaPeriodos respuestaPeriodos;
    private List<String> fechasFaltantes;
    public RespuestaPeriodos getRespuestaPeriodos() {
        return respuestaPeriodos;
    }
    public void setRespuestaPeriodos(RespuestaPeriodos respuestaPeriodos) {
        this.respuestaPeriodos = respuestaPeriodos;
    }
    public List<String> getFechasFaltantes() {
        return fechasFaltantes;
    }
    public void setFechasFaltantes(List<String> fechasFaltantes) {
        this.fechasFaltantes = fechasFaltantes;
    }
}
