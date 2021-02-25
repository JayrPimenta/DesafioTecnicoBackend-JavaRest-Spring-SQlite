package com.project.desafio.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.desafio.entity.ApiEntity;
import com.project.desafio.exception.ResourceValidationException;
import com.project.desafio.repositories.ApiRepositories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Slf4j
@Component
public class TextBodyConverterService {

	@Autowired
	public ApiRepositories repositorie;
	
	public ApiEntity fromStringRequestToEntity(String textBody) {
		try {
		String[] apiEntity = textBody.split(";"); // Desmenbra as entidades recebidas no Body em texto
		return new ApiEntity(Integer.valueOf(apiEntity[0]), 
				apiEntity[1],
				apiEntity[2],
				Integer.valueOf(apiEntity[3]), 
				apiEntity[4],  
				Integer.valueOf(apiEntity[5]), 
				apiEntity[6], 
				Integer.valueOf(apiEntity[7]), 
				Integer.valueOf(apiEntity[8]), 
				apiEntity[9]); // Controi o objeto entidade para inserir no banco
		} catch (NumberFormatException e) {
			log.error("\n\n NumberFormatException:", e);
			throw new ResourceValidationException("Recurso vasio, null ou do tipo invalido, operação não permitida. Favor seguir o modelo Content-Type:Text/HTML: "
					+ "logic;serial;model;sam;ptid;plat;version;mxr;mxf;VERFM");
		}
	}
	
	@SneakyThrows
	public void fromUpdateJsonRequestToEntity(ApiEntity entity, ApiEntity objectJson) {	
		log.info("\n\n Entity Before: {} \n", entity);
		BeanUtils.copyProperties(objectJson, entity, "logic");
		log.info("\n\n Entity After: {} \n", entity);
	}
}
