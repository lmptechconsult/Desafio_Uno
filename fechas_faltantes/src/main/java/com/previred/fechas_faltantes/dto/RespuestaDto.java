package com.previred.fechas_faltantes.dto;

import com.previred.fechas_faltantes.models.FechasEntrada;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RespuestaDto {

    private int id;
    private LocalDate fechaCreacion;
    private LocalDate fechaFin;
    private List<LocalDate> fechas;
    private List<LocalDate> fechasFaltantes;

    public RespuestaDto(FechasEntrada fechasEntrada, List<LocalDate> fechasFaltantes) {
        this.id = fechasEntrada.getId();
        this.fechaCreacion = fechasEntrada.getFechaCreacion();
        this.fechaFin = fechasEntrada.getFechaFin();
        this.fechas = fechasEntrada.getFechas();
        this.fechasFaltantes = fechasFaltantes;
    }
}
