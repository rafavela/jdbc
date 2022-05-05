package com.dragonfruit.exception;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NotFoundException(String email) {
		super("Person not found "+email);
	}
}
