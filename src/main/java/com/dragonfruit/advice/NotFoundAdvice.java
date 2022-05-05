package com.dragonfruit.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dragonfruit.exception.InsertSuccess;
import com.dragonfruit.exception.NotFoundException;

@ControllerAdvice
public class NotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String personNotFoundHandler(NotFoundException ex) {
		return ex.getMessage();
	}

	@ResponseBody
	@ExceptionHandler(InsertSuccess.class)
	@ResponseStatus(HttpStatus.ACCEPTED)
	String successHandler(InsertSuccess ex) {
		return ex.getMessage();
	}	
	
}
