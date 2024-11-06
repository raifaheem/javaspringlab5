package com.example.lab5.controller;

import com.example.lab5.model.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<com.example.lab5.model.task.Task> getAllTasks() {
        return taskRepository.findAll();
    }


}
