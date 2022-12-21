package com.commons.app.exception;

import java.time.LocalDateTime;

import javax.security.auth.login.LoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> dataValidataionException(MethodArgumentNotValidException e,WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), "Validation Error", HttpStatus.BAD_REQUEST, e.getBindingResult().getFieldError().getDefaultMessage()) ;
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> studentExceptionHandler(StudentException se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimeStamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setHttpStatus(HttpStatus.NOT_FOUND);
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseException.class)
	public ResponseEntity<MyErrorDetails> courseExceptionHandler(CourseException ce, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimeStamp(LocalDateTime.now());
			err.setMessage(ce.getMessage());
			err.setHttpStatus(HttpStatus.NOT_FOUND);
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException ce, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimeStamp(LocalDateTime.now());
			err.setMessage(ce.getMessage());
			err.setHttpStatus(HttpStatus.NOT_FOUND);
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception se, WebRequest req){
		
		
		MyErrorDetails err= new MyErrorDetails();
			err.setTimeStamp(LocalDateTime.now());
			err.setMessage(se.getMessage());
			err.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			err.setDetails(req.getDescription(false));
				
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
