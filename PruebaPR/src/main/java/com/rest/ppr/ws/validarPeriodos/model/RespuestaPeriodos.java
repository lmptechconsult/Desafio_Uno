package com.rest.ppr.ws.validarPeriodos.model;

import java.time.LocalDate;
import java.util.List;

public class RespuestaPeriodos {
    private String fechaCreacion;
    private List<String> fechas;
    private Long id;
    private String fechaFin;
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
}
