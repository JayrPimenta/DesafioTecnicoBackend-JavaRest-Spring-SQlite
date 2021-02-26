package com.project.desafio.util;
import java.io.IOException;
import java.io.InputStream;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

import com.project.desafio.entity.ApiEntity;
import com.project.desafio.exception.ResourceValidationException;

@Component
public class ValidateJsonSchema {

	public void validateRequestJson(ApiEntity objectJson) {
		try (InputStream inputStream = getClass().getResourceAsStream("/static/schema.json")) {
			JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
			Schema schema = SchemaLoader.load(rawSchema);
			schema.validate(new JSONObject(objectJson)); 

		} catch (IOException e) {
			throw new ResourceValidationException(e.getMessage());
		}
	}

}
