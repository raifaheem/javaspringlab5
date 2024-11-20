package com.example.lab5.model.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<com.example.lab5.model.task.Task, Long> {
    List<Task> findByUserId(Long userId);
    Iterable<Task> findByTitle(String title);
}
