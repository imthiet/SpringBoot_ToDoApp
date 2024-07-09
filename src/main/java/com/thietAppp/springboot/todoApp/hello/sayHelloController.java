package com.thietAppp.springboot.todoApp.hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class sayHelloController {
	
	//"say-hello" = > "Hello! SpringBoot is hear!
	//http://localhost:8080/say_hello
	
	
	
	//insert some HTML code
//	@RequestMapping("say_hello_html")
//	@ResponseBody
//	public String sayHelloHtml()
//	{
//		StringBuffer sb = new StringBuffer();
//		sb.append("<html>");
//		sb.append("<head>");
//		sb.append(" <title>\r\n"
//				+ "            Yhiet Quang to do App\r\n"
//				+ "        </title>");
//		sb.append("</head>");
//		sb.append("<body>");
//		sb.append(" My first App!");
//		sb.append("</body>");
//		sb.append("</html>");
//		
//		
//		return  sb.toString();
//	}
	// say_hello.jsp
	// /src/main/resources/MEAT-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say_hello_jsp")
	public String sayHelloJSP()
	{
		return "sayHello";
	}
	

}
