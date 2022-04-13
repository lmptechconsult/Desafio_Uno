package previred.desafiouno.periodos.excepciones;

import java.io.Serializable;

/**
*
* @author DIEGO_CELERY@MIMAIL.COM
*/

public class CustomStatusException implements Serializable {

    private static final long serialVersionUID = 2551420106895594780L;

	private static final String OK = "OK";

    private String code;
    private String msg;

    public CustomStatusException() {
        this.msg = OK;
        this.code = OK;
    }

    public CustomStatusException(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public CustomStatusException (Exception e){
        if(e instanceof CustomException){
            this.code = ((CustomException) e).getCode();
            this.msg = ((CustomException) e).getMessage();
        } else {
            this.code = "9999";
            this.msg = "Ocurrió un error inesperado en la aplicación";
        }
                
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Status{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

}
