package com.codecool.men.service;

import com.codecool.men.controller.components.NewNote;
import com.codecool.men.controller.components.Note;
import com.codecool.men.dao.NoteDaoImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteDaoImpl noteDao;

    public NoteService(NoteDaoImpl noteDao) {
        this.noteDao = noteDao;
    }

    public List<Note> getAllNotes(int userId) {
        return noteDao.getAllNotes(userId);
    }

    public Note getNote(int userId, int noteId) {
        return noteDao.getNote(userId, noteId);
    }

    public boolean deleteNote(int userId, int noteId) {
        return noteDao.deleteNote(userId, noteId);
    }

    public Note addNote(int userId, NewNote newNote) {
        return noteDao.addNote(userId, newNote);
    }
}
