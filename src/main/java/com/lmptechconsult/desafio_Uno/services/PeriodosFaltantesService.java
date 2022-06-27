package com.lmptechconsult.desafio_Uno.services;

import com.lmptechconsult.desafio_Uno.model.Periodos;
import com.lmptechconsult.desafio_Uno.model.PeriodosFaltantes;

public interface PeriodosFaltantesService {
    
    public PeriodosFaltantes getPeriodosFaltantes();
    public PeriodosFaltantes getPeriodosFaltantes(Periodos periodos);
    public Periodos  getPeriodos();
    
}
