package com.previred.exception;

public class ForbiddenException extends RuntimeException {
	
	private static final long serialVersionUID = 8698677236391282664L;

	public ForbiddenException(String detail) {
		super(detail);
	}

}
