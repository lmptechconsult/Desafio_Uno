package com.desafio.periodos.config;


import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.time.LocalDate;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfig{

    private final TypeResolver typeResolver;
    @Autowired
    public SwaggerConfig(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .alternateTypeRules( AlternateTypeRules.newRule(
                        typeResolver.resolve(List.class, LocalDate.class),
                        typeResolver.resolve(List.class, String.class), Ordered.HIGHEST_PRECEDENCE))
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.desafio.periodos"))
                .build()
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Desafio Periodos perdidos - Valeria Constanzo Riveros")
                .description("Desafio 3: Periodos perdidos - Prueba Previred")
                .version("1.0")
                .contact(new Contact("Valeria Constanzo Riveros","","vconstanzor@gmail.com"))
                .build();
    }

/*    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }*/
}
