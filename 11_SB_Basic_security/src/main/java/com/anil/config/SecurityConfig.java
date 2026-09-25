package com.anil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		
		http.csrf(csrf-> csrf.disable())
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/auth/login").permitAll()
				.requestMatchers("/api/auth/singup").permitAll()
				.requestMatchers("/api/auth/**").permitAll()
				
				.requestMatchers("/api/products").authenticated()
				
				.anyRequest().authenticated()
				)
		.httpBasic(htppBasic->{});
		
		return http.build();
		
		
		
		
		
	}

}
