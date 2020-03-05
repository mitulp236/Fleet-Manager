package com.gtl.fm.api.exception;

import org.springframework.http.HttpStatus;

public class RestException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 210312151346842320L;
	
	private final Integer erroCode;
	private final String  errorMessage;
	private final HttpStatus httpStatus;
	private final Throwable e;
	
	public RestException(Integer errorCode, String message, HttpStatus httpStatus, Throwable e) {
		super(message, e);
		this.erroCode = errorCode;
		this.errorMessage = message;
		this.httpStatus = httpStatus;
		this.e = e;
	}

	public Integer getErroCode() {
		return erroCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public Throwable getE() {
		return e;
	}
	
	
}
