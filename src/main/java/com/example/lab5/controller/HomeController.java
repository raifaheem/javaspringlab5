package com.example.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"", "/"})
    public String home() {
        return "index";
    }

    @GetMapping("/tasks/index")
    public String tasks() {
        return "tasks/index";
    }
}
