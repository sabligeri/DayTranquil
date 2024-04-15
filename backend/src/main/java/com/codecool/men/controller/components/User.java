package com.codecool.men.controller.components;

import java.util.Date;
import java.util.List;

public record User(
        int id,
        String name,
        String password,
        List<Note> notes
) {
}
