package com.project.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.desafio.entity.ApiEntity;

public interface ApiRepositories extends JpaRepository<ApiEntity, Integer>{
}
