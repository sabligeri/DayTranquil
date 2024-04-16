package com.codecool.men.service;

import com.codecool.men.dao.UserDAO;
import com.codecool.men.controller.dto.UserDTO;
import com.codecool.men.controller.dto.NewUserDTO;
import com.codecool.men.dao.model.User;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
  private final UserDAO userDAO;

  public UserService(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public UserDTO loginUser(NewUserDTO newUserDTO) {
    Optional<User> user = Optional.ofNullable(userDAO.getUserByName(newUserDTO.name()));

    if (user.isEmpty()) {
      return new UserDTO(null, null, false);
    }
    if (Objects.equals(user.get().password(), newUserDTO.password())) {
      return new UserDTO(user.get().userId(), true, true);
    } else {
      return new UserDTO(user.get().userId(), false, true);
    }
  }

  public User editUser(User user) {
    throw new RuntimeException();
  }

  public boolean deleteUser(UUID userId) {
    return userDAO.deleteUser(userId);
  }

  public void addUser(NewUserDTO newUser) {
    userDAO.addUser(newUser);
  }

}
