package com.blogproject.web.service.impl;

import java.util.Arrays;

@Service

import org.springframework.beans.factory.annotation.Autowired;

import com.blogproject.web.dto.RegistrationDto;
import com.blogproject.web.models.Role;
import com.blogproject.web.models.UserEntity;
import com.blogproject.web.repository.RoleRepository;
import com.blogproject.web.repository.UserRepository;
import com.blogproject.web.service.UserService;

public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		
	}
	@Override
	public void saveUser(RegistrationDto registrationDto) {
		// TODO Auto-generated method stub
		UserEntity user = new UserEntity();
		user.setUsername(registrationDto.getUsername());
		user.setEmail(registrationDto.getEmail());
		user.setPassword(registrationDto.getPassword());
		Role role = roleRepository.findByName("USER");
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
		
	}
	@Override
	public UserEntity findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
		
	}
	@Override
	public UserEntity findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
		
		
	}

}
