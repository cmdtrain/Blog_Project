package com.blogproject.web.dto;
import javax.validation.constraints.NotEmpty;

import lombok.Data;


@Data

public class RegistrationDto {
	private Long id;
	@NotEmpty
	private String username;
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	
	
	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
