package kr.ac.hansung.cse.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.ac.hansung.cse.exception.ErrorResponse;
import kr.ac.hansung.cse.exception.UserDuplicatedException;
import kr.ac.hansung.cse.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(HttpServletRequest req, UserNotFoundException ex) {
		
		String requestURL = req.getRequestURL().toString();
		
		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setRequestURL(requestURL);
		errorResponse.setErrorCode("user.notfound.exception");
		errorResponse.setErrorMsg("User with id " + ex.getUserId() + " not found");
	
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserDuplicatedException.class)
	public ResponseEntity<ErrorResponse> handleUserDuplicatedException(HttpServletRequest req, UserDuplicatedException ex) {
		
		String requestURL = req.getRequestURL().toString();
		
		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setRequestURL(requestURL);
		errorResponse.setErrorCode("user.duplicated.exception");
		errorResponse.setErrorMsg("Unable to create. A User with name " + ex.getUserName() + " already exist");
	
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.CONFLICT);
	}
	
}
