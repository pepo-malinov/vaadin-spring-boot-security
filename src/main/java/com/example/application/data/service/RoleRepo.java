package com.example.application.data.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.data.entity.RoleEntity;

public interface RoleRepo extends JpaRepository<RoleEntity, Integer>{

	List<RoleEntity> findByCodeNotIn(List<String> notIn);
}
