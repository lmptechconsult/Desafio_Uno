package cl.mgajardo.apiperiodosperdidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "cl.mgajardo.apiperiodosperdidos", "cl.mgajardo.apiperiodosperdidos.controller" , "cl.mgajardo.apiperiodosperdidos.configuration"})
public class ApiPeriodosPerdidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPeriodosPerdidosApplication.class, args);
	}

}
