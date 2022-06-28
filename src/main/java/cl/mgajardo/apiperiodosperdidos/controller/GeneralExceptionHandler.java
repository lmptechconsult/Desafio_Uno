package cl.mgajardo.apiperiodosperdidos.controller;

public class GeneralExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public GeneralExceptionHandler(String message) {
		super();
		this.message = message;
	}

}
