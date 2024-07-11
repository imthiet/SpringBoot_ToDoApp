package com.thietAppp.springboot.todoApp.security;

import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecuriotyConfiguration {
//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(Userdetails... users)
	
	@Bean
	public InMemoryUserDetailsManager creaDetailsManager()
	{
		
		
		UserDetails userdetails1 = createNewUser("thietquang", "123");
		UserDetails userdetails2= createNewUser("baby5", "123");
		
		return new InMemoryUserDetailsManager(userdetails1,userdetails2);
	}
private UserDetails createNewUser(String username, String password) {
	Function<String, String> PasswordEncoder
	=input->passwordEncoder().encode(input);
	
	UserDetails userdetails = User
	.builder()
	.passwordEncoder(PasswordEncoder)
	.username(username)
	.password(password)
	.roles("USER","ADMIN")
	.build();
	return userdetails;
}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		 http.authorizeHttpRequests(
				 auth -> auth.anyRequest().authenticated()
				 );
		 http.formLogin(withDefaults());
		 
		 http.csrf().disable();
		 http.headers().frameOptions().disable();
		 return http.build();
	}
}
