package com.shamsutyle.todoapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/api/todoItems")
	public ResponseEntity<?> getAllTodoItems() {
		List<TodoItem> todoItems = service.getAllTodoItems();
		
		return ResponseEntity.ok(todoItems);
	}
	
	@PostMapping("/api/todoItems")
	public ResponseEntity<?> createTodoItem(){
		TodoItem newItem = service.createTodoItem();
		
		return ResponseEntity.ok(newItem);
	}
	
	
	
	
	@CrossOrigin("http://localhost:3000")
	@PutMapping("/api/todoItems/{id}")
	public ResponseEntity<?> updateTodoItem(@PathVariable Integer id, @RequestBody TodoItem todoItem) {
		// Call server -> Get data from server -> Send back to FrontEnd
		
		System.out.println("TodoItem is " + todoItem.getCompleted());

		TodoItem updatedItem = service.updateTodoItem(id, todoItem);

		return ResponseEntity.ok(updatedItem);
	}
	
	
	
	
	
}
