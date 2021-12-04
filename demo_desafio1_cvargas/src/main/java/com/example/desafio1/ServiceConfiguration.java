package com.example.desafio1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class ServiceConfiguration {

	@Autowired
	private Environment env;
	
	@Bean("REST_CLIENT_API_PERIOD")
	public WebClient apiPeriodService()
	{
		   return WebClient.builder()
	                .baseUrl(env.getProperty("api.period.url"))
	                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
	                .build();
	}
	
}
