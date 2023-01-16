package com.test.periodos.model;

import java.time.LocalDate;
import java.util.List;

public class CPeriodos {

    private int id;
    private LocalDate fechaCreacion;
    private LocalDate fechaFin;
    private List<LocalDate> fechas;
    private List<LocalDate> fechasFaltantes;

    public CPeriodos(CFechas dateInput, List<LocalDate> datesMissing) {
        this.id = dateInput.getId();
        this.fechaCreacion = dateInput.getFechaCreacion();
        this.fechaFin = dateInput.getFechaFin();
        this.fechas = dateInput.getFechas();
        this.fechasFaltantes = datesMissing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<LocalDate> getFechas() {
        return fechas;
    }

    public void setFechasAleatorias(List<LocalDate> fechasAleatorias) {
        this.fechas = fechasAleatorias;
    }

    public List<LocalDate> getFechasFaltantes() {
        return fechasFaltantes;
    }

    public void setTodasFechas(List<LocalDate> fechasFaltantes) {
        this.fechasFaltantes = fechasFaltantes;
    }

}
