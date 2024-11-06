package com.example.lab5.controller;

import com.example.lab5.model.category.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    CategoriesRepository categoryRepository;

}
