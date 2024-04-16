package com.codecool.men.dao;

import com.codecool.men.controller.dto.NewNoteDTO;
import com.codecool.men.dao.model.Note;

import java.util.List;

public interface NoteDAO {
    List<Note> getAllNotes(int userId);
    Note getNote(int userId, int noteId);
    boolean deleteNote(int userId, int noteId);
    Note addNote( NewNoteDTO newNoteDTO);
}
