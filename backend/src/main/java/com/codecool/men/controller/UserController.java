package com.codecool.men.controller;

import com.codecool.men.controller.components.NewUser;
import com.codecool.men.controller.components.Note;
import com.codecool.men.controller.components.User;
import com.codecool.men.dtos.UserOperationsDTO;
import com.codecool.men.service.UserService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody UserOperationsDTO userOperationsDTO) {
    return userService.loginUser(userOperationsDTO);
  }

  @GetMapping("/edit/{userId}")
  public User editUser(@RequestParam UUID userID, @RequestBody User user) {
    throw new RuntimeException();
  }

  @GetMapping("/delete/{userId}")
  public void delete(@RequestParam UUID userId) {
    userService.deleteUser(userId);
  }

  @GetMapping("/add")
  public User addUser(@RequestBody NewUser newUser) {
    throw new RuntimeException();
  }

}
