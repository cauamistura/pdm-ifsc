package com.ifsc.notepad.Model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class NoteDAO {

    private SQLiteDatabase db;
    private static final String DATABASE_NAME = "notepad";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "note";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_TEXT = "text";

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + " (" +COLUMN_TITLE + " VARCHAR, " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TEXT + " VARCHAR)";

    public NoteDAO(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public Boolean insertNote(Note note) {
        ContentValues content = new ContentValues();
        try {

            content.put(COLUMN_ID, note.getId());
            content.put(COLUMN_TITLE, note.getTitle());
            content.put(COLUMN_TEXT, note.getContent());

            this.db.insert(TABLE_NAME, null, content);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateNote(Note note) {
        return false;
    }

    public Boolean deleteNote(Note note) {
        return false;
    }

    public Note getNote(Integer Id) {
        return null;
    }

    public ArrayList<Note> getListNotes() {
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);

        ArrayList<Note> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") Note note = new Note(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_TEXT))
                );
                list.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }


    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_QUERY);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }

    }

}


