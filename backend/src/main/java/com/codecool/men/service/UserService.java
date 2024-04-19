package com.codecool.men.service;

import com.codecool.men.controller.dto.UserNameDTO;
import com.codecool.men.controller.dto.UserPasswordDTO;
import com.codecool.men.controller.exceptions.WrongPasswordException;
import com.codecool.men.controller.exceptions.WrongUsernameException;
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
    User user = userDAO.getUserByName(newUserDTO.name());

    if (Objects.equals(user.getPassword(), newUserDTO.password())) {
      return new UserDTO(user.getId());
    } else {
      throw new WrongPasswordException();
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

  public boolean addUser(NewUserDTO newUser) {
    return userDAO.addUser(newUser);
  }

}
