package com.codecool.men.controller.components;

import java.util.Date;

public record Note(
        int id,
        String title,
        String text,
        Date created,
        int userId
) {
}
