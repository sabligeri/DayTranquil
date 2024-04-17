package com.codecool.men.dao;

import com.codecool.men.controller.dto.NewUserDTO;
import com.codecool.men.dao.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserDAO {

  Optional<User> getUserByName(String name);
  boolean deleteUser(int userId);
  void addUser(NewUserDTO newUserDTO);
}
