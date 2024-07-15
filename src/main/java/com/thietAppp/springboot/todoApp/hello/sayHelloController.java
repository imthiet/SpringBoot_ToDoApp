package com.thietAppp.springboot.todoApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class sayHelloController {
	

	// say_hello.jsp
	// /src/main/resources/MEAT-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say_hello_jsp")
	public String sayHelloJSP()
	{
		return "sayHello";
	}
	

}
