package com.gtl.fm.core.exception;

public class EmailAlreadyUsedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8137130266349736604L;

	private String message;
	private  int code;
	
	public EmailAlreadyUsedException() {
		
	}
	
	public EmailAlreadyUsedException(String message) {
		super(message);
		this.message = message;
	}
	
	public EmailAlreadyUsedException(String message, int code) {
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
