package com.thietAppp.springboot.todoApp.todo;

import java.time.LocalDate;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class ToDoController {

	// list-todos

	private ToDoService toDoService;

	public ToDoController(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}

	@RequestMapping("list-todos") // url

	public String listAllToDos(Model model) {
		String username = (String) model.getAttribute("name");
		List<ToDo> todos = toDoService.findByUserName(username);
		model.addAttribute("todos", todos);
		return "listToDos";// file jsp
	}

	// GET method
	@RequestMapping(value = "add-todo", method = RequestMethod.GET) // url
	public String showNewToDo(ModelMap model) {
		String username = (String) model.get("name");
		ToDo todo = new ToDo(0, username, "Des11111 Here", LocalDate.now().plusMonths(2), false);
		model.put("todo", todo);
		return "todo";// file jsp
	}

	// POST method
	@RequestMapping(value = "add-todo", method = RequestMethod.POST) // url
	public String addNewToDo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {

			return "todo";// file jsp
		}

		String username = (String) model.get("name");
		toDoService.addToDo(username, todo.getDescription(), todo.getTargetDate(), false);

		return "redirect:list-todos";// file jsp
	}

	// delete
	@RequestMapping("delete-todo") // url
	public String deleteTodo(@RequestParam int ID) {
		// delete
		toDoService.deleteByID(ID);
		return "redirect:list-todos";// file jsp

	}

	// update
	@RequestMapping(value="update-todo",method = RequestMethod.GET) // url
	public String showUpdateTodo(@RequestParam int ID,ModelMap model) {
		// update
		ToDo todo = toDoService.findbyID(ID);
		model.addAttribute("todo", todo);
		return "todo";// file jsp

	}
	
	// POST method
		@RequestMapping(value = "update-todo", method = RequestMethod.POST) // url
		public String updateToDo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
			if (result.hasErrors()) {

				return "todo";// file jsp
			}

			String username = (String) model.get("name");
			todo.setName(username);
			toDoService.updateTodo(todo);
			return "redirect:list-todos";// file jsp
		}

}
