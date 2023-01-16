package com.desafio.nivelTres;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NivelTresApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(NivelTresApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(NivelTresApplication.class, args);
		LOG.info("Servicio desafio uno iniciado");
	}

}
