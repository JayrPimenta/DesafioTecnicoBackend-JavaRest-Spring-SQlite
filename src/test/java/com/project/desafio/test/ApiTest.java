package com.project.desafio.test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.desafio.entity.ApiEntity;
import com.project.desafio.exception.ResourceValidationException;
import com.project.desafio.service.ApiService;
import com.project.desafio.service.TextBodyConverterService;

@SpringBootTest
public class ApiTest {
	
	@Autowired
	private ApiService service;
	
	@Autowired
	private TextBodyConverterService textBodyConverter;
	
	private ApiEntity entity;
	
	@Test
	public void expectedFindAll() {
		List<ApiEntity> listEntity = service.findAll();
		entity = listEntity.stream().findFirst().orElse(null);
		assertNotNull(entity);
	}
	
	@Test
	public void expectedFindById() {
		entity = service.findById(44332211);
		assertNotNull(entity);
	}
	
	@Test
	public void expectedFromStringRequestToEntity() {
		entity = textBodyConverter.fromStringRequestToEntity("1;a;b;2;c;3;d;4;5;e");
		assertEquals(Integer.valueOf(2), entity.getSam());
		assertNotNull(entity);
	}
	
	@Test
	public void expectedFromStringRequestToEntityException() {
		assertThrows(ResourceValidationException.class, () -> { textBodyConverter.fromStringRequestToEntity(";a;b;2;c;3;d;4;5;e");});
	}
	
	@Test
	public void expectedFromUpdateJsonRequestToEntity() {
		ApiEntity entityTest = new ApiEntity(0,"0","0",0,"0",0,"0",0,0,"0");
		textBodyConverter.fromUpdateJsonRequestToEntity(entityTest, new ApiEntity(1,"a","b",2,"c",3,"d",4,5,"e"));
		assertEquals("a", entityTest.getSerial());
	}
	

}
