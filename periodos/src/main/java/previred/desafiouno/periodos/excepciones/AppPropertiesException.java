package previred.desafiouno.periodos.excepciones;

/**
*
* @author DIEGO_CELERY@MIMAIL.COM
*/

public class AppPropertiesException extends CustomException {

    public AppPropertiesException() {
        super("app-properties-exception", "Error al intentar acceder al archivo de propiedades de la aplicacion.");
    }
    
    public AppPropertiesException(String msg) {
        super("app-properties-exception", msg);
    }
}
