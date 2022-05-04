package com.camilonavarrete.previred.fechasperdidas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:config.properties")
public class FechasperdidasApplication {

	public static void main(String[] args) {
		SpringApplication.run(FechasperdidasApplication.class, args);
	}

	@Value("${servicio}")
	private String servicio;
}
