package com.thietAppp.springboot.todoApp.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
//	private AuthenticationService authenticationService
//	;
//	
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}
	
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String sayHellopage(ModelMap model) {
       model.put("name", "thietquang");
        return "sayHello";
    }
    
//    @RequestMapping(value = "login_jsp",method = RequestMethod.POST)
//    public String goWelcome
//    (@RequestParam String name,@RequestParam String password,ModelMap model) {
//       model.put("name", name);
//       model.put("password", password);
//       if(authenticationService.authenticate(name , password))
//       {
//    	 //Authentication
//           //name - thietquang
//           
//            return "sayHello";
//       }
//       model.put("errorMessage", "Wrong name or password!");
//       return "Login";
//       
//    }

	
}
