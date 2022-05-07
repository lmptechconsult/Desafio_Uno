package com.previred.fechas_faltantes.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FechasEntrada {
    private int id;
    private LocalDate fechaCreacion;
    private LocalDate fechaFin;
    private List<LocalDate> fechas;
}
