package com.blogproject.web.repository;

import com.blogproject.web.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);
	UserEntity findByUsername(String userName);
	
	UserEntity findFirstByUsername(String username);
	
}
