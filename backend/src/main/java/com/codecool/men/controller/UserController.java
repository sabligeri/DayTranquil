package com.codecool.men.controller;

import com.codecool.men.controller.components.Note;
import com.codecool.men.controller.components.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  @GetMapping("/login")
  public boolean loginUser() {
    throw new RuntimeException();
  }

  @GetMapping("/edit")
  public User editUser() {
    throw new RuntimeException();
  }

  @GetMapping("/delete")
  public boolean delete() {
    throw new RuntimeException();
  }

  @GetMapping("/add")
  public User addUser() {
    throw new RuntimeException();
  }

}
