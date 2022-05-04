package com.camilonavarrete.previred.fechasperdidas.model;

import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FechasProcesadas {

    private Integer id;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private List<LocalDate> fechasServicio;
    private List<LocalDate> fechasProcesadas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public List<LocalDate> getFechasServicio() {
        return fechasServicio;
    }

    public void setFechasServicio(List<LocalDate> fechasServicio) {
        this.fechasServicio = fechasServicio;
    }

    public List<LocalDate> getFechasProcesadas() {
        return fechasProcesadas;
    }

    public void setFechasProcesadas(List<LocalDate> fechasProcesadas) {
        this.fechasProcesadas = fechasProcesadas;
    }

    public FechasProcesadas() {
    }

    public FechasProcesadas(Integer id,
                            LocalDate fechaInicial,
                            LocalDate fechaFinal,
                            List<LocalDate> fechasServicio,
                            List<LocalDate> fechasProcesadas) {
        this.id = id;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.fechasServicio = fechasServicio;
        this.fechasProcesadas = fechasProcesadas;
    }

    public FechasProcesadas(FechasServicio fechasServicio) {
        this.id = fechasServicio.getId();
        this.fechaInicial = fechasServicio.getFechaCreacion();
        this.fechaFinal = fechasServicio.getFechaFin();
        this.fechasServicio = fechasServicio.getFechas();
        this.fechasProcesadas = new ArrayList<>();
    }


}
