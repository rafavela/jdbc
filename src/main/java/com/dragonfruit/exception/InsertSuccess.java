package com.dragonfruit.exception;

public class InsertSuccess extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InsertSuccess() {
		super("Inserted successfully");
	}
}
