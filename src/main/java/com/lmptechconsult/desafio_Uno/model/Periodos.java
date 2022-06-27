package com.lmptechconsult.desafio_Uno.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Periodos {
    
    @Getter @Setter private LocalDate fechaCreacion;
    @Getter @Setter private LocalDate fechaFin;
    @Getter @Setter private List<LocalDate> fechas;
    @Getter @Setter private Integer id;

}
