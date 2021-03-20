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
	private Integer idCount = 0;
	//http://localhost:8080
	
	@GetMapping("/api/todoItems")
	public ResponseEntity<?> getAllTodoItems() {
		List<TodoItem> todoItems = service.getAllTodoItems();
		if(todoItems.isEmpty()) {
			TodoItem a = new TodoItem();
			a.setId(1);
			a.setTask("Task 1");
			a.setCompleted(false);
			todoItems.add(a);
		}
		
		
		return ResponseEntity.ok(todoItems);
	}
	
	@PutMapping("/api/todoItems/{id}")
	public ResponseEntity<?> updateTodoItem(@PathVariable Integer id, @RequestBody TodoItem todoItem) {
		// Call server -> Get data from server -> Send back to FrontEnd
		
		TodoItem updatedItem = service.updateTodoItem(id, todoItem);

		return ResponseEntity.ok(updatedItem);
	}
	
	
	
	
	
}
