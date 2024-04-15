package com.codecool.men.controller;

import com.codecool.men.controller.components.Note;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

  @GetMapping("/all")
  public List<Note> getAllNotes() {
    throw new RuntimeException();
  }

  @GetMapping("/{id}")
  public Note getNote(RequestParam id) {
    throw new RuntimeException();
  }

  @GetMapping("/delete/{id}")
  public boolean deleteNote(RequestParam id) {
    throw new RuntimeException();
  }

  @GetMapping("/add")
  public Note addNote() {
    throw new RuntimeException();
  }


}
