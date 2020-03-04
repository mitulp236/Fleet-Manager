package com.gtl.fm.core.exception;


public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2821292537230967254L;

	private String message;
	private  int code;
	
	public DataNotFoundException() {
		
	}
	
	public DataNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	public DataNotFoundException(String message, int code) {
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
