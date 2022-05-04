package com.camilonavarrete.previred.fechasperdidas.controller;

import com.camilonavarrete.previred.fechasperdidas.model.FechasProcesadas;
import com.camilonavarrete.previred.fechasperdidas.service.FechasPerdidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class FechasPerdidasController {

    @Autowired
    private FechasPerdidasService fechasPerdidasService;

    /** Endpoint que procesa las fechas aleatorias recibidas por el servicio GDD devolviendo un listado
     * de fechas perdidas entre el rango dado por dicho servicio
     * @return Retorna JSON con las fechas aleatorias generadas más las fechas perdidas.
     */
    @GetMapping("/obtener-fechas-perdidas")
    public ResponseEntity<FechasProcesadas> obtenerFechasPerdidas() {
        return fechasPerdidasService.consultaFechasServicio();
    }




}
