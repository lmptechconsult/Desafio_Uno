package com.previred.app.date;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


/**
 * 
 * @author lmancild
 * @version 1.0.0 
 */
@Configuration
public class ApiDocConfiguration {

	 @Bean
	  public GroupedOpenApi publicApi() {
	      return GroupedOpenApi.builder()
	              .group("api")
	              .pathsToMatch("/**")
	              .build();
	  }

	 @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Previred Desafio Uno API")
	              .description("Aplicación REST basa en springboot 2.6.x")
	              .version("v1.0.0")
	              .license(new License().name("Apache 2.0")));
	  }
}
