package com.example.application.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

import com.example.application.data.entity.CommentEntity;

@Service
public class CommentService extends CrudService<CommentEntity, Integer> {

	private CommentEntityRepo repository;

	public CommentService(@Autowired CommentEntityRepo repository) {
		this.repository = repository;
	}

	@Override
	protected CommentEntityRepo getRepository() {
		return repository;
	}

}
