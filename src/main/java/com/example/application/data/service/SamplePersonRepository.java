package com.example.application.data.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.data.entity.SamplePerson;

public interface SamplePersonRepository extends JpaRepository<SamplePerson, Integer> {

}