package com.thietAppp.springboot.todoApp.todo;

import java.time.LocalDate;
//Database (Mysql)
// Static List of Todos => DB(h2,Mysql)
public class ToDo {
	private int ID;
	private String name,description;
	private LocalDate targetDate;
	boolean done;
	
	
	public ToDo(int iD, String name, String description, LocalDate targetDate, boolean done) {
		super();
		ID = iD;
		this.name = name;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
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
