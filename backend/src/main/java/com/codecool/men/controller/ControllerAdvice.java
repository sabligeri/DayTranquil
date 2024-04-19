package com.codecool.men.controller;

import com.codecool.men.controller.exceptions.AlreadyInUseUsername;
import com.codecool.men.controller.exceptions.NoteNotFoundException;
import com.codecool.men.controller.exceptions.WrongPasswordException;
import com.codecool.men.controller.exceptions.WrongUsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
  @ResponseBody
  @ExceptionHandler({
          WrongUsernameException.class,
          WrongPasswordException.class,
          AlreadyInUseUsername.class,
          NoteNotFoundException.class
  })
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String wrongUserInfoException(RuntimeException ex) {
    return ex.getMessage();
  }

}
