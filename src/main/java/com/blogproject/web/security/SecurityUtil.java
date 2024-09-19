package com.blogproject.web.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class SecurityUtil {
	public static String getSessionUser() {
		org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUsername = authentication.getName();
			return currentUsername;
			
		}
		return null;
	}

}
