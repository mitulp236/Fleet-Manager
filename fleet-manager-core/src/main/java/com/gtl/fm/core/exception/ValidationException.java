package com.gtl.fm.core.exception;

public class ValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 560484435062727512L;

	private String message;
	private  int code;
	
	public ValidationException() {
		
	}
	
	public ValidationException(String message) {
		super(message);
		this.message = message;
	}
	
	public ValidationException(String message, int code) {
		super(message);
		this.message = message;
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
}
