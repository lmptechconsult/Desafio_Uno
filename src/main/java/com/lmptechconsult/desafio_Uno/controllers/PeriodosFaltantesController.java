package com.lmptechconsult.desafio_Uno.controllers;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lmptechconsult.desafio_Uno.model.PeriodosFaltantes;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
@Api(tags = "Periodos" )
@RequestMapping("/periodos")
public interface PeriodosFaltantesController {

    @GetMapping(value = "/faltantes", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Obtener periodos faltantes", description = "Calcula los periodos faltantes a partir de un periodo obtenido desde GDD", responses = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = PeriodosFaltantes.class))),
            @ApiResponse(responseCode = "502", description = "Error al obtener periodos desde GDD"),
            @ApiResponse(responseCode = "500", description = "Error interno") })
    public ResponseEntity<PeriodosFaltantes> getPeriodosFaltantes();
}
