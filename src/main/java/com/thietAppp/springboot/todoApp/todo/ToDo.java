package com.thietAppp.springboot.todoApp.todo;

import java.time.LocalDate;

import com.thietAppp.springboot.todoApp.User.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ToDo")
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Size(min = 10, message = "Enter more Character!")
	private String description;
	private LocalDate targetDate;
	private boolean done;

	// Constructors
	public ToDo(int ID, String description, LocalDate targetDate, boolean done,User user) {
		super();
		this.ID = ID;
		this.user = user;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public ToDo() {}

	// Getters and Setters
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return "ToDo [ID=" + ID + ", user=" + (user != null ? user.getUsername() : "No user") +
				", description=" + description + ", targetDate=" + targetDate + ", done=" + done + "]";
	}
}
