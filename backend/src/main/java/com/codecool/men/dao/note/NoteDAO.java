package com.codecool.men.dao.note;

import com.codecool.men.controller.components.NewNote;
import com.codecool.men.controller.components.Note;

import java.util.List;

public interface NoteDAO {
    List<Note> getAllNotes(int userId);
    Note getNote(int userId, int noteId);
    boolean deleteNote(int userId, int noteId);
    Note addNote(int userId, NewNote newNote);
}
