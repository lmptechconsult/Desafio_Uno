package cl.rsalinas.main;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


public class ChallengeOneServletInitializer extends SpringBootServletInitializer {


    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ChallengeOneApplication.class);
    }
}
