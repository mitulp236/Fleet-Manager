package com.gtl.fm.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {


	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponseDto> DataNotFoundHandler(RestException e) {
		ErrorResponseDto errorResp = new ErrorResponseDto();
		errorResp.setCode(e.getErroCode());
		errorResp.setMessage(e.getErrorMessage());
		return new ResponseEntity<ErrorResponseDto>(errorResp, e.getHttpStatus());
	}
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorResponseDto> OtherExceptionHandler(RestException e) {
//		ErrorResponseDto errorResp = new ErrorResponseDto();
//		errorResp.setCode(1000);
//		errorResp.setMessage("internal server error");
//		return new ResponseEntity<ErrorResponseDto>(errorResp, HttpStatus.INTERNAL_SERVER_ERROR);
//	}	
	
//	@ExceptionHandler(EmailAlreadyUsedException.class)
//	public ResponseEntity<ErrorResponseDto> EmailAlreadyUsedHandler(RestException e){
//		ErrorResponseDto errorResp = new ErrorResponseDto();
//		errorResp.setCode(e.getErroCode());
//		errorResp.setMessage(e.getErrorMessage());
//		return new ResponseEntity<ErrorResponseDto>(errorResp, e.getHttpStatus());
//	}
//	
//	@ExceptionHandler(ValidationException.class)
//	public ResponseEntity<ErrorResponseDto> ValidationExceptionHandler(RestException e){
//		ErrorResponseDto errorResp = new ErrorResponseDto();
//		errorResp.setCode(e.getErroCode());
//		errorResp.setMessage(e.getErrorMessage());
//		return new ResponseEntity<ErrorResponseDto>(errorResp, e.getHttpStatus());
//	}
}
