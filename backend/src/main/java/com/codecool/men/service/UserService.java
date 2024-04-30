package com.codecool.men.service;

import com.codecool.men.controller.dto.*;
import com.codecool.men.repository.UserRepository;
import com.codecool.men.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO loginUser(NewUserDTO newUserDTO) {
        Optional<User> user = userRepository.findByUsername(newUserDTO.name());
        if (user.isEmpty()) {
            return null;
        }
        boolean passwordMatch = user.get().getPassword().equals(newUserDTO.password());
        return new UserDTO(user.get().getId().intValue(), passwordMatch, true);
    }

    public UserNameDTO editUsername(UserNameDTO usernameDTO, int userId) {
        Optional<User> user = userRepository.findById((long) userId);
        if (user.isPresent()) {
            user.get().setUsername(usernameDTO.username());
            userRepository.save(user.get());
            return new UserNameDTO(user.get().getUsername());
        }
        return null;
    }

    public boolean editUserPassword(UserPasswordDTO passwordDTO, int userId) {
        Optional<User> user = userRepository.findById((long) userId);
        if (user.isPresent()) {
            user.get().setPassword(passwordDTO.password());
            userRepository.save(user.get());
            return true;
        }
        return false;
    }

    public boolean deleteUser(int userId) {
        Optional<User> user = userRepository.findById((long) userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }

    public boolean addUser(NewUserDTO newUserDTO) {
        User newUser = new User();
        newUser.setUsername(newUserDTO.name());
        newUser.setPassword(newUserDTO.password());
        userRepository.save(newUser);
        return true;
    }
}
