package com.thietAppp.springboot.todoApp.todo;

import com.thietAppp.springboot.todoApp.User.User;
import com.thietAppp.springboot.todoApp.User.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ToDoController {

	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listAllTodos(ModelMap model) {
		String username = (String) model.get("name");
		List<ToDo> todos = todoRepository.findByUser_Username(username);
		model.put("todos", todos);
		return "listTodos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		ToDo todo = new ToDo();
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewToDo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "todo";
		}

		String username = (String) model.get("name");
		User user = userRepository.findByUsername(username) .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));;
		todo.setUser(user);
		todo.setTargetDate(LocalDate.now().plusWeeks(1));
		todoRepository.save(todo);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		ToDo todo = todoRepository.findById(id).orElse(null);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "todo";
		}

		String username = (String) model.get("name");
		User user = userRepository.findByUsername(username). orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));;
		todo.setUser(user);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
}
