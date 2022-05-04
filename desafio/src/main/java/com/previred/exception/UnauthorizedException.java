package com.previred.exception;

public class UnauthorizedException extends RuntimeException {
	
	private static final long serialVersionUID = 3752644571185729356L;

	public UnauthorizedException(String detail) {
		super(detail);
	}

}
