package com.thietAppp.springboot.todoApp.hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
