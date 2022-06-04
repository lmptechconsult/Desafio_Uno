package com.test.GDD.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
@ApiModel
public class ScheduleDTO {

    private int id;
    private String fechaCreacion;
    private String fechaFin;
    private List<String> fechas;

    public ScheduleDTO(){
    }

    public ScheduleDTO(int id, String fechaCreacion, String fechaFin, List<String> fechas){
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaFin = fechaFin;
        this.fechas = fechas;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setFechaCreacion(String fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaCreacion(){
        return fechaCreacion;
    }

    public void setFechaFin(String fechaFin){
        this.fechaFin = fechaFin;
    }

    public String getFechaFin(){
        return fechaFin;
    }

    public void setFechas(List<String> fechas){
        this.fechas = fechas;
    }

    public List<String> getFechas(){
        return fechas;
    }

}
