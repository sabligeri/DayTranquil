package com.codecool.men.controller;

import com.codecool.men.controller.exceptions.LoginFailedException;
import com.codecool.men.controller.exceptions.NoteNotFoundException;
import com.codecool.men.controller.exceptions.OperationFailedException;
import com.codecool.men.controller.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
// class átnevezése, hogy ne vágjon egybe az annotáció nevével
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
  @ResponseBody
  @ExceptionHandler({
          LoginFailedException.class,
          OperationFailedException.class,
          UserNotFoundException.class,
          NoteNotFoundException.class
  })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String wrongUserInfoException(RuntimeException ex) {
    return ex.getMessage();
  }

}
