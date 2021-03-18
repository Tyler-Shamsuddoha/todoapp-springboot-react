package com.shamsutyle.todoapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shamsutyle.todoapp.domain.TodoItem;
import com.shamsutyle.todoapp.service.TodoService;

@RestController
@CrossOrigin("http://localhost:3000")
public class Controller {

	@Autowired
	private TodoService service;
	private int idCount = 0;
	//http://localhost:8080
	
	@GetMapping("/api/todoItems")
	public ResponseEntity<?> getAllTodoItems() {
		List<TodoItem> todoItems = service.getAllTodoItems();
		if(todoItems.size() == 0) {
			TodoItem item = new TodoItem();
			item.setCompleted(false);
			item.setId(idCount++);
			item.setTask("Task #1");
			
			todoItems.add(item);
		}
		
		return ResponseEntity.ok(todoItems);
	}
	
	
}
