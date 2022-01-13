package com.desafioprevired.desafioprevired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafiopreviredApplication implements CommandLineRunner {
	private final Logger log = LoggerFactory.getLogger(DesafiopreviredApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DesafiopreviredApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Estado de la Api OK");
	}
}
