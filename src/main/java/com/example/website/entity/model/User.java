package com.example.website.entity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;


@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "userid")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "create_time")
    private Timestamp create_time;

    @Column(name = "last_access")
    private Timestamp last_access;

    public User() {
    }


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getLast_access() {
        return last_access;
    }

    public void setLast_access(Timestamp last_access) {
        this.last_access = last_access;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", create_time=" + create_time +
                ", last_access=" + last_access +
                '}';
    }
}
