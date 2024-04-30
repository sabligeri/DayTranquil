package com.codecool.men.service;

import com.codecool.men.controller.exceptions.*;
import com.codecool.men.repository.UserRepository;
import com.codecool.men.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.codecool.men.controller.dto.user.UserNameDTO;
import com.codecool.men.controller.dto.user.UserPasswordDTO;
import com.codecool.men.controller.dto.user.UserDTO;
import com.codecool.men.controller.dto.user.NewUserDTO;

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
            throw new LoginFailedException();
        }
        boolean passwordMatch = user.get().getPassword().equals(newUserDTO.password());
        if(user.get().getPassword().equals(newUserDTO.password())){
            throw new LoginFailedException();
        }
        return new UserDTO(user.get().getId().intValue());
    }

    public UserNameDTO editUsername(UserNameDTO usernameDTO, int userId) {
        Optional<User> user = userRepository.findById((long) userId);
        if (user.isPresent()) {
            user.get().setUsername(usernameDTO.username());
            userRepository.save(user.get());
            return new UserNameDTO(user.get().getUsername());
        }
        throw new OperationFailedException();
    }

    public boolean editUserPassword(UserPasswordDTO passwordDTO, int userId) {
        Optional<User> user = userRepository.findById((long) userId);
        if (user.isPresent()) {
            user.get().setPassword(passwordDTO.password());
            userRepository.save(user.get());
            return true;
        }
        throw new OperationFailedException();
    }

    public boolean deleteUser(int userId) {
        Optional<User> user = userRepository.findById((long) userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }
        throw new OperationFailedException();
    }

    public boolean addUser(NewUserDTO newUserDTO) {
        Optional<User> user = userRepository.findByUsername(newUserDTO.name());
        if(user.isPresent()){
            User newUser = new User();
            newUser.setUsername(newUserDTO.name());
            newUser.setPassword(newUserDTO.password());
            userRepository.save(newUser);
            return true;
        }else{
            throw new OperationFailedException();
        }

    }
}
