package com.thietAppp.springboot.todoApp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<ToDo, Integer> {
	

	public List<ToDo> findByUser_Username(String username);
}
