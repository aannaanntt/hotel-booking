package com.hotel.booking.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<EmptyInputResponse> handleException(Exception exc){
		EmptyInputResponse error = new EmptyInputResponse();
		
		error.setMessage("Input Not Found");
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmptyInputResponse>(error,HttpStatus.BAD_REQUEST);
		
	}
	

}
