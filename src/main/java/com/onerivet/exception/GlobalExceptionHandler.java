package com.onerivet.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.onerivet.models.responce.GenericResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<GenericResponse<?>> resourceNotFoundExceptionHandler(ResourceNotFoundException exception) {

		GenericResponse<?> genericResponse = new GenericResponse<>(null, exception.getMessage());

		return new ResponseEntity<>(genericResponse, HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GenericResponse<?>> exceptionHandler(Exception exception) {
		
		GenericResponse<?> genericResponse = new GenericResponse<>(null, exception.getMessage());
		
		return new ResponseEntity<>(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
