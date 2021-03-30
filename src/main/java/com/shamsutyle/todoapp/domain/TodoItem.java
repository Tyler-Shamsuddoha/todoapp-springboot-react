package com.shamsutyle.todoapp.domain;

public class TodoItem {

	private Integer id;
	private String task;
	private boolean isCompleted;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public boolean getCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	@Override
	public String toString() {
	return "ID = " + this.id + " task = " + this.task +
		" isCompleted = " + this.isCompleted;
	}
	
	
	
	
	
}
