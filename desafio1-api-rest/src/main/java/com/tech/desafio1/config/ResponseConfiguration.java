package com.tech.desafio1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ResponseConfiguration {

    @Bean("clientRest")
    public RestTemplate registerRestTemplate(){
        return new RestTemplate();
    }
}
