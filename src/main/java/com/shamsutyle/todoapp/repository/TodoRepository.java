package com.shamsutyle.todoapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shamsutyle.todoapp.domain.TodoItem;

@Repository
public class TodoRepository {
	
	private List<TodoItem> todoItems = new ArrayList<>();
	
	public List<TodoItem> getAllTodoItems (){
		return this.todoItems;
	}
	
}
