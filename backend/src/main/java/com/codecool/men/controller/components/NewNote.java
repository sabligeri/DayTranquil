package com.codecool.men.controller.components;

import java.util.Date;

public record NewNote(
        String title,
        String text,
        int userId
) {
}
