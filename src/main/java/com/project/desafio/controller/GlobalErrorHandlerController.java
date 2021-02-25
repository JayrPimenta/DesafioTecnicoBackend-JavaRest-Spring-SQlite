package com.project.desafio.controller;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.desafio.exception.ResourceNotFoundException;
import com.project.desafio.exception.ResourceValidationException;
import com.project.desafio.response.ApiErrorResponse;

@ControllerAdvice
public class GlobalErrorHandlerController {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request ){
		String erro = "Falha no recurso";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ApiErrorResponse errorDesign = new ApiErrorResponse(Instant.now(), status.value(), erro, exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(errorDesign);
	}
	
	@ExceptionHandler(ResourceValidationException.class)
	public ResponseEntity<ApiErrorResponse> validationException(ResourceValidationException exception, HttpServletRequest request){
		String erro = "Falha na validação";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ApiErrorResponse errorDesign = new ApiErrorResponse(Instant.now(), status.value(), erro, exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(errorDesign);
	}
}
