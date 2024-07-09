package com.thietAppp.springboot.todoApp.todo;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ToDoController {
	
	//list-todos
	
	private ToDoService toDoService;
	public ToDoController(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}
	
	@RequestMapping("list-todos")// url
	
	public String listAllToDos(Model model)
	{
		List <ToDo> todos = toDoService.findByUserName("thietQuang");
		model.addAttribute("todos",todos);
		return "listToDos";// file jsp
	}
	
	
	//GET method
	@RequestMapping(value = "add-todo",method = RequestMethod.GET)// url
	public String showNewToDo(Model model)
	{
		
		return "todo";// file jsp
	}
	//POST method
		@RequestMapping(value = "add-todo",method = RequestMethod.POST)// url
		public String addNewToDo(@RequestParam String description,ModelMap model)	
		{
			String username = (String)(model).get("name");
			toDoService.addToDo(username, description, LocalDate.now().plusMonths(3), false);
			
			return "redirect:list-todos";// file jsp
		}
}
