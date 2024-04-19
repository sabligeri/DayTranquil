package com.codecool.men.controller.exceptions;

public class AlreadyInUseUsername extends RuntimeException{
  public AlreadyInUseUsername(){
    super("This username is already in use, choose a different one!");
  }
}
