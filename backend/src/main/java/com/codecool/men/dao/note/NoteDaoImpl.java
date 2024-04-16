package com.codecool.men.dao.note;

import com.codecool.men.controller.components.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class NoteDaoImpl implements NoteDAO{
    private List<Note> notes;

    public NoteDaoImpl() {
        this.notes = new ArrayList<>();
    }

    @Override
    public List<Note> getAllNotes() {
        return notes;
    }
}
