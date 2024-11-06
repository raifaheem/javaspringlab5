package com.example.lab5.model.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<com.example.lab5.model.task.Task, Long> {
}
