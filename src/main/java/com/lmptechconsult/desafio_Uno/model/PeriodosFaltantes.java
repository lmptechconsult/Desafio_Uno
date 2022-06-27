package com.lmptechconsult.desafio_Uno.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class PeriodosFaltantes implements Serializable {
    // @JsonFormat(pattern="yyyy-MM-dd")
    @Getter
    @Setter
     private LocalDate fechaCreacion;
    @Getter
    @Setter
     private LocalDate fechaFin;
    @Getter
    @Setter
     private List<LocalDate> fechas;
    @Getter
    @Setter
    private List<LocalDate> fechasFaltantes;
    @Getter
    @Setter
    private Integer id;
}
