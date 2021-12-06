package com.example.application.data.generator;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.application.data.Role;
import com.example.application.data.entity.RoleEntity;
import com.example.application.data.entity.UserEntity;
import com.example.application.data.service.RoleRepo;
import com.example.application.data.service.UserRepo;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class DataGenerator {

	@Bean
	public CommandLineRunner loadData(PasswordEncoder passwordEncoder, UserRepo userRepository, RoleRepo roleRepo) {
		return args -> {
			Logger logger = LoggerFactory.getLogger(getClass());
			if (userRepository.count() != 0L) {
				logger.info("Using existing database");
				return;
			}
			int seed = 123;

			logger.info("Generating demo data");

			logger.info("... generating 2 User entities...");
			UserEntity user = new UserEntity();
			user.setUsername("user");
			user.setPassword(passwordEncoder.encode("user"));
			user.setEmail("user@user.com");
			user.setAvatarLocation(
					"https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
			RoleEntity userRole = new RoleEntity();
			userRole.setCode(Role.USER.getRoleName());
			userRole = roleRepo.save(userRole);
			user.setRoles(Collections.singleton(userRole));
			userRepository.save(user);
			
			UserEntity admin = new UserEntity();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("admin"));
			admin.setEmail("admin@admin.com");
			admin.setAvatarLocation(
					"https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
			RoleEntity adminRole = new RoleEntity();
			adminRole.setCode(Role.ADMIN.getRoleName());
			adminRole = roleRepo.save(adminRole);
			admin.setRoles(Stream.of(
					//userRole,
					adminRole).collect(Collectors.toSet()));
			userRepository.save(admin);
			/*
			 * User admin = new User(); admin.setName("Emma Powerful");
			 * admin.setUsername("admin");
			 * admin.setHashedPassword(passwordEncoder.encode("admin"));
			 * admin.setProfilePictureUrl(
			 * "https://images.unsplash.com/photo-1607746882042-944635dfe10e?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80"
			 * ); admin.setRoles(Stream.of(Role.USER,
			 * Role.ADMIN).collect(Collectors.toSet())); userRepository.save(admin);
			 */

			logger.info("Generated demo data");
		};
	}

}