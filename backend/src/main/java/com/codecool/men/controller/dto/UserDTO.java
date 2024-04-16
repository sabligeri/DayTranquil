package com.codecool.men.controller.dto;

import java.util.UUID;

public record UserDTO(UUID userID, Boolean password, boolean userName){
}
