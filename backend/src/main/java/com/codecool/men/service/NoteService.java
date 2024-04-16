package com.codecool.men.service;

import com.codecool.men.controller.dto.NewNoteDTO;
import com.codecool.men.dao.model.Note;
import com.codecool.men.dao.NoteDAOImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteDAOImpl noteDao;

    public NoteService(NoteDAOImpl noteDao) {
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

    public Note addNote(NewNoteDTO newNoteDTO) {
        return noteDao.addNote(newNoteDTO);
    }
}
