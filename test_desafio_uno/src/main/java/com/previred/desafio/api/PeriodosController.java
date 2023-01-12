/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.previred.desafio.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.previred.desafio.model.PeriodoVO;
import com.previred.desafio.service.PeriodosService;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Javier Zambrano
 */
@Controller
public class PeriodosController implements IPeriodosService {
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private PeriodosService periodosService;

    @org.springframework.beans.factory.annotation.Autowired
    public PeriodosController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<PeriodoVO> getPeriodos() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains(MediaType.APPLICATION_JSON_VALUE)) {
                try {
                    PeriodoVO detalle =  periodosService.callApiPeriodosGDD();
                    ResponseEntity<PeriodoVO> respuesta = new ResponseEntity<>(detalle, HttpStatus.OK);
                    return respuesta;
                } catch (Exception e) {
                    log.error("Couldn't serialize response for content type application/xml", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DefaultApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
