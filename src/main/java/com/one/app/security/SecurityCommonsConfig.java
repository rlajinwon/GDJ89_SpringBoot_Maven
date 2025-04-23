package com.one.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityCommonsConfig {

	@Bean
	PasswordEncoder geEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
