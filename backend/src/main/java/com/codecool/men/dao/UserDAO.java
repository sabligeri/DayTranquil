package com.codecool.men.dao;

import com.codecool.men.controller.dto.NewUserDTO;
import com.codecool.men.dao.model.User;

import java.util.Optional;

public interface UserDAO {

  User getUserByName(String name);
  boolean deleteUser(int userId);
  boolean addUser(NewUserDTO newUserDTO);
  String editUsername(int userId, String userName);

  boolean editUserPassword(int userId,String passWord);
}
