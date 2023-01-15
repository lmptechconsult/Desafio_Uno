package com.example.desafio.entities;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class GeneradorDeDatosResponse {

    private int id;
    private String fechaCreacion;
    private String fechaFin;
    private ArrayList<String> fechas;

    public GeneradorDeDatosResponse(int id, String fechaCreación, String fechaFin, ArrayList<String> fechas) {
        this.id = id;
        this.fechaCreacion = fechaCreación;
        this.fechaFin = fechaFin;
        this.fechas = fechas;
    }

    public GeneradorDeDatosResponse() {
        this.id = 0;
        this.fechaCreacion = "fechaCreación";
        this.fechaFin = "fechaFin";
        this.fechas = new ArrayList<String>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ArrayList<String> getFechas() {
        return fechas;
    }

    public void setFechas(ArrayList<String> fechas) {
        this.fechas = fechas;
    }
}
