package com.thietAppp.springboot.todoApp.Login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String username, String password)
	{
		boolean isValidUserName= username.contains(username);
		boolean isValidUserPassword =  password.equalsIgnoreCase("123");
		return isValidUserName && isValidUserPassword;
		
	}
}
