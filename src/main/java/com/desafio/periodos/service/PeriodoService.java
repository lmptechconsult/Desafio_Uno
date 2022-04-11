package com.desafio.periodos.service;

import com.desafio.periodos.model.Periodo;

public interface PeriodoService {

    /**
     * Método para obtener los periodos faltantes de una lista de fechas retornadas por un servicio externo
     * @return Periodo con lista de fechas faltantes
     */
    Periodo obtenerFechasFaltantes();
}
