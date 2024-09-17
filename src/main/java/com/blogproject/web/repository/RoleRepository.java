package com.blogproject.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogproject.web.models.Role;
import com.blogproject.web.models.UserEntity;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
	
}
