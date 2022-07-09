package com.tech.desafio1.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.desafio1.model.ResponseFinal;
import com.tech.desafio1.services.ResponseService;
import com.tech.desafio1.services.ResponseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class ResponseController implements ResponseService{

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private ResponseServiceImpl responseServiceImpl = new ResponseServiceImpl();

    @org.springframework.beans.factory.annotation.Autowired
    public ResponseController(ObjectMapper objectMapper, HttpServletRequest request) {
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
    public ResponseEntity<ResponseFinal> responseFinal() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    ResponseFinal responseFinal = responseServiceImpl.responseService();
                    ResponseEntity<ResponseFinal> respuesta = new ResponseEntity<>(responseFinal, HttpStatus.OK);
                    return respuesta;
                } catch (Exception e) {
                    log.error("Couldn't serialize response for content type application/xml", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DefaultResponse interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
