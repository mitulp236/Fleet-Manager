package com.gtl.fm.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {


	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> restExceptionHandler(RestException e) {
		ErrorResponseDto errorResp = new ErrorResponseDto();
		errorResp.setCode(e.getErroCode());
		errorResp.setMessage(e.getErrorMessage());
		return new ResponseEntity<ErrorResponseDto>(errorResp, e.getHttpStatus());
	}	
	
	
}
