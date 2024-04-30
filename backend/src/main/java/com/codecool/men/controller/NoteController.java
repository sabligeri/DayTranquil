package com.codecool.men.controller;

import com.codecool.men.controller.dto.note.NewNoteDTO;
import com.codecool.men.controller.dto.note.NoteDTO;
import com.codecool.men.repository.model.Note;
import com.codecool.men.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/note/{userId}")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/all")
    public List<NoteDTO> getAllNotes(@PathVariable int userId) {
        return noteService.getAllNotes(userId);
    }

    @GetMapping("/{noteId}")
    public NoteDTO getNote(@PathVariable int userId, @PathVariable int noteId) {
        return noteService.getNote(userId, noteId);
    }

    @DeleteMapping("/delete/{noteId}")
    public boolean deleteNote(@PathVariable int userId, @PathVariable int noteId) {
        return noteService.deleteNote(userId, noteId);
    }

    @PostMapping("/add")
    public NoteDTO addNote( @RequestBody NewNoteDTO newNoteDTO) {
        return noteService.addNote(newNoteDTO);
    }


}
