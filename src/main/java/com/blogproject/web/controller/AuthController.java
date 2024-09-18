package com.blogproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogproject.web.dto.RegistrationDto;
import com.blogproject.web.models.UserEntity;
import com.blogproject.web.service.UserService;

import ch.qos.logback.core.model.Model;

@Controller

public class AuthController {

	private UserService userService;
	
	public AuthController(UserService userService) {
		this.userService = userService;
		
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
		}
	
	@GetMapping("/register")
	public String getRegisterForm(Model model) {
		RegistrationDto user = new RegistrationDto();
		model.addAttribute(attributeName: "user", user);
		return "register";
		
		}
	
	@PostMapping("/tegister/save")
	public String register(@Valid @ModelAttribute("user")RegistrationDto user,
			BindingResult result, Model model) {
		UserEntity existingUserEmail = userService.findByEmail(user.getEmail());
		if(existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
			return "redirect:/register?fail";
			
		}
		UserEntity existingUserUsername = userService.findByUsername(user.getUsername());
		if(existingUserUsername != null && existingUserUsername.getUsername() != null && !existingUserUsername.getUsername().isEmpty()) {
			return "redirect:/register?fail";
			
		}
		if(result.hasErrors()) {
			model.addAttribute(attributeValue: "user", user);
			return "register";
			
		}
		userService.saveUser(user);
		return "redirect:/blogs?success";
		
	}
}
