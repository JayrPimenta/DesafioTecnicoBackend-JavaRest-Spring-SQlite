package com.project.desafio.response;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@JsonInclude(Include.NON_NULL)
public class ApiSucessoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private Integer status;
	private String mensagem;
	
	
	
}
