package com.codecool.men.service;

import com.codecool.men.controller.dto.note.NoteDTO;
import com.codecool.men.controller.exceptions.OperationFailedException;
import com.codecool.men.controller.exceptions.UserNotFoundException;
import com.codecool.men.repository.NoteRepository;
import com.codecool.men.controller.dto.note.NewNoteDTO;
import com.codecool.men.repository.UserRepository;
import com.codecool.men.repository.model.Note;
import com.codecool.men.repository.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
  private final NoteRepository noteRepository;
  private final UserRepository userRepository;

  public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
    this.noteRepository = noteRepository;
    this.userRepository = userRepository;
  }

  public List<NoteDTO> getAllNotes(long userId) {
    List<Note> notes = noteRepository.findByUserId(userId);
    List<NoteDTO> noteDTOS = new ArrayList<>();
    notes.stream().map(note -> noteDTOS.add(new NoteDTO(note.getTitle(), note.getText())));
    return noteDTOS;
  }

  public NoteDTO getNote(long userId, long noteId) {
    Note note = noteRepository.findByIdAndUserId(noteId, userId);
    if(note == null){
        throw new OperationFailedException();
    }
    return new NoteDTO(note.getTitle(), note.getText());
  }

  public boolean deleteNote(long userId, long noteId) {
    Note note = noteRepository.findByIdAndUserId(noteId, userId);
    if (note != null) {
      noteRepository.delete(note);
      return true;
    }
    throw new OperationFailedException();
  }

  public NoteDTO addNote(NewNoteDTO newNoteDTO) {
    User user = userRepository
            .findById(newNoteDTO.userId())
            .orElseThrow(UserNotFoundException::new);
    Note note = new Note();
    note.setTitle(newNoteDTO.title());
    note.setText(newNoteDTO.text());
    note.setDate(LocalDate.now());
    note.setUser(user);
    noteRepository.save(note);
    return new NoteDTO(newNoteDTO.title(), newNoteDTO.text());
  }
}
