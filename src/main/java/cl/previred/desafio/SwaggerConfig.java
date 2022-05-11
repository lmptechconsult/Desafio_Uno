package cl.previred.desafio;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
		private static final String BASE_PACKAGE = "cl.previred.desafio.controllers.api";
		TypeResolver typeResolver = new TypeResolver();
		@Bean
		public Docket apiDocket() {
			return new Docket(DocumentationType.SWAGGER_2)
					.alternateTypeRules(AlternateTypeRules.newRule(typeResolver.resolve(List.class,LocalDate.class),
							typeResolver.resolve(List.class, String.class), Ordered.HIGHEST_PRECEDENCE))
					.select()
					.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
					.paths(PathSelectors.any())
					.build()
					.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
	                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
					.apiInfo(getApiInfo())
					;
		}
		
		private ApiInfo getApiInfo() {
			return new ApiInfo(
					"Missing dates API",
					"Test practico, ingreso a previred - desafio 1 nivel 3",
					"1.0",
					null,
					new Contact("","", "francisco.perez.sd@gmail.com"),
					"Apache 2.0",
					"http://www.apache.org/licenses/LICENSE-2.0.html",
					Collections.emptyList()
					);
		}

}
