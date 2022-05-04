package com.previred.exception;

import java.time.ZonedDateTime;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(javassist.NotFoundException.class)
	@ResponseBody
	public ErrorResponse notFoundRequest(HttpServletRequest request, Exception exception) {
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;		
		return new ErrorResponse(httpStatus.value(),httpStatus.name(),exception.getMessage(),ZonedDateTime.now().toLocalDateTime(),request.getRequestURI());		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({	
		BadRequestException.class,
		HttpRequestMethodNotSupportedException.class,
		MethodArgumentNotValidException.class,
		MissingRequestHeaderException.class,
		MissingServletRequestParameterException.class,
		MethodArgumentTypeMismatchException.class,
		HttpMessageNotReadableException.class		
	})
	@ResponseBody
	public ErrorResponse badRequestRequest(HttpServletRequest request, Exception exception) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;				
		return new ErrorResponse(httpStatus.value(),httpStatus.name(),exception.getMessage(),ZonedDateTime.now().toLocalDateTime(),request.getRequestURI());		
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidDataException.class)
	@ResponseBody
	public ErrorResponse badRequestRequest(HttpServletRequest request, InvalidDataException exception) {
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;					
		return new ErrorResponse(httpStatus.value(),httpStatus.name(),exception.getMessage(),ZonedDateTime.now().toLocalDateTime(),request.getRequestURI());		
	}
	
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(ForbiddenException.class)
	@ResponseBody
	public ErrorResponse forbiddenRequest(HttpServletRequest request, Exception exception) {
		HttpStatus httpStatus = HttpStatus.FORBIDDEN;		
		return new ErrorResponse(httpStatus.value(),httpStatus.name(),exception.getMessage(),ZonedDateTime.now().toLocalDateTime(),request.getRequestURI());		
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(ConflictException.class)
	@ResponseBody
	public ErrorResponse conflictRequest(HttpServletRequest request, Exception exception) {
		HttpStatus httpStatus = HttpStatus.CONFLICT;		
		return new ErrorResponse(httpStatus.value(),httpStatus.name(),exception.getMessage(),ZonedDateTime.now().toLocalDateTime(),request.getRequestURI());		
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseBody
	public ErrorResponse unauthorizedRequest(HttpServletRequest request, Exception exception) {
		HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;		
		return new ErrorResponse(httpStatus.value(),httpStatus.name(),exception.getMessage(),ZonedDateTime.now().toLocalDateTime(),request.getRequestURI());		
	}	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorResponse fatalErrorUnexpectedRequest(HttpServletRequest request, Exception exception) {
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;		
		return new ErrorResponse(httpStatus.value(),httpStatus.name(),exception.getMessage(),ZonedDateTime.now().toLocalDateTime(),request.getRequestURI());		
	}
}
