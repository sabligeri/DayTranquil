package com.codecool.men.dao;

import com.codecool.men.controller.dto.NewUserDTO;
import com.codecool.men.dao.model.User;

import java.util.UUID;

public interface UserDAO {
  User getUserByName(String name);
  boolean deleteUser(UUID userId);
  void addUser(NewUserDTO newUserDTO);
}
