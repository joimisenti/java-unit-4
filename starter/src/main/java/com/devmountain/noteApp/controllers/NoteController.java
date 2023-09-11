package com.devmountain.noteApp.controllers;

import com.devmountain.noteApp.dtos.NoteDto;
import com.devmountain.noteApp.entities.Note;
import com.devmountain.noteApp.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    // A method that will send a GET request to get all Notes by User

    @GetMapping("/user/{userId}")
    public List<NoteDto> getNotesByUser(@PathVariable Long userId) {
        return noteService.getAllNotesByUserId(userId);
    }

    // A method that will handle POST request to add a new Note
    @PostMapping
    public void addNote(@RequestBody NoteDto noteDto,@PathVariable Long userId) {
        noteService.addNote(noteDto, userId);
    }

    // A method that will handle DELETE request to delete a Note
    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId) {
        noteService.deleteNoteById(noteId);
    }

    // A method that will handle PUT request to update an existing Note
    @PutMapping
    public void updateNote(@RequestBody NoteDto noteDto) {
        noteService.updateNotebyId(noteDto);
    }

    // A method that will GET a Note by the Note ID
    @GetMapping
    public Optional<NoteDto> getNoteById(@PathVariable Long noteId) {
        return noteService.getNoteById(noteId);
    }
}
