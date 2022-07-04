package com.desafio.config;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class DesafioConfig {
	
	
	private TypeResolver typeResolver = new TypeResolver();
	
	
	ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Desafio API Periodos")
            .description("Resultado desafío de implementación ")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .contact(new Contact("","", "willianp685@gmail.com"))
            .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
        		.alternateTypeRules( AlternateTypeRules.newRule(
        				typeResolver.resolve(List.class, LocalDate.class),
        			    typeResolver.resolve(List.class, Date.class)))       		
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com.desafio"))
                    .build()
                .apiInfo(apiInfo());
    }

}
