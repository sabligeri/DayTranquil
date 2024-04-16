package com.codecool.men.controller.dto;

public record NewNoteDTO(
        String title,
        String text,
        int userId
) {
}
