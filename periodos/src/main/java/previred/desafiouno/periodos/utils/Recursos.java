package previred.desafiouno.periodos.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Recursos {
	
	
	public static Resource getAppPropertiesResource(){
		
		return new ClassPathResource("/application.properties");
		
	}

}
