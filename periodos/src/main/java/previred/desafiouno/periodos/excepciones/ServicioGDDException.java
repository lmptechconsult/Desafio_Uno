package previred.desafiouno.periodos.excepciones;

/**
*
* @author DIEGO_CELERY@MIMAIL.COM
*/

public class ServicioGDDException extends CustomException {

    public ServicioGDDException() {
        super("servicio-gdd-exception", "Error al invocar el servicio GDD");
    }
    
    public ServicioGDDException(String msg) {
        super("servicio-gdd-exception", msg);
    }
}
