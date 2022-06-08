package com.desafiotc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.controller.FechasController;

@SpringBootApplication
@ComponentScan(basePackageClasses = FechasController.class)
public class DesafiotcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiotcApplication.class, args);
	}

}
