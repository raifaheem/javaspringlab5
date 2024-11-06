package com.example.lab5.model.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<com.example.lab5.model.category.Category, Integer> {

}
