package com.project.desafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.desafio.entity.ApiEntity;

public interface ApiRepositories extends JpaRepository<ApiEntity, Integer>{
	public List<ApiEntity> findByLogic(Integer logic);
}
