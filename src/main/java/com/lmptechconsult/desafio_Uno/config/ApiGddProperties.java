package com.lmptechconsult.desafio_Uno.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@ConfigurationPropertiesScan
@Configuration
@ConfigurationProperties(prefix = "api-gdd")
@PropertySource(value = "classpath:api_gdd.properties")
@Data
public class ApiGddProperties {
    private String host;
    private String pathPeriodosApi;
}
