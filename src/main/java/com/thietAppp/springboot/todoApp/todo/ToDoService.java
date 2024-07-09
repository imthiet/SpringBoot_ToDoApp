package com.thietAppp.springboot.todoApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


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
		return todos;
	}
	
	public void addToDo(String name,String description,LocalDate targetDate, boolean done)
	{
		ToDo todo = new ToDo(++todosCount,name,description,targetDate,done);
		todos.add(todo);
	}
}
