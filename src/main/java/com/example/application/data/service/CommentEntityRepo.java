package com.example.application.data.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.data.entity.CommentEntity;

public interface CommentEntityRepo extends JpaRepository<CommentEntity, Integer> {

}
