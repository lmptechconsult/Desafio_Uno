package com.previred.desafio.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger configuration class
 * @author Roberto Crespo
 * @Since 1.0.0
 */

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    /**
     * Publish a bean to generate swagger2 endpoints
     * @return a swagger configuration bean
     */
    @Bean
    public Docket usersApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.previred.desafio"))
                .build()
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                //.directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(usersApiInfo());
    }

    

    /**
     * Api info
     * @return ApiInfo
     */
    private ApiInfo usersApiInfo() {
        return new ApiInfoBuilder()
                .title("Demo Spring Boot - Oscar Cancino Encina")
                .version("1.0")
                .description("Servicio desarrollado como desafio para el ingreso a Previred.")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .contact(new Contact("","", "cancino1984@gmail.com"))
                .build();
    }

}
