package com.codecool.men.service;

import com.codecool.men.controller.dto.UserNameDTO;
import com.codecool.men.controller.dto.UserPasswordDTO;
import com.codecool.men.dao.UserDAO;
import com.codecool.men.controller.dto.UserDTO;
import com.codecool.men.controller.dto.NewUserDTO;
import com.codecool.men.dao.model.User;

import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
  private final UserDAO userDAO;

  public UserService(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public UserDTO loginUser(NewUserDTO newUserDTO) {
    Optional<User> user = userDAO.getUserByName(newUserDTO.name());

    if (user.isEmpty()) {
      return new UserDTO(0, null, false);
    }
    if (Objects.equals(user.get().getPassword(), newUserDTO.password())) {
      return new UserDTO(user.get().getId(), true, true);
    } else {
      return new UserDTO(user.get().getId(), false, true);
    }

  }

  public UserNameDTO editUsername(UserNameDTO changes, int userId ) {
    return new UserNameDTO(userDAO.editUsername(userId, changes.username()));
  }
  public boolean editUserPassword(UserPasswordDTO changes, int userId){
    return userDAO.editUserPassword(userId, changes.password());
  }

  public boolean deleteUser(int userId) {
    return userDAO.deleteUser(userId);
  }

  public void addUser(NewUserDTO newUser) {
    userDAO.addUser(newUser);
  }

}
