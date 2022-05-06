package com.rest.ppr.ws.validarPeriodos.model;

import java.util.List;

public class RespuestaValidarPeriodos {
    private String fechaCreacion;
    private List<String> fechas;
    private Long id;
    private String fechaFin;
    private List<String> fechasFaltantes;
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public List<String> getFechas() {
        return fechas;
    }
    public void setFechas(List<String> fechas) {
        this.fechas = fechas;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public List<String> getFechasFaltantes() {
        return fechasFaltantes;
    }
    public void setFechasFaltantes(List<String> fechasFaltantes) {
        this.fechasFaltantes = fechasFaltantes;
    }
    
}
