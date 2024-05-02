package com.codecool.men.controller.exceptions;

public class LoginFailedException extends RuntimeException{
  public LoginFailedException() {
    super("Login failed!");
  }
}