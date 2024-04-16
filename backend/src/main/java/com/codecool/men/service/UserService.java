package com.codecool.men.service;

import com.codecool.men.dao.UserDAO;
import com.codecool.men.dtos.UserLoginDataDTO;
import com.codecool.men.dtos.UserOperationsDTO;
import com.codecool.men.model.User;
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

  public UserLoginDataDTO loginUser(UserOperationsDTO userOperationsDTO) {
      Optional<User> user = Optional.ofNullable(userDAO.getUserByName(userOperationsDTO.name()));
      boolean userNameCheck = true;
      boolean passwordCheck = true;
      if(user.isEmpty()){
        return new UserLoginDataDTO(null, true, false);
      }
      if(!Objects.equals(user.get().getPassword(), userOperationsDTO.password())){
        passwordCheck = false;
      }
      return new UserLoginDataDTO(user.get().getUserId(), passwordCheck, userNameCheck);

  }

  public User editUser(User user) {
    throw new RuntimeException();
  }

  public void deleteUser(UUID userId) {
    userDAO.deleteUser(userId);
  }

  public void addUser(UserOperationsDTO newUser) {
    userDAO.addUser(newUser);
  }

}
