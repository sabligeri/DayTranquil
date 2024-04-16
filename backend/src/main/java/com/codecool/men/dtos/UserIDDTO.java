package com.codecool.men.dtos;

import java.util.UUID;

public record UserIDDTO (UUID userID, boolean password, boolean userName){
}
