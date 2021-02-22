package com.project.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.desafio.entity.ApiEntity;
import com.project.desafio.service.ApiService;

@RestController
@RequestMapping("/api-desafio1.0")
public class ApiController {

	@Autowired
	private ApiService service;
	
	@GetMapping("/listarTodos")
	public ResponseEntity<List<ApiEntity>> listarTodos(){	
		List<ApiEntity> listaDeEntidades = service.listarTodos();
		return ResponseEntity.ok().body(listaDeEntidades);
	}
}
