package com.previred.periodos.model;

import java.time.LocalDate;
import java.util.Set;


public class Periodo {
    private Long id;
    private LocalDate fechaCreacion;
    private LocalDate fechaFin;
    private Set<LocalDate> fechas;
    private Set<LocalDate> fechasFaltantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Set<LocalDate> getFechas() {
        return fechas;
    }

    public void setFechas(Set<LocalDate> fechas) {
        this.fechas = fechas;
    }

    public Set<LocalDate> getFechasFaltantes() {
        return fechasFaltantes;
    }

    public void setFechasFaltantes(Set<LocalDate> fechasFaltantes) {
        this.fechasFaltantes = fechasFaltantes;
    }
    
    
}
