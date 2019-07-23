package com.thoughtworks.todo_list.service;

import com.thoughtworks.todo_list.entity.TodoItem;
import com.thoughtworks.todo_list.repository.TodoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoListService {

    @Autowired
    private TodoListRepo todoListRepo;

    public List<TodoItem> getAllItems(){
        List<TodoItem> todoItems = new ArrayList<>();
        todoItems = todoListRepo.findAll();
        return todoItems;
    }

    public TodoItem getTodoItemById(Long id){
        TodoItem todoItem = new TodoItem();
        todoItem = todoListRepo.findById(id).get();
        return todoItem;
    }

    public TodoItem addTodoItem(TodoItem todoItem){
        TodoItem todoItem1 = todoListRepo.save(todoItem);
        return todoItem1;
    }

    public TodoItem modifyTodoItemContent(TodoItem todoItem, Long id){
        TodoItem todoItem1 = todoListRepo.save(todoItem);
        return todoItem1;
    }

    public TodoItem deleteTodoItem(Long id){
        TodoItem todoItem1 = todoListRepo.findById(id).get();
        todoListRepo.deleteById(id);
        return todoItem1;
    }

}
