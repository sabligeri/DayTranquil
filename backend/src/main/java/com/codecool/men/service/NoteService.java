package com.codecool.men.service;

import com.codecool.men.controller.components.NewNote;
import com.codecool.men.controller.components.Note;
import com.codecool.men.dao.note.NoteDaoImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteService {

    private final NoteDaoImpl noteDao;

    public NoteService(NoteDaoImpl noteDao) {
        this.noteDao = noteDao;
    }

    public List<Note> getAllNotes(int userId) {
        throw new RuntimeException();
    }

    public Note getNote(int userId, int noteId) {
        throw new RuntimeException();
    }

    public boolean deleteNote(int userId, int noteId) {
        throw new RuntimeException();
    }

    public Note addNote(int userId, NewNote newNote) {
        throw new RuntimeException();
    }
}
