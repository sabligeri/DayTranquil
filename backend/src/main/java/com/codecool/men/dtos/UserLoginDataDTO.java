package com.codecool.men.dtos;

import java.util.UUID;

public record UserLoginDataDTO(UUID userID, boolean password, boolean userName){
}
