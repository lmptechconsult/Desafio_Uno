package cl.mgajardo.apiperiodosperdidos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerDocumentationConfig {
	
	 ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	            .title("api-periodos-perdidos")
	            .description("Api para la detección de periodos perdidos")
	            .license("Apache 2.0")
	            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
	            .termsOfServiceUrl("")
	            .version("1.0")
	            .contact(new Contact("","", ""))
	            .build();
	    }
	 
	 @Bean
	    public Docket customImplementation(){
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                    .apis(RequestHandlerSelectors.basePackage("cl.mgajardo.apiperiodosperdidos.controller"))
	                    .build()
	                .directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
	                .directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
	                .apiInfo(apiInfo());
	    }
}
