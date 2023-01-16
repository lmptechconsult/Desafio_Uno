package com.test.periodos.model;

import java.time.LocalDate;
import java.util.List;

public class CFechas {

    private int id;
    private LocalDate fechaCreacion;
    private LocalDate fechaFin;
    private List<LocalDate> fechas;

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
    public void setFechas(List<LocalDate> fechas) {
        this.fechas = fechas;
    }
    @Override
    public String toString() {
        return "Fechas [id=" + id + ", fechaInicial=" + fechaCreacion + ", fechaFinal=" + fechaFin + ", fechas="
                + fechas + "]";
    }

}