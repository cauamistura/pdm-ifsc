package com.ifsc.notepad.Controll;

import com.ifsc.notepad.Model.Note;
import com.ifsc.notepad.Model.NoteDAO;

import java.util.ArrayList;

public class NoteController {

    public NoteController() {
        if (FDAONote == null){
            FDAONote = new NoteDAO();
        }
    }

    NoteDAO FDAONote;

    public Boolean registerNote(Note note) {
        return FDAONote.registerNote(note);
    }

    public Boolean refreshNote(Note note){
        return FDAONote.refreshNote(note);
    }

    public Boolean deleteNote(Note note){
        return FDAONote.deleteNote(note);
    }

    public Note getNote(Integer id) {
        return FDAONote.getNote(id);
    }

    public ArrayList<Note> getListNotes(){
        return FDAONote.getListNotes();
    }

}
