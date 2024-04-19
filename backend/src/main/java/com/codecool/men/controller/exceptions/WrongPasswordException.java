package com.codecool.men.controller.exceptions;

public class WrongPasswordException extends RuntimeException{
  public WrongPasswordException(){
    super("Wrong password!");
  }
}
