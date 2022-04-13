package previred.desafiouno.periodos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
*
* @author DIEGO_CELERY@MIMAIL.COM
*/

@SpringBootApplication
public class PeriodosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeriodosApplication.class, args);
		
		/* Otra forma de cmabiar el puerto
		 * SpringApplication app = new SpringApplication(PeriodosApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8081"));
        app.run(args);
        */
	}

}
