package com.adolfopena.gdd.vo;

import java.util.List;

import lombok.Data;

@Data
public class PeriodDTO {
    
    private int id;
    private String fechaCreacion;
    private String fechaFin;
    private List<String> fechas;
    private List<String> fechasFaltantes;
    

}
