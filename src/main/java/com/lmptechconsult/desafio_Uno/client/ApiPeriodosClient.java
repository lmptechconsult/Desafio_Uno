package com.lmptechconsult.desafio_Uno.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.lmptechconsult.desafio_Uno.config.ApiGddProperties;
import com.lmptechconsult.desafio_Uno.model.Periodos;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ApiPeriodosClient {
    @Autowired
	@Setter
	ApiGddProperties apiProps;

    public Periodos getPeriodos(){
        String url = apiProps.getHost().concat(apiProps.getPathPeriodosApi());
        log.info("Obteniendo periodos desde [GET -> {}]",url);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Periodos> responsePeriodo =  restTemplate.getForEntity(url, Periodos.class);
            return responsePeriodo.getBody();
        } catch (RestClientException e) {
            log.error("Error al intentar obtener periodos desde [GET -> {}]",url);
            return null;
        }
     
    }
}
