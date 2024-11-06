package com.example.lab5.model.category;

import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category {
    private long id;
    private String name;

    public Category() {}
    public Category(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name="name", nullable=false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}
