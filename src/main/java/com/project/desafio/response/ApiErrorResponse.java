package com.project.desafio.response;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ApiErrorResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private Integer status;
	private String erro;
	private String mensagem;
	private String path;
	
}
