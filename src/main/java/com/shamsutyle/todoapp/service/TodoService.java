package com.shamsutyle.todoapp.service;

import java.util.List;

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
}
