package com.project.desafio.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiErrorDesign> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request ){
		String erro = "Falha no recurso";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ApiErrorDesign errorDesign = new ApiErrorDesign(Instant.now(), status.value(), erro, exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(errorDesign);
	}
}
