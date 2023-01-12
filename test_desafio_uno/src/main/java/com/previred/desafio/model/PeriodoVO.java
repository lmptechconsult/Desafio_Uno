/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.previred.desafio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author Javier Zambrano
 */
@Validated
public class PeriodoVO {
    @JsonProperty("id")
    private Long id = null;

    @JsonProperty("fechaCreacion")
    private LocalDate fechaCreacion = null;

    @JsonProperty("fechaFin")
    private LocalDate fechaFin = null;

    @JsonProperty("fechas")
    @Valid
    private List<LocalDate> fechas = null;
    
    @JsonProperty("fechasFaltantes")
    @Valid
    private List<LocalDate> fechasFaltantes = null;
    
    @JsonProperty("nError")
    @Valid
    private Long nError;
    
    @JsonProperty("sError")
    @Valid
    private String sError;

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

    public List<LocalDate> getFechas() {
        return fechas;
    }

    public void setFechas(List<LocalDate> fechas) {
        this.fechas = fechas;
    }

    public List<LocalDate> getFechasFaltantes() {
        return fechasFaltantes;
    }

    public void setFechasFaltantes(List<LocalDate> fechasFaltantes) {
        this.fechasFaltantes = fechasFaltantes;
    }

    public Long getnError() {
        return nError;
    }

    public void setnError(Long nError) {
        this.nError = nError;
    }

    public String getsError() {
        return sError;
    }

    public void setsError(String sError) {
        this.sError = sError;
    }
    
    
    
}
