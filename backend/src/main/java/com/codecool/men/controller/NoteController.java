package com.codecool.men.controller;

import com.codecool.men.controller.components.NewNote;
import com.codecool.men.controller.components.Note;
import com.codecool.men.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note/{userId}")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/all")
    public List<Note> getAllNotes(@RequestParam int userId) {
        return noteService.getAllNotes(userId);
    }

    @GetMapping("/{noteId}")
    public Note getNote(@RequestParam int userId, @RequestParam int noteId) {
        return noteService.getNote(userId, noteId);
    }

    @DeleteMapping("/delete/{noteId}")
    public boolean deleteNote(@RequestParam int userId, @RequestParam int noteId) {
        return noteService.deleteNote(userId, noteId);
    }

    @PostMapping("/add")
    public Note addNote(@RequestParam int userId, @RequestBody NewNote newNote) {
        return noteService.addNote(userId, newNote);
    }


}
