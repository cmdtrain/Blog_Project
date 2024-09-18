package com.blogproject.web.service;

import com.blogproject.web.controller.UserEntity;
import com.blogproject.web.dto.RegistrationDto;

public interface UserService {

	void saveUser(RegistrationDto registrationDto);

	UserEntity findByEmail(String email);

	UserEntity findByUsername(String username);
	
	
}
