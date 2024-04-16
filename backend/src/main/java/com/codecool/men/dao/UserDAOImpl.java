package com.codecool.men.dao;

import com.codecool.men.dtos.UserOperationsDTO;
import com.codecool.men.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDAOImpl implements UserDAO{
  private final Set<User> users;

  public UserDAOImpl() {
    this.users = Set.of(
            new User("Alice", "password1"),
            new User("test", "test"),
            new User("Bob", "password2"));
  }

  @Override
  public User getUserByName(String name) {
    if(users.stream().filter(user -> user.getUsername().equals(name)).count() > 0){
      return users.stream().filter(user -> Objects.equals(user.getUsername(), name)).toList().getFirst();
    }else{
      return null;
    }

  }

  @Override
  public void deleteUser(UUID userId) {
    User toBeDeleted = users.stream().filter(user -> user.getUserId().equals(userId)).toList().getFirst();
    users.remove(toBeDeleted);
  }

  @Override
  public void addUser(UserOperationsDTO userOperationsDTO) {
    users.add(new User(userOperationsDTO.name(), userOperationsDTO.password()));
  }
}
