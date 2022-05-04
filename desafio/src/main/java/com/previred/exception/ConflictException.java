package com.previred.exception;

public class ConflictException extends RuntimeException {
	
	private static final long serialVersionUID = -1660022703606823249L;
	
	public ConflictException(String detail) {
		super(detail);
	}

}
