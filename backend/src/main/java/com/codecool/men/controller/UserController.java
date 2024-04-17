package com.codecool.men.controller;

import com.codecool.men.controller.dto.UserDTO;
import com.codecool.men.controller.dto.NewUserDTO;
import com.codecool.men.controller.dto.UserNameDTO;

import com.codecool.men.controller.dto.UserPasswordDTO;
import com.codecool.men.service.UserService;
import org.springframework.web.bind.annotation.*;

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

  @PatchMapping("/edit/username/{userId}")
  public UserNameDTO editUsername(@RequestBody UserNameDTO username, @PathVariable int userId) {
    return userService.editUsername(username, userId);
  }
  @PatchMapping("/edit/password/{userId}")
  public boolean editUserPassword(@RequestBody UserPasswordDTO password, @PathVariable int userId) {
    return userService.editUserPassword(password, userId);
  }

  @DeleteMapping("/delete/{userId}")
  public boolean delete(@PathVariable int userId) {
    return userService.deleteUser(userId);
  }

  @PostMapping("/add")
  public void addUser(@RequestBody NewUserDTO newUser) {
    userService.addUser(newUser);
  }

}
