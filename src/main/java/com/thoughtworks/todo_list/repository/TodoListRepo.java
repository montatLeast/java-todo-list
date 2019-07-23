package com.thoughtworks.todo_list.repository;

import com.thoughtworks.todo_list.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepo extends JpaRepository<TodoItem, Long> {

}
