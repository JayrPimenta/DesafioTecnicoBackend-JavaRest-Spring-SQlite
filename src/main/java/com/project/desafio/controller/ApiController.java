package com.project.desafio.controller;

import java.time.Instant;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.desafio.entity.ApiEntity;
import com.project.desafio.exception.ResourceNotFoundException;
import com.project.desafio.response.ApiSucessoResponse;
import com.project.desafio.service.ApiService;



@RestController
@RequestMapping("/v1.0")
@Validated
public class ApiController {

	@Autowired
	private ApiService service;
	
	@GetMapping("/entidade")
	public ResponseEntity<List<ApiEntity>> findAll(){	
		List<ApiEntity> listaDeEntidades = service.findAll(); // Carrega todos os dados do BD sem critério
		return ResponseEntity.ok().body(listaDeEntidades);
	}
	
	@GetMapping("/entidade/{logic}")
	public ResponseEntity<ApiEntity> findByLogic(@PathVariable Integer logic){
		ApiEntity dados = service.findById(logic); // O ApiService faz a busca dos dados no BD pelo identificador logic 
		if (dados != null) {
			return ResponseEntity.ok().body(dados);
		} else {
			throw new ResourceNotFoundException(String.valueOf(logic) + " não corresponde a um dado existente no banco.");
		}
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/entidade", consumes = MediaType.TEXT_HTML_VALUE) // Consumes aceita somente receber text via html;
	public ResponseEntity<ApiSucessoResponse> insert(@Valid @RequestBody String textBody) {
		service.insert(textBody);
		return ResponseEntity.status(HttpStatus.CREATED).body(ApiSucessoResponse.builder()
				.status(HttpStatus.CREATED.value())
				.timestamp(Instant.now())
				.mensagem("Cadastrado com sucesso")
				.build());
	}
	
	@PutMapping("/entidade/{logic}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ApiSucessoResponse> update(@Valid @PathVariable Integer logic, @RequestBody ApiEntity objectJson) {
		service.update(logic, objectJson); // Envia para o service realizar o update no entity e gravar no BD
		return ResponseEntity.status(HttpStatus.CREATED).body(ApiSucessoResponse.builder()
				.status(HttpStatus.CREATED.value())
				.timestamp(Instant.now())
				.mensagem("Atualizado com sucesso")
				.build());
	}
}
