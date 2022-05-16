package com.previred.desafio.exception;

public class ApiJsonException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;

	public ApiJsonException() {

	}

	public ApiJsonException(String errorMessage) {
		super(errorMessage);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
