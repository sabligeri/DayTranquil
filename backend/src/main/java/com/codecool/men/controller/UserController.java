package com.codecool.men.controller;

import com.codecool.men.controller.dto.UserDTO;
import com.codecool.men.controller.dto.NewUserDTO;
import com.codecool.men.dao.model.User;
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

  @PostMapping("/login")
  public UserDTO loginUser(@RequestBody NewUserDTO newUserDTO) {
    return userService.loginUser(newUserDTO);
  }

  @GetMapping("/edit/{userId}")
  public User editUser(@RequestBody User user) {
    throw new RuntimeException();
  }

  @DeleteMapping("/delete/{userId}")
  public boolean delete(@PathVariable UUID userId) {
    return userService.deleteUser(userId);
  }

  @PostMapping("/add")
  public void addUser(@RequestBody NewUserDTO newUser) {
    userService.addUser(newUser);
  }

}
