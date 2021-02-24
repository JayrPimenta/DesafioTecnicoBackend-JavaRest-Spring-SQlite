package com.project.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.desafio.entity.ApiEntity;
import com.project.desafio.exception.ResourceValidationException;
import com.project.desafio.repositories.ApiRepositories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class TextBodyConverter {

	@Autowired
	public ApiRepositories repositorie;
	
	public ApiEntity converter(String textBody) {
		try {
		String[] entidadeAtributo = textBody.split(";");
		return new ApiEntity(Integer.valueOf(entidadeAtributo[0]), 
				entidadeAtributo[1],
				entidadeAtributo[2],
				Integer.valueOf(entidadeAtributo[3]), 
				entidadeAtributo[4],  
				Integer.valueOf(entidadeAtributo[5]), 
				entidadeAtributo[6], 
				Integer.valueOf(entidadeAtributo[7]), 
				Integer.valueOf(entidadeAtributo[8]), 
				entidadeAtributo[9]);
		} catch (NumberFormatException e) {
			throw new ResourceValidationException("Recurso vasio, null ou do tipo invalido, operação não permitida. Favor seguir o modelo Content-Type:Text/HTML:"
					+ " 'Integer'logic(required);'String'serial(required);'String'model(required);'Integer'sam(minimum:0);'String'ptid;'Integer'plat;'String'version(required);'Integer'mxr;'String'mxf;'String'VERFM");
		}
	}
}
