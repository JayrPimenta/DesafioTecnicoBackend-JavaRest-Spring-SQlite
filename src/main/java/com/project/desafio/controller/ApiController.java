package com.project.desafio.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.project.desafio.service.ApiService;
import com.project.desafio.service.TextBodyConverter;



@RestController
@RequestMapping("/api-desafio1.0")
public class ApiController {

	@Autowired
	private ApiService service;
	
	@Autowired
	private TextBodyConverter textBodyConverter;
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ApiEntity>> findAll(){	
		List<ApiEntity> listaDeEntidades = service.findAll(); // Carrega todos os dados do BD sem critério
		return ResponseEntity.ok().body(listaDeEntidades);
	}
	
	@GetMapping("findByLogic/{logic}")
	public ResponseEntity<ApiEntity> findByLogic(@PathVariable Integer logic){
		ApiEntity dados = service.findById(logic); // O ApiService faz a busca dos dados no BD pelo identificador logic 
		if (dados != null) {
			return ResponseEntity.ok().body(dados);
		} else {
			throw new ResourceNotFoundException(String.valueOf(logic) + " não corresponde a um dado existente no banco. Para pesquisar todos utilize o metodo GET com /api-desafio1.0/findAll");
		}
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/insert", consumes = MediaType.TEXT_HTML_VALUE) // Consumes aceita somente receber text via html;
	public String insert(@RequestBody String textBody) {
		ApiEntity entidadeTextBody = textBodyConverter.converter(textBody); // Converte a String recebida no body no endpoint
		if (service.findById(entidadeTextBody.getLogic()) != null) {
			throw new ResourceNotFoundException("Dados já existentes no banco. Caso deseje alterá-los,  favor utilizar o método PUT com URL update/”campo logic”");
		} else {
			service.insert(entidadeTextBody); // Envia para o service inserir no BD
			return "Cadastrado com sucesso";
		}
	}
	
	@PutMapping("/update/{logic}")
	@ResponseStatus(HttpStatus.CREATED)
	public String update(@PathVariable Integer logic, @RequestBody ApiEntity objectJson) {
		ApiEntity entity = service.findById(logic); // Busca uma entidade pelo campo Logic
		if (entity != null) {		
			service.update(entity, objectJson); // Envia para o service realizar o update no entity e gravar no BD
			return "Dados atualizados com sucesso";
		} else {
			throw new ResourceNotFoundException(String.valueOf(logic) + " não corresponde a um dado existente no banco. Para pesquisar todos utilize o metodo GET com /api-desafio1.0/findAll");
		}
	}
}
