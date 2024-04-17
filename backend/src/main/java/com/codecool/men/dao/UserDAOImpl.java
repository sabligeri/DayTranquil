package com.codecool.men.dao;

import com.codecool.men.controller.dto.NewUserDTO;
import com.codecool.men.dao.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class UserDAOImpl implements UserDAO{
  private final Set<User> users;

  public UserDAOImpl() {
    this.users = new HashSet<>();
    createUsers();
  }

  @Override
  public Optional<User> getUserByName(String name) {
    return  users.stream()
            .filter(user -> user.getUsername().equals(name))
            .findFirst();

  }

  @Override
  public boolean deleteUser(int userId) {
   return users.removeIf(user -> user.getId() == userId);
  }

  @Override
  public void addUser(NewUserDTO newUserDTO) {
    users.add(new User(newUserDTO.name(), newUserDTO.password()));
  }

  @Override
  public String editUsername(int userId, String userName) {
    Optional<User> editedUser = users.stream().filter(user -> user.getId() == userId).findFirst();
    if(editedUser.isPresent()){
    editedUser.get().setUsername(userName);
      return editedUser.get().getUsername();
    }else{
      return "Nope";
    }
  }

  @Override
  public boolean editUserPassword(int userId, String passWord) {
    Optional<User> editedUser = users.stream().filter(user -> user.getId() == userId).findFirst();
    if(editedUser.isPresent()){
      editedUser.get().setPassword(passWord);
      return true;
    }else{
      return false;
    }
  }


  private void createUsers(){
    users.add(new User( "Alice", "password1"));
    users.add(new User( "Bob", "password2"));
    users.add(new User("test", "test"));
    users.add(new User("test2", "test2"));
    users.add(new User("test1", "test1"));
  }
}
