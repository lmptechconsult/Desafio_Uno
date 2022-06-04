package com.test.GDD.model;

import java.util.List;

import io.swagger.annotations.ApiModel;

@ApiModel
public class ScheduleResponseDTO {

    private int id;
    private String fechaCreacion;
    private String fechaFin;
    private List<String> fechasFaltantes;

    public ScheduleResponseDTO(){
    }

    public ScheduleResponseDTO(int id, String fechaCreacion, String fechaFin, List<String> fechasFaltantes){
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaFin = fechaFin;
        this.fechasFaltantes = fechasFaltantes;
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

    public void setFechasFaltantes(List<String> fechasFaltantes){
        this.fechasFaltantes = fechasFaltantes;
    }

    public List<String> getFechasFaltantes(){
        return fechasFaltantes;
    }

}
