package com.gtl.fm.core.exception;

public class UnAuthorisedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4301163251974374021L;

	
	private String message;
	private  int code;
	
	public UnAuthorisedException() {
		
	}
	
	public UnAuthorisedException(String message) {
		super(message);
		this.message = message;
	}
	
	public UnAuthorisedException(String message, int code) {
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
