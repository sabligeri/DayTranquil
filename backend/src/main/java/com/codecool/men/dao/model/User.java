package com.codecool.men.dao.model;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private final int id;
    private static AtomicInteger count = new AtomicInteger(0);
    private String username;
    private String password;


    public User(String username, String password) {
        this.id = count.incrementAndGet();
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSameName(String incomingName){
        return Objects.equals(incomingName, this.username);
    }
    public boolean isSameId(int id){
        return id == this.id;
    }
    //TODO
    // id.equals
}

//(UUID userId, String username, String password)