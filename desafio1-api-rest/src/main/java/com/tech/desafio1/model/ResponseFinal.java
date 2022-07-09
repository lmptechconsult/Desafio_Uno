package com.tech.desafio1.model;

import java.time.LocalDate;
import java.util.List;

public class ResponseFinal {

    private Periodo currentPeriodo = null;

    private List<LocalDate> fechasFaltantes = null;

    public ResponseFinal(Periodo currentPeriodo, List<LocalDate> fechasFaltantes) {
        this.currentPeriodo = currentPeriodo;
        this.fechasFaltantes = fechasFaltantes;
    }

    public Periodo getCurrentPeriodo() {
        return currentPeriodo;
    }

    public void setCurrentPeriodo(Periodo currentPeriodo) {
        this.currentPeriodo = currentPeriodo;
    }

    public List<LocalDate> getFechasFaltantes() {
        return fechasFaltantes;
    }

    public void setFechasFaltantes(List<LocalDate> fechasFaltantes) {
        this.fechasFaltantes = fechasFaltantes;
    }
}
