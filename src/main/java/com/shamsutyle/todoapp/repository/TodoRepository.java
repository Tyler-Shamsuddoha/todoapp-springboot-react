package com.shamsutyle.todoapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shamsutyle.todoapp.domain.TodoItem;

@Repository
public class TodoRepository {
	
	private Integer idCount = 0;
	private List<TodoItem> todoItems = new ArrayList<>();
	
	public List<TodoItem> getAllTodoItems (){
		if(todoItems.size() == 0) {
			
			// Add a default TodoItem to test with
			
			TodoItem a = new TodoItem();
			a.setId(idCount++);
			a.setCompleted(true);
			a.setTask("Task 1");
			
			todoItems.add(a);
		}
		return this.todoItems;
	}
	
	
	// Takes an item and saves it to the list
	// Also introduces an ID to each new TodoItem
	public TodoItem save(TodoItem todoItem) {
		todoItem.setId(idCount++);
		todoItems.add(todoItem);
		
		return todoItem;
	}
	
}
