package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.NoteDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    // Adding a note
    @Transactional
    void addNote(NoteDto noteDto, Long userId);

    // Deleting a note
    @Transactional
    void deleteNoteById(Long noteId);

    // Updating a note
    @Transactional
    void updateNotebyId(NoteDto noteDto);

    // Finding all notes by a user
    List<NoteDto> getAllNotesByUserId(Long userId);

    // Getting a Note by the Note id
    Optional<NoteDto> getNoteById(Long noteId);
}
