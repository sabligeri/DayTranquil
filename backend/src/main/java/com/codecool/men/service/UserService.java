package com.codecool.men.service;

import com.codecool.men.UserDAO;
import com.codecool.men.controller.components.NewUser;
import com.codecool.men.controller.components.User;
import com.codecool.men.dtos.UserOperationsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
  private final UserDAO userDAO;

  public UserService(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public ResponseEntity<?> loginUser(UserOperationsDTO userOperationsDTO) {
      Optional<com.codecool.men.model.User> user =  userDAO.getUser(userOperationsDTO.name());
      if(user.isEmpty()){
        return ResponseEntity.badRequest().body("No such user exists!");
      }else if(user.get().getPassword().equals(userOperationsDTO.password())){
        return ResponseEntity.badRequest().body("Wrong password!");
      }else {
        return ResponseEntity.ok(user.get().getUserId());
      }
  }

  public User editUser(User user) {
    throw new RuntimeException();
  }

  public void deleteUser(UUID userId) {
    userDAO.deleteUser(userId);
  }

  public User addUser(NewUser newUser) {
    throw new RuntimeException();
  }

}
