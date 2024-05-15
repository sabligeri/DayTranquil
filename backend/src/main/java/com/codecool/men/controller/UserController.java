package com.codecool.men.controller;

import com.codecool.men.controller.dto.user.NewUserDTO;
import com.codecool.men.controller.dto.user.UserDTO;
import com.codecool.men.controller.dto.user.UserNameDTO;
import com.codecool.men.controller.dto.user.UserPasswordDTO;
import com.codecool.men.repository.UserRepository;
import com.codecool.men.repository.model.UserEntity;
import com.codecool.men.repository.model.payload.JwtResponse;
import com.codecool.men.security.jwt.JwtUtils;
import com.codecool.men.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody NewUserDTO newUserDTO) {
        return userService.loginUser(newUserDTO);
  }

  @PatchMapping("/edit/username/{userId}")
  @PreAuthorize("hasRole('USER')")
  public UserNameDTO editUsername(@RequestBody UserNameDTO username, @PathVariable int userId) {
    return userService.editUsername(username, userId);
  }

  @PatchMapping("/edit/password/{userId}")
  @PreAuthorize("hasRole('USER')")
  public boolean editUserPassword(@RequestBody UserPasswordDTO password, @PathVariable int userId) {
    return userService.editUserPassword(password, userId);
  }

  @DeleteMapping("/delete/{userId}")
  @PreAuthorize("hasRole('USER')")
  public boolean delete(@PathVariable int userId) {
    return userService.deleteUser(userId);
  }

  @PostMapping("/add")
  public boolean addUser(@RequestBody NewUserDTO newUser) {
    return userService.addUser(newUser);
  }

}
