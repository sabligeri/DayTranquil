package com.codecool.men.dao.model;

import java.util.UUID;

public record User(UUID userId, String username, String password) {
}
