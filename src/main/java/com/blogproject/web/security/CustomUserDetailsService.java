package com.blogproject.web.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.blogproject.web.models.UserEntity;
import com.blogproject.web.repository.UserRepository;

@Service

public class CustomUserDetailsService implements UserDetailsService{
	private UserRepository userRepository;
	
	@Autowired
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findFirstByUsername(username);
		if(user != null) {
			User authUser = new User(
					user.getEmail(),
					user.getPassword(),
					user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName()))
					.collect(Collectors.toList())
		);
			
			return authUser;
			
		} else {
			throw new UsernameNotFoundException("Invalid username or password");
			
		}
		
	}
	
	
}
