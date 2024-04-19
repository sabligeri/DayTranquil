package com.codecool.men.controller.exceptions;

public class WrongUsernameException extends RuntimeException{
  public WrongUsernameException(){
    super("No such username exists!");
  }
}
