package com.adolfopena.gdd.vo;

import java.util.List;

import lombok.Value;

@Value
public class PeriodVO {

    private int id;
    private String fechaCreacion;
    private String fechaFin;
    private List<String> fechas;
    
}
