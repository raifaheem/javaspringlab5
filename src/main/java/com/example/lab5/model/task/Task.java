package com.example.lab5.model.task;

import com.example.lab5.model.category.Category;
import com.example.lab5.model.user.User;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "tasks")
public class Task {
    private String title;
    private String description;
    private String status;
    private Date date;
    private int priority;
    private long id;

    private User user;
    private Category category;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("'Due to: ' dd/MM/yyyy HH:mm", Locale.US);

    public Task(String title, String description, String status, Date date, int priority) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.date = date;
        this.priority = priority;
    }

    public Task() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name="title", nullable=false)
    public String getTitle() {
        return title;
    }

    @Column(name="description", nullable=false)
    public String getDescription() {
        return description;
    }

    @Column(name="status", nullable=false)
    public String getStatus() {
        return status;
    }

    @Column(name="due_date", nullable=false)
    public Date getDate() {
        return date;
    }

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    public User getUser() {
        return user;
    }

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    public Category getCategory() {
        return category;
    }

    @Column(name="priority")
    public int getPriority() {
        return priority;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setId(long id) {
        this.id = id;
    }
}
