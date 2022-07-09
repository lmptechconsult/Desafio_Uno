package com.tech.desafio1.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.desafio1.model.ResponseFinal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;


public interface ResponseService {

    Logger log = LoggerFactory.getLogger(ResponseService.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @RequestMapping(value = "/api/desafio1",
            produces = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<ResponseFinal> responseFinal() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"fechaCreacion\" : \"2000-01-23\",  \"fechas\" : [ \"2000-01-23\", \"2000-01-23\" ],  \"id\" : 0,  \"fechaFin\" : \"2000-01-23\"},\"fechasFaltantes\" : [\"2000-01-23\"]\"} ", ResponseFinal.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ResponseService interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
