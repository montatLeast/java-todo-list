package com.thoughtworks.todo_list.controller;

import com.thoughtworks.todo_list.entity.TodoItem;
import com.thoughtworks.todo_list.exception.DuplicateException;
import com.thoughtworks.todo_list.repository.TodoListRepo;
import com.thoughtworks.todo_list.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todoItems")
@CrossOrigin
//解决跨域访问
public class TodoListController {
    @Autowired
    TodoListService todoListService;

    @Autowired
    TodoListRepo todoListRepo;


    @GetMapping()
    public ResponseEntity getAllTodoItems(@RequestParam (required = false, defaultValue = "1")int page) {
        List<TodoItem> todoItems = todoListService.getAllItems();
        return ResponseEntity.ok().body(todoItems);
    }

    @PostMapping()
    public ResponseEntity addTodoItem(@RequestBody TodoItem todoItem) {
        TodoItem todoItem1;
        try{
            todoItem1 = todoListService.addTodoItem(todoItem);
        }catch (DuplicateException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(todoItem1);
    }

    @PutMapping("/{id}")
    public ResponseEntity modifyTodoItemCapacity(@RequestBody TodoItem todoItem, @PathVariable Long id){
        TodoItem todoItem1;
        try{
            todoItem1 = todoListService.modifyTodoItemContent(todoItem, id);
        }catch (DuplicateException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(todoItem1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodoItem(@PathVariable Long id){
        TodoItem todoItem = todoListService.deleteTodoItem(id);
        return ResponseEntity.status(HttpStatus.OK).body(todoItem);
    }


}
