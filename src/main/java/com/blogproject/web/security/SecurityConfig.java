package com.blogproject.web.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity

public class SecurityConfig {
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	public SecurityConfig(CustomUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
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

	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}
}
