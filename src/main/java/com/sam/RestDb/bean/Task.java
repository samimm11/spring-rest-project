package com.sam.RestDb.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Name is mandatory")
	private String name;

	private boolean completed;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", completed=" + completed + "]";
	}

	public Task(Integer id, String name, boolean completed) {
		super();
		this.id = id;
		this.name = name;
		this.completed = completed;
	}

	public Task() {
		super();
	}

}
