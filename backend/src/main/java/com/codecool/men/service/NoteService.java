package com.codecool.men.service;

import com.codecool.men.repository.NoteRepository;
import com.codecool.men.controller.dto.NewNoteDTO;
import com.codecool.men.repository.UserRepository;
import com.codecool.men.repository.model.Note;
import com.codecool.men.repository.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.MissingResourceException;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public List<Note> getAllNotes(long userId) {
        return noteRepository.findByUserId(userId);
    }

    public Note getNote(long userId, long noteId) {
        return noteRepository.findByIdAndUserId(noteId, userId);
    }

    public boolean deleteNote(long userId, long noteId) {
        Note note = noteRepository.findByIdAndUserId(noteId, userId);
        if (note != null) {
            noteRepository.delete(note);
            return true;
        }
        return false;
    }

    public Note addNote(NewNoteDTO newNoteDTO) {
        User user = userRepository
                .findById(newNoteDTO.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Note note = new Note();
        note.setTitle(newNoteDTO.title());
        note.setText(newNoteDTO.text());
        note.setDate(LocalDate.now());
        note.setUser(user);
        return noteRepository.save(note);
    }
}
