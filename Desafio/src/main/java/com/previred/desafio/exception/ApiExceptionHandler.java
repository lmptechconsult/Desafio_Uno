package com.previred.desafio.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = { ApiRequestException.class })
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
		HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;
		ApiException apiException = new ApiException(e.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));

		return new ResponseEntity<>(apiException, badRequest);
	}

	@ExceptionHandler(value = { ApiJsonException.class })
	public ResponseEntity<Object> handleJsonProcessingException(ApiJsonException e) {
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ApiException apiException = new ApiException(e.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));

		return new ResponseEntity<>(apiException, badRequest);
	}

	@ExceptionHandler(value = { ApiForbiddenException.class })
	public ResponseEntity<Object> handApiForbiddenException(ApiForbiddenException e) {
		HttpStatus badRequest = HttpStatus.FORBIDDEN;
		ApiException apiException = new ApiException(e.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));

		return new ResponseEntity<>(apiException, badRequest);
	}

	@ExceptionHandler(value = { ApiUnauthorizedException.class })
	public ResponseEntity<Object> handApiUnauthorizedException(ApiUnauthorizedException e) {
		HttpStatus badRequest = HttpStatus.UNAUTHORIZED;
		ApiException apiException = new ApiException(e.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));

		return new ResponseEntity<>(apiException, badRequest);
	}
}
