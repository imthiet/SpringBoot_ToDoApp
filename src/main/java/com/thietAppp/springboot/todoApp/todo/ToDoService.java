package com.thietAppp.springboot.todoApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;


@Service
public class ToDoService {
	private static List<ToDo> todos = new ArrayList();
	private static int todosCount = 0;
	static {
		todos.add(new ToDo(++todosCount,"thietQuang","SpringBoot learn",
				LocalDate.now().plusMonths(3),false));
		todos.add(new ToDo(++todosCount,"thietQuang","AWS learn",
				LocalDate.now().plusMonths(3),false));
		todos.add(new ToDo(++todosCount,"thietQuang","FE learn",
				LocalDate.now().plusMonths(2),false));
		
	}
	
	public List<ToDo> findByUserName (String name)
	{
		Predicate<? super ToDo> predicate = todo -> todo.getName().equalsIgnoreCase(name);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addToDo(String name,String description,LocalDate targetDate, boolean done)
	{
		ToDo todo = new ToDo(++todosCount,name,description,targetDate,done);
		todos.add(todo);
	}
	public void deleteByID(int ID)
	{
		//todo.getID() = id
		Predicate<? super ToDo> predicate = todo -> todo.getID() == ID;
		todos.removeIf(predicate);
	}

	public ToDo findbyID(int ID) {
		Predicate<? super ToDo> predicate = todo -> todo.getID() == ID;
		
		ToDo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid ToDo todo) {
		 deleteByID(todo.getID());
		 todos.add(todo);
		
	}
}
