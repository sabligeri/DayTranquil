package com.codecool.men.dao;

import com.codecool.men.controller.components.NewNote;
import com.codecool.men.controller.components.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Repository
public class NoteDaoImpl implements NoteDAO {
  private List<Note> notes;
  private Random random;

  public NoteDaoImpl() {
    this.notes = new ArrayList<>();
    this.random = new Random();
    createNotes();
  }

  @Override
  public List<Note> getAllNotes(int userId) {
    return notes.stream()
            .filter(note -> note.userId() == userId)
            .toList();
  }

  public Note getNote(int userId, int noteId) {
    return notes.stream()
            .filter(note -> note.userId() == userId && note.id() == noteId)
            .findFirst()
            .orElse(null);
  }

  public boolean deleteNote(int userId, int noteId) {
    notes.removeIf(note -> note.userId() == userId && note.id() == noteId);

    System.out.println(notes);
    return true;
  }

  public Note addNote(int userId, NewNote newNote) {
    Note myNote = new Note(random.nextInt(10000), newNote.title(), newNote.text(), new Date(), userId);
    notes.add(myNote);
    return myNote;
  }

  private void createNotes() {
    notes.add(new Note(1, "Note 1", "This is the text of note 1", new Date(), 1));
    notes.add(new Note(2, "Note 2", "This is the text of note 2", new Date(), 2));
    notes.add(new Note(3, "Note 3", "This is the text of note 3", new Date(), 2));
    notes.add(new Note(4, "Note 4", "This is the text of note 4", new Date(), 3));
    notes.add(new Note(5, "Note 5", "This is the text of note 5", new Date(), 3));
    notes.add(new Note(6, "Note 6", "This is the text of note 6", new Date(), 3));
    notes.add(new Note(7, "Note 7", "This is the text of note 7", new Date(), 4));
    notes.add(new Note(8, "Note 8", "This is the text of note 8", new Date(), 4));
    notes.add(new Note(9, "Note 9", "This is the text of note 9", new Date(), 4));
    notes.add(new Note(10, "Note 10", "This is the text of note 10", new Date(), 5));
  }
}
