package com.ifsc.notepad.Controll;

import android.content.Context;

import com.ifsc.notepad.Model.Note;

import java.util.ArrayList;

public class NoteController {

    private NoteDAO FDAONote;

    public NoteController(Context context) {
        this.FDAONote = new NoteDAO(context);
    }

    public Boolean insertNote(Note note) {
        return FDAONote.insertNote(note);
    }

    public Boolean updateNote(Note note){
        return FDAONote.updateNote(note);
    }

    public Boolean deleteNote(Integer note){
        return FDAONote.deleteNote(note);
    }

    public Note getNote(Integer id) {
        return FDAONote.getNote(id);
    }

    public ArrayList<Note> getListNotes(){
        return (ArrayList<Note>) FDAONote.getListNotes();
    }

    public ArrayList<Note> getListFilterNotes(String filter){
        return (ArrayList<Note>) FDAONote.getListFilterNotes(filter);
    }

}
