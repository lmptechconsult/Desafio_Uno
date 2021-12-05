package com.devru.desafiouno;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafiounoApplication  {
	
	private static final Logger logger = LogManager.getLogger(DesafiounoApplication.class);
    
	@Value("${external.application.periodo.server}")
    private static String periodo_server;
	
	@Value("${external.application.periodo.puerto}")
    private static String periodo_puerto;
    
	public static void main(String[] args) {
		logger.info("Validando Args ");
		if(args != null) {
			int numArgs = 0;
			for (String arg : args) {
				if (arg != null && arg.indexOf("server.port") >= 0) {
					numArgs +=1;
				} else if (arg != null && arg.indexOf("external.application.periodo.server") >= 0) {
					numArgs +=1;
				} else if (arg != null && arg.indexOf("external.application.periodo.puerto") >= 0 ) {
					numArgs +=1;
				}
			}
			if (numArgs < 3) {
				logger.error("Args error: Se requieren los parametros [--server.port=XXX], [--external.application.periodo.server=XXX] y [--external.application.periodo.puerto=XXX]");
			}else {
				logger.info("Args OK");
				logger.info("App init run");
				SpringApplication.run(DesafiounoApplication.class, args);
			}		
		}else {
			logger.error("Faltan Argumentos para poder inicializar correctamente la aplicacion");
		}		
		
	}

}
