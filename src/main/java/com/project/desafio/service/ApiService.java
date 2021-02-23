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
	
	@Autowired
	private UpdateData updateEntity;
	
	public List<ApiEntity> findAll(){	
		return repositorie.findAll();
	}
	
	public void insert(ApiEntity textBody) {
		repositorie.save(textBody);
	}
	
	public ApiEntity findById(Integer logic) {
		return repositorie.findById(logic).orElse(null);
	}
	
	public void update(ApiEntity entity, ApiEntity objectJson) {
		updateEntity.updateDataEntity(entity, objectJson);
		repositorie.save(entity);
	}
}
