package cl.desafioUno.gdd.tools;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Francisco Devaud
 * @date 02/04/2022
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		TypeResolver typeResolver = new TypeResolver();
		return new Docket(DocumentationType.SWAGGER_2)
				.alternateTypeRules(AlternateTypeRules.newRule(typeResolver.resolve(List.class, LocalDate.class),
						typeResolver.resolve(List.class, String.class), Ordered.HIGHEST_PRECEDENCE))
				.select().apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.paths(PathSelectors.any()).build().apiInfo(apiDetails());

	}

	private ApiInfo apiDetails() {
		return new ApiInfoBuilder().title("Desafio UNO PreviRed ").description("Desafío técnico Mantenedor n°1")
				.version("v1.0").contact(new springfox.documentation.service.Contact("Francisco Devaud", "",
						"francisco.devaud@gmail.com"))
				.build();

	}
}
