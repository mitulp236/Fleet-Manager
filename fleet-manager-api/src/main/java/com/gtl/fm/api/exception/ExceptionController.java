package com.gtl.fm.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gtl.fm.core.exception.DataNotFoundException;
import com.gtl.fm.core.exception.EmailAlreadyUsedException;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {


	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> DataNotFoundHandler(RestException e) {
		ErrorResponseDto errorResp = new ErrorResponseDto();
		errorResp.setCode(e.getErroCode());
		errorResp.setMessage(e.getErrorMessage());
		return new ResponseEntity<ErrorResponseDto>(errorResp, e.getHttpStatus());
	}	
	
	@ExceptionHandler(EmailAlreadyUsedException.class)
	public ResponseEntity<ErrorResponseDto> EmailAlreadyUsedHandler(RestException e){
		ErrorResponseDto errorResp = new ErrorResponseDto();
		errorResp.setCode(e.getErroCode());
		errorResp.setMessage(e.getErrorMessage());
		return new ResponseEntity<ErrorResponseDto>(errorResp, e.getHttpStatus());
	}
	
}
