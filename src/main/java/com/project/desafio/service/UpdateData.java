package com.project.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.desafio.entity.ApiEntity;
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
public class UpdateData {

	@Autowired
	public ApiRepositories repositorie;
	
	public void updateDataEntity(ApiEntity entity, ApiEntity objectJson) {
		entity.setModel(objectJson.getModel());
		entity.setMxf(objectJson.getMxf());
		entity.setMxr(objectJson.getMxr());
		entity.setPlat(objectJson.getPlat());
		entity.setPtid(objectJson.getPtid());
		entity.setSam(objectJson.getSam());
		entity.setSerial(objectJson.getSerial());
		entity.setVerfm(objectJson.getVerfm());
		entity.setVersion(objectJson.getVersion());
		
	}
}
