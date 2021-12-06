package com.example.application.data.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.data.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{

	UserEntity findByUsername(String name);

}
