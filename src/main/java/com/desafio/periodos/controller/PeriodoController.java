package com.desafio.periodos.controller;

import com.desafio.periodos.api.PeriodoApi;
import com.desafio.periodos.model.Periodo;
import com.desafio.periodos.service.PeriodoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeriodoController implements PeriodoApi {

    private static final Log LOGGER = LogFactory.getLog(PeriodoController.class);

    private final PeriodoService periodoService;

    @Autowired
    public PeriodoController(PeriodoService periodoService) {
        this.periodoService = periodoService;
    }

    @Override
    @ApiOperation(value="Obtener periodos faltantes", notes="Entrega lista de fechas aleatorias y lista de fechas faltantes")
    @ApiResponses(value={
            @ApiResponse(code= 200, message= "Fechas generadas", response=Periodo.class),
            @ApiResponse(code = 401,message = "No autorizado",response = String.class),
            @ApiResponse(code = 403, message = "Prohibido",response = String.class),
            @ApiResponse(code= 404, message="No encuentra recurso", response=String.class),
            @ApiResponse(code= 500, message="Error interno del servidor", response=String.class)
    })
    public ResponseEntity<Periodo> obtenerFechasFaltantes() {
        LOGGER.info("Inicio peticion obtenerFechasFaltantes");
        Periodo periodo = this.periodoService.obtenerFechasFaltantes();
        return ResponseEntity.ok(periodo);
    }
}
