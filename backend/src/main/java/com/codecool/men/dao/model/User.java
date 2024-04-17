package com.codecool.men.dao.model;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private final int id;
    private static AtomicInteger count = new AtomicInteger(0);
    private final String username;
    private final String password;


    public User(String username, String password) {
        this.id = count.incrementAndGet();
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
}

//(UUID userId, String username, String password)