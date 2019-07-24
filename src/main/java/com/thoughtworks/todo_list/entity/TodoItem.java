package com.thoughtworks.todo_list.entity;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private Boolean status = false;

    public TodoItem() {
    }

    public TodoItem(String content, Boolean status) {
        this.content = content;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
