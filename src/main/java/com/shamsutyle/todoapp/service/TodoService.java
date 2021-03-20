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

	public TodoItem updateTodoItem(TodoItem todoItem) {
		 Optional<TodoItem> locateItem = repo.getAllTodoItems()
				 .stream()
				 .filter((TodoItem item) -> {return item.getId() == (todoItem.getId());})
				 .findAny();
		
		 // Update item's properties
		 // Is replacing the item more efficient...?
		 if(locateItem.isPresent()) {
			TodoItem updatedItem = locateItem.get();
			updatedItem.setCompleted(todoItem.isCompleted());
			updatedItem.setId(todoItem.getId());
			updatedItem.setTask(todoItem.getTask());
			
			return updatedItem;
		}
		 return null;
	}
}
