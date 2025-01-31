package com.gtl.fm.api.dto.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DriverResponse")
public class DriverResponse {

	private String message;
	private int code;
	
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
