package com.test.testzup.Controller.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.test.testzup.Exception.UserDuplicateCpfException;
import com.test.testzup.Exception.UserDuplicateEmailException;

@RestControllerAdvice
public class UserErrorHadler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> validationErrorHandler(MethodArgumentNotValidException error) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getFieldError().getDefaultMessage());
	}
	
	@ExceptionHandler(UserDuplicateEmailException.class)
	public ResponseEntity<String> userDuplicateEmail(UserDuplicateEmailException error) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
	}
	
	@ExceptionHandler(UserDuplicateCpfException.class)
	public ResponseEntity<String> userDuplicateCpf(UserDuplicateCpfException error) {
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
	}
}
