package com.project.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.project.desafio.entity.ApiEntity;
import com.project.desafio.exception.ResourceNotFoundException;
import com.project.desafio.exception.ResourceValidationException;
import com.project.desafio.repositories.ApiRepositories;
import com.project.desafio.util.ValidateJsonSchema;

@Service
public class ApiService {

	@Autowired
	private ApiRepositories repositorie;
	
	@Autowired
	private TextBodyConverterService textBodyConverterService;
	
	@Autowired
	private ValidateJsonSchema validateJsonSchema;
	
	public List<ApiEntity> findAll(){	
		return repositorie.findAll();
	}
	
	public void insert(String textBody) {
		try {
			ApiEntity entidadeTextBody = textBodyConverterService.fromStringRequestToEntity(textBody); // Converte a String recebida no body no endpoint
			if (findById(entidadeTextBody.getLogic()) != null) {
				throw new ResourceValidationException("Dados já existentes no banco. Caso deseje alterá-los");
			} else {
				validateJsonSchema.validateRequestJson(entidadeTextBody);// Envia o objeto para o service inserir no BD
				repositorie.save(entidadeTextBody);
			}
		}  catch (TransactionSystemException e) {
			throw new ResourceValidationException(e.getMostSpecificCause().getMessage());
		}
	}
	
	public ApiEntity findById(Integer logic) {
		return repositorie.findById(logic).orElse(null);
	}
	
	public void update(Integer logic, ApiEntity objectJson) {
		try {
			ApiEntity entity = findById(logic); // Busca uma entidade pelo campo Logic
			if (entity != null) {
				textBodyConverterService.fromUpdateJsonRequestToEntity(entity, objectJson);
				validateJsonSchema.validateRequestJson(entity);
				repositorie.save(entity);
			} else {
				throw new ResourceNotFoundException(String.valueOf(logic)
						+ " não corresponde a um dado existente no banco.");
			}
		} catch (TransactionSystemException e) {
			throw new ResourceValidationException(e.getMostSpecificCause().getMessage());
		}
		

	}
}
