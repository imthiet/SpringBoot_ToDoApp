package com.thietAppp.springboot.todoApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.thietAppp.springboot.todoApp.User.User;

import jakarta.validation.Valid;

@Service
public class ToDoService {
	private static List<ToDo> todos = new ArrayList<>();
	private static int todosCount = 0;

	// Tìm kiếm các ToDo liên kết với một User cụ thể
	public List<ToDo> findByUser(User user) {
		Predicate<? super ToDo> predicate = todo -> todo.getUser().equals(user);
		return todos.stream().filter(predicate).toList();
	}

	// Thêm một ToDo mới với User được liên kết
	public void addToDo(User user, String description, LocalDate targetDate, boolean done) {
		ToDo todo = new ToDo(++todosCount, description, targetDate, done, user);
		todos.add(todo);
	}

	// Xóa một ToDo dựa trên ID
	public void deleteByID(int ID) {
		Predicate<? super ToDo> predicate = todo -> todo.getID() == ID;
		todos.removeIf(predicate);
	}

	// Tìm một ToDo dựa trên ID
	public ToDo findByID(int ID) {
		Predicate<? super ToDo> predicate = todo -> todo.getID() == ID;
		return todos.stream().filter(predicate).findFirst().orElse(null);
	}

	// Cập nhật một ToDo hiện có
	public void updateTodo(@Valid ToDo todo) {
		deleteByID(todo.getID());
		todos.add(todo);
	}
}
