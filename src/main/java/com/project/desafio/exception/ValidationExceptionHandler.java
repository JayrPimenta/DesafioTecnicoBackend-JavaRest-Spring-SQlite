package com.project.desafio.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler {

	@ExceptionHandler(ResourceValidationException.class)
	public ResponseEntity<ApiErrorDesign> validationException(ResourceValidationException exception, HttpServletRequest request){
		String erro = "Falha na validação";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ApiErrorDesign errorDesign = new ApiErrorDesign(Instant.now(), status.value(), erro, exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(errorDesign);
		
	}
}
