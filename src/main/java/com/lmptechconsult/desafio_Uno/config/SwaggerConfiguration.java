package com.lmptechconsult.desafio_Uno.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
// @EnableSwagger2
// @Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .directModelSubstitute(LocalDate.class, String.class)
                .alternateTypeRules(
                        AlternateTypeRules.newRule(typeResolver.resolve(List.class, LocalDate.class),
                                typeResolver.resolve(List.class, String.class)))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lmptechconsult.desafio_Uno.controllers"))
                // .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("lmptechconsult - Desafio Uno")
                .description("")
                .version("1.0")
                .build();
    }
}
