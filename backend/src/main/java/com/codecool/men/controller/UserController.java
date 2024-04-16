package com.codecool.men.controller;

import com.codecool.men.dtos.UserLoginDataDTO;
import com.codecool.men.dtos.UserOperationsDTO;
import com.codecool.men.model.User;
import com.codecool.men.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public UserLoginDataDTO loginUser(@RequestBody UserOperationsDTO userOperationsDTO) {
    return userService.loginUser(userOperationsDTO);
  }

  @GetMapping("/edit/{userId}")
  public User editUser(@PathVariable UUID userID, @RequestBody User user) {
    throw new RuntimeException();
  }

  @DeleteMapping("/delete/{userId}")
  public void delete(@PathVariable UUID userId) {
    userService.deleteUser(userId);
  }

  @PostMapping("/add")
  public void addUser(@RequestBody UserOperationsDTO newUser) {
    userService.addUser(newUser);
  }

}
