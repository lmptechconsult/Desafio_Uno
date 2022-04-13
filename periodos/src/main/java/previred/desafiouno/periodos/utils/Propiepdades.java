package previred.desafiouno.periodos.utils;

import java.io.IOException;
import java.util.Properties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import previred.desafiouno.periodos.excepciones.AppPropertiesException;


public class Propiepdades {
	
	
	public static Properties getAppProperties() throws AppPropertiesException{
		
		Resource resource = Recursos.getAppPropertiesResource();
		Properties props = null;
		try {
			props = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			throw new AppPropertiesException(
					"Error al intentar leer el archivo de properties de la aplicacion: "
							+ e.getMessage());
		}
		
		return props;
	}

}
