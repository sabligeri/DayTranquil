package com.codecool.men.controller;

import com.codecool.men.controller.components.NewUser;
import com.codecool.men.controller.components.Note;
import com.codecool.men.controller.components.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  @GetMapping("/login")
  public boolean loginUser(@RequestBody NewUser newUser) {
    throw new RuntimeException();
  }

  @GetMapping("/edit")
  public User editUser(@RequestBody User user) {
    throw new RuntimeException();
  }

  @GetMapping("/delete/{userId}")
  public boolean delete(@RequestParam int userId) {
    throw new RuntimeException();
  }

  @GetMapping("/add")
  public User addUser(@RequestBody NewUser newUser) {
    throw new RuntimeException();
  }

}
