package com.camilonavarrete.previred.fechasperdidas.service;

import com.camilonavarrete.previred.fechasperdidas.model.FechasProcesadas;
import org.springframework.http.ResponseEntity;


public interface FechasPerdidasService {


    public ResponseEntity<FechasProcesadas> consultaFechasServicio();


}
