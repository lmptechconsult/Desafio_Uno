package com.desafio.periodos.api;


import com.desafio.periodos.model.Periodo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/periodos")
public interface PeriodoApi {


    /**
     * Método para obtener los periodos faltantes de una lista de fechas retornadas por un servicio externo
     * @return Periodo con lista de fechas faltantes
     */
    @GetMapping("/obtener-fechas-faltantes")
    ResponseEntity<Periodo> obtenerFechasFaltantes();
}
