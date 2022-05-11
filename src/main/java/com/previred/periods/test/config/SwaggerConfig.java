package com.previred.periods.test.config;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.classmate.TypeResolver;
import com.previred.periods.test.dto.PeriodDTO;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// TODO: Auto-generated Javadoc
/**
 * The Class SwaggerConfig.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	/** The type resolver. */
	@Autowired
	private TypeResolver typeResolver;
	
	/**
	 * Api docket.
	 *
	 * @return the docket
	 */
	@Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
	                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
	                .paths(PathSelectors.any())
	            .build()
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
	            .additionalModels(typeResolver.resolve(PeriodDTO.class))
	            .alternateTypeRules(
	            		AlternateTypeRules.newRule(typeResolver.resolve(List.class, LocalDate.class), typeResolver.resolve(List.class, java.sql.Date.class))
	            )
                .apiInfo(getApiInfo())
                .enable(true)
                .useDefaultResponseMessages(false);
    }
    
    /**
     * Gets the api info.
     *
     * @return the api info
     */
    private ApiInfo getApiInfo() {
    	 return new ApiInfoBuilder()
                .title("API Missed periods")
                .description("Implementation challenge solution")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("Test","https://sebastian-huaitro.com", "seba.huaitro98@gmail.com"))
                .build();
    }


}
