package com.shamsutyle.todoapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shamsutyle.todoapp.domain.TodoItem;
import com.shamsutyle.todoapp.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repo;

	public List<TodoItem> getAllTodoItems () {
		return repo.getAllTodoItems();
	}
	
	public TodoItem createTodoItem() {
		TodoItem newItem = new TodoItem();
		newItem.setCompleted(false);
		
		newItem = repo.save(newItem);
		newItem.setTask("Task #" + newItem.getId());
		return newItem;
	}

	public TodoItem updateTodoItem(Integer id, TodoItem todoItem) {
		Optional<TodoItem> locateItem = repo.getAllTodoItems()
				 .stream()
				 .filter(item -> item.getId().equals(id))
				 .findAny();
		 // Update item's properties
		 // Is replacing the item more efficient...?
		 
		 if(locateItem.isPresent()) {
			TodoItem updatedItem = locateItem.get();
			updatedItem.setCompleted(todoItem.getCompleted());
			updatedItem.setTask(todoItem.getTask());
			return updatedItem;
		}
		 System.out.println("returning null");
		 return null;
	}	
}
