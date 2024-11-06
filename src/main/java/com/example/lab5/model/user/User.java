package com.example.lab5.model.user;

import jakarta.persistence.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Entity
@Table(name = "users")
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Date accountCreationDate = new Date();

    private static final SimpleDateFormat sdf = new SimpleDateFormat("'Created on: 'dd/MM/yyyy HH:mm", Locale.US);

    public User() {}

    public User(String password, String email, Date accountCreationDate, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.accountCreationDate = accountCreationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name="first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @Column(name="last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }


    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    @Column(name = "creation_date", nullable = false)
    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }
}
