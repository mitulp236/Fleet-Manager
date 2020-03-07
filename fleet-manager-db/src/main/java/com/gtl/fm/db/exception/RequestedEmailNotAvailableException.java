package com.gtl.fm.db.exception;

public class RequestedEmailNotAvailableException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6123437627011047766L;

	
	private String message;
	private  int code;
	
	public RequestedEmailNotAvailableException() {
		
	}
	
	public RequestedEmailNotAvailableException(String message) {
		super(message);
		this.message = message;
	}
	
	public RequestedEmailNotAvailableException(String message, int code) {
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
