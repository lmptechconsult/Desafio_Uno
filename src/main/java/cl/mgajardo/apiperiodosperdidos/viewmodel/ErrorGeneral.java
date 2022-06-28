package cl.mgajardo.apiperiodosperdidos.viewmodel;

import io.swagger.annotations.ApiModel;

public class ErrorGeneral {

/**
 * Manejo de Errores con mensaje de resultado.
 */
@ApiModel(description = "Error General")

public class ErrorGenerico {
	
}
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
