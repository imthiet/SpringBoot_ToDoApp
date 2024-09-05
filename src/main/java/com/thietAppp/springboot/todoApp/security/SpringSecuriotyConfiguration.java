package com.thietAppp.springboot.todoApp.security;

import com.thietAppp.springboot.todoApp.User.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SpringSecuriotyConfiguration {

	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
@Bean
public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	authProvider.setUserDetailsService(userDetailsService);
	authProvider.setPasswordEncoder(passwordEncoder);
	return authProvider;
}


@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http
			.authorizeHttpRequests(authorizeRequests ->
					authorizeRequests
							.requestMatchers("/register","/","/sayHello","/register.html", "/css/**", "/js/**").permitAll()
							.anyRequest().authenticated() // Yêu cầu xác thực cho các yêu cầu khác
			)
//			.formLogin(withDefaults())
			.formLogin(form -> form
				//	.loginPage("/login_main")
					.defaultSuccessUrl("/", true) // Chuyển hướng đến /home sau khi đăng nhập thành công
					.permitAll() // Cho phép truy cập trang login
			)
			.csrf(csrf -> csrf.disable()); // Cấu hình CSRF Protection nếu cần

	return http.build();
}

}