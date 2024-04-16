package com.codecool.men.dao;

import com.codecool.men.controller.dto.NewUserDTO;
import com.codecool.men.dao.model.User;
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
    return users.stream()
            .filter(user -> user.username().equals(name))
            .toList()
            .getFirst();
  }

  @Override
  public boolean deleteUser(UUID userId) {
   return users.removeIf(user -> user.userId() == userId);
  }

  @Override
  public void addUser(NewUserDTO newUserDTO) {
    users.add(new User(UUID.randomUUID(), newUserDTO.name(), newUserDTO.password()));
  }

  private void createUsers(){
    users.add(new User( UUID.randomUUID(), "Alice", "password1"));
    users.add(new User( UUID.randomUUID(),"Bob", "password2"));
    users.add(new User( UUID.randomUUID(),"test", "test"));
    users.add(new User( UUID.randomUUID(),"test2", "test2"));
    users.add(new User( UUID.randomUUID(),"test1", "test1"));
  }
}
