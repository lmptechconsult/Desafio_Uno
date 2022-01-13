/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.previred.prueba.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */

public class Fechas {
    private Integer id;
    private String fechaCreacion;
    private String fechaFin;
    private List fechas = new ArrayList();

    public Fechas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List getFechas() {
        return fechas;
    }

    public void setFechas(List fechas) {
        this.fechas = fechas;
    }

}
