package com.example.lab5.controller;

import com.example.lab5.model.TaskDto;
import com.example.lab5.model.task.Task;
import com.example.lab5.model.task.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping({"", "/"})
    public String getTasks(Model model) {
        var tasks = taskRepository.findAll(Sort.by(Sort.Direction.DESC, "taskId"));
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @GetMapping("/create")
    public String createTask(Model model) {
        TaskDto taskDto = new TaskDto();
        model.addAttribute("taskDto", taskDto);
        return "tasks/create";
    }

    @PostMapping("/create")
    public String createTask(@Valid @ModelAttribute TaskDto taskDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "tasks/create";
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setPriority(taskDto.getPriority());
        task.setStatus(taskDto.getStatus());
        task.setDate(new Date());
        taskRepository.save(task);
        return "redirect:/tasks";
    }
}
