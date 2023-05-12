package com.ifsc.notepad.Model;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NoteDAO {

    SQLiteDatabase db;

    public Boolean registerNote(Note note){
        return false;
    }

    public Boolean refreshNote(Note note){
        return false;
    }

    public Boolean deleteNote(Note note){
        return false;
    }

    public Note getNote(Integer Id) {
        return null;
    }

    public ArrayList<Note> getListNotes(){
        return null;
    }

}
