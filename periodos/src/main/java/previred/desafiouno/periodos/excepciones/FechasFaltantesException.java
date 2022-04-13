package previred.desafiouno.periodos.excepciones;

/**
*
* @author DIEGO_CELERY@MIMAIL.COM
*/

public class FechasFaltantesException extends CustomException {

    private static final long serialVersionUID = -888123045740919110L;

	public FechasFaltantesException() {
        super("fechas-faltantes-exception", "Error al intentar recuperar las fechas faltantes.");
    }
    
    public FechasFaltantesException(String msg) {
        super("fechas-faltantes-exception", msg);
    }
}
