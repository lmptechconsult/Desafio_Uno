package com.previred.exception;

import java.util.List;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -770721486216830131L;	
	private List<String> errors;
	
	public BadRequestException(String detail) {
		super(detail);
	}

	public BadRequestException(String detail, List<String> errors) {
		super(detail);
		this.errors= errors;
	}
	
	public List<String> getErrors() {
		return errors;
	}
}
