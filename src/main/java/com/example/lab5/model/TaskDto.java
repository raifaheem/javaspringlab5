package com.example.lab5.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class TaskDto {
    @NotEmpty(message = "Title is mandatory")
    private String title;

    @NotEmpty(message = "Description is mandatory")
    private String description;

    @NotEmpty(message = "priority is mandatory")
    private int priority;

    @NotEmpty(message = "Title is mandatory")
    private String status;

    @NotEmpty(message="mandatory")
    private Date dueDate;

    @NotEmpty(message = "mandatory")
    private String category;

    public @NotEmpty(message = "mandatory") Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(@NotEmpty(message = "mandatory") Date dueDate) {
        this.dueDate = dueDate;
    }

    public @NotEmpty(message = "mandatory") String getCategory() {
        return category;
    }

    public void setCategory(@NotEmpty(message = "mandatory") String category) {
        this.category = category;
    }

    public @NotEmpty(message = "Title is mandatory") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "Title is mandatory") String title) {
        this.title = title;
    }

    public @NotEmpty(message = "Description is mandatory") String getDescription() {
        return description;
    }

    public void setDescription(@NotEmpty(message = "Description is mandatory") String description) {
        this.description = description;
    }

    @NotEmpty(message = "priority is mandatory")
    public int getPriority() {
        return priority;
    }

    public void setPriority(@NotEmpty(message = "priority is mandatory") int priority) {
        this.priority = priority;
    }

    public @NotEmpty(message = "Title is mandatory") String getStatus() {
        return status;
    }

    public void setStatus(@NotEmpty(message = "Title is mandatory") String status) {
        this.status = status;
    }
}
