package com.project.desafio.exception;

public class ResourceValidationException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceValidationException(String message) {
		super(message);
	}
}
