package com.blogproject.web.dto;
import javax.validation.constraints.NotEmpty;


public class RegistrationDto {
	private Long id;
	@NotEmpty
	private String username;
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	
	

}
