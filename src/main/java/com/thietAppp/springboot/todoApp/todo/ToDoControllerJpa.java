package com.thietAppp.springboot.todoApp.todo;

import com.thietAppp.springboot.todoApp.User.User;
import com.thietAppp.springboot.todoApp.User.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {

	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private UserRepository userRepository;

	public String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	@RequestMapping(value = "list-todos-jpa", method = RequestMethod.GET)
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername();  // Lấy tên người dùng từ SecurityContext
		List<ToDo> todos = todoRepository.findByUser_Username(username);
		model.put("todos", todos);
		model.put("name", username);  // Đảm bảo thuộc tính 'name' được gán trong session
		return "listTodos";
	}

	@RequestMapping(value = "add-todo-jpa", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		ToDo todo = new ToDo();
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo-jpa", method = RequestMethod.POST)
	public String addNewToDo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "todo";
		}

		String username = getLoggedInUsername();  // Lấy tên người dùng từ SecurityContext
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
		todo.setUser(user);
		todo.setTargetDate(LocalDate.now().plusWeeks(1));
		todoRepository.save(todo);
		return "redirect:list-todos-jpa";
	}

	@RequestMapping(value = "delete-todo-jpa", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos-jpa";
	}

	@RequestMapping(value = "update-todo-jpa", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		ToDo todo = todoRepository.findById(id).orElse(null);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "update-todo-jpa", method = RequestMethod.POST)
	public String updateTodo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "todo";
		}

		String username = getLoggedInUsername();  // Lấy tên người dùng từ SecurityContext
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
		todo.setUser(user);
		todoRepository.save(todo);
		return "redirect:list-todos-jpa";
	}

}
