package com.jsnaranjov.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * @author Jaime Sebastián Naranjo V
 * @version 1.0.0
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jsnaranjov.rest"))
                .paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
    }
    
    
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()

                .title("rest-nivel3 ApiRest")
                .description("ApiRest que consume Servicio api-periodos")
                .version("1.0.0")
                .license("Apache 2.0")
                .contact(new Contact("Jaime Naranjo", "https://www.linkedin.com/in/jsnaranjov/", "jsnaranjov@gmail.com"))
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
    
}
