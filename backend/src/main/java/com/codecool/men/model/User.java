package com.codecool.men.model;

import java.util.UUID;

public class User {
  private final UUID userId;
  private String username;
  private String password;

  public User(String username, String password) {
    this.userId = UUID.randomUUID();
    this.username = username;
    this.password = password;
  }

  public UUID getUserId() {
    return userId;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
