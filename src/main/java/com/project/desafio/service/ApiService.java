package com.project.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.desafio.entity.ApiEntity;
import com.project.desafio.repositories.ApiRepositories;

@Service
public class ApiService {

	@Autowired
	public ApiRepositories repositorie;
	
	public List<ApiEntity> listarTodos(){	
		return repositorie.findAll();
	}
}
