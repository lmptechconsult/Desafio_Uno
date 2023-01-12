/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.previred.desafio.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.previred.desafio.model.PeriodoVO;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;
import org.springframework.http.MediaType;

/**
 *
 * @author javier zambrano
 */
@Api(value = "api", description = "API Desafio Uno Previred - Consulta Periodos")
public interface IPeriodosService {
    Logger log = LoggerFactory.getLogger(IPeriodosService.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Lista Periodos de API GDD y Periodos Faltantes", nickname = "periodos", notes = "", response = PeriodoVO.class, tags={ "periodos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Periodos GDD, Fechas GDD, Fechas faltantes", response = PeriodoVO.class) })
    @RequestMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    default ResponseEntity<PeriodoVO> getPeriodos() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains(MediaType.APPLICATION_JSON_VALUE)) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"fechaCreacion\" : \"2022-01-01\",  \"fechas\" : [ \"2022-01-01\", \"2022-02-01\" ],  \"id\" : 0,  \"fechaFin\" : \"2023-01-01\"}", PeriodoVO.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Error al serializar objeto el formato debe ser application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ApiApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
