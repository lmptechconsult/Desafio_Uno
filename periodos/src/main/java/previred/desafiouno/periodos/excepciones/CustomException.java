package previred.desafiouno.periodos.excepciones;

/**
*
* @author DIEGO_CELERY@MIMAIL.COM
*/

public class CustomException extends Exception {

    private static final long serialVersionUID = 6981493561061883257L;
	
    private String code;
    private String message;

    public CustomException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
