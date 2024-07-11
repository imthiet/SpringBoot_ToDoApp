package com.thietAppp.springboot.todoApp.security;


import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecuriotyConfiguration {
//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(Userdetails... users)
	
	@Bean
	public InMemoryUserDetailsManager creaDetailsManager()
	{
		Function<String, String> PasswordEncoder
				=input->passwordEncoder().encode(input);
		
		UserDetails userdetails = User
		.builder()
		.passwordEncoder(PasswordEncoder)
		.username("thietquang")
		.password("123")
		.roles("USER","ADMIN")
		.build();
		
		return new InMemoryUserDetailsManager(userdetails);
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
		
	}
}
