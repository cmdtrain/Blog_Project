package com.blogproject.web.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity

public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(...antPatterns: "/login", "/register", "/blogs", "/css/**", "/js/**")
			.permitAll()
			.and()
			.formLogin(form -> form
					.loginPage("/login")
					.defaultSuccessUrl("/clubs")
					.loginProcessingUrl("/login")
					.failureUrl(authenticationFailureUrl: "/login?error=true")
					.permitAll()
			).logout(
					logout -> logout
						.logoutRequestMatcher(new AntPathRequestMatcher(patter: "/logout")).permitAll()
					);
		return http.build();
			
	}

}
