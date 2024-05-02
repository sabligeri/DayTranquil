package com.codecool.men.controller.exceptions;

public class OperationFailedException extends RuntimeException{
  public OperationFailedException() {
    super("Operation failed!");
  }
}
