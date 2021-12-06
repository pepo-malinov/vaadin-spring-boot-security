package com.example.application.data.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.data.entity.NotificationEntity;

public interface NotificationEntityRepo extends JpaRepository<NotificationEntity, Integer> {

}
