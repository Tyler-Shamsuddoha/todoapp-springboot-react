package com.shamsutyle.todoapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		return ResponseEntity.ok(todoItems);
	}
	
	@PutMapping("/api/todoItems/{id}")
	public ResponseEntity<?> updateTodoItems(@RequestBody TodoItem todoItem) {
		// Call server -> Get data from server -> Send back to FrontEnd
		
		service.updateTodoItem(todoItem);
		
		return null;
		
	}
	
	
	
	
	
}
