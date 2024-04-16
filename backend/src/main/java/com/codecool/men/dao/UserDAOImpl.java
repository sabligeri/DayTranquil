package com.codecool.men.dao;

import com.codecool.men.dtos.UserOperationsDTO;
import com.codecool.men.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Repository
public class UserDAOImpl implements UserDAO{
  private final Set<User> users;

  public UserDAOImpl() {
    this.users = new HashSet<>();
    createUsers();
  }

  @Override
  public User getUserByName(String name) {
    return users.stream().filter(user -> user.getUsername().equals(name)).toList().getFirst();
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

  private void createUsers(){
    users.add(new User( "Alice", "password1"));
    users.add(new User( "Bob", "password2"));
    users.add(new User( "test", "test"));
    users.add(new User( "test2", "test2"));
    users.add(new User( "test1", "test1"));
  }
}
