package com.codecool.men.controller;

import com.codecool.men.controller.components.NewNote;
import com.codecool.men.controller.components.Note;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note/{userId}")
public class NoteController {

  @GetMapping("/all")
  public List<Note> getAllNotes(@RequestParam int  userId) {
    throw new RuntimeException();
  }

  @GetMapping("/{noteId}")
  public Note getNote(@RequestParam int  userId, @RequestParam int  noteId) {
    throw new RuntimeException();
  }

  @GetMapping("/delete/{noteId}")
  public boolean deleteNote(@RequestParam int  userId, @RequestParam int  noteId) {
    throw new RuntimeException();
  }

    @GetMapping("/add")
    public Note addNote(@RequestParam int userId, @RequestBody NewNote newNote) {
      throw new RuntimeException();
    }


}
