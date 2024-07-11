package com.thietAppp.springboot.todoApp.todo;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
//Database (Mysql)
// Static List of Todos => DB(h2,Mysql)

@Entity
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	
	private String name;
	
	@Size(min = 10, message = "Enter more Character!")
	private String description;
	private LocalDate targetDate;
	boolean done;
	
	
	public ToDo(int ID, String name, String description, LocalDate targetDate, boolean done) {
		super();
		this.ID = ID;
		this.name = name;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public ToDo()
	{
		
	}
	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getTargetDate() {
		return targetDate;
	}


	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}


	public boolean isDone() {
		return done;
	}


	public void setDone(boolean done) {
		this.done = done;
	}


	@Override
	public String toString() {
		return "ToDo [ID=" + ID + ", name=" + name + ", description=" + description + ", targetDate=" + targetDate
				+ ", done=" + done + "]";
	}
	

	
}
