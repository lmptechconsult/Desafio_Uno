package com.previred.exception;

import java.util.List;

public class InvalidDataException extends RuntimeException {
	
	private static final long serialVersionUID = -1749451073515643028L;
	private List<String> errors;
	
	public InvalidDataException(String detail) {
		super(detail);
	}

	public InvalidDataException(String detail, List<String> errors) {
		super(detail);
		this.errors= errors;
	}
	
	public List<String> getErrors() {
		return errors;
	}
}
