package com.test.GDD.configuration;



import java.util.Collections;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableSwagger2
public class Swagger{

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/v1/**"))
				.apis(RequestHandlerSelectors.basePackage("com.test.GDD.controller"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
	return new ApiInfo(
					"Api Rest GDD",
					"Periodos perdidos",
					"version 1",
					"-",
					new springfox.documentation.service.Contact("FLG", "-", "-"),
					"-",
					"-",
					Collections.emptyList()
			);
	}

}
