package com.codecool.men.controller.dto.note;

public record NewNoteDTO(
        String title,
        String text,
        long userId
) {
}
