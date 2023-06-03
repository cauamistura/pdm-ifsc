package com.ifsc.notepad.Controll;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ifsc.notepad.Model.Note;

import java.util.ArrayList;
import java.util.List;

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

    public boolean insertNote(Note note) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, note.getTitle());
        contentValues.put(COLUMN_TEXT, note.getContent());

        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public boolean updateNote(Note note) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, note.getTitle());
        contentValues.put(COLUMN_TEXT, note.getContent());

        String whereClause = COLUMN_ID + " = ?";
        String[] whereArgs = {String.valueOf(note.getId())};

        int rowsAffected = db.update(TABLE_NAME, contentValues, whereClause, whereArgs);
        return rowsAffected > 0;
    }

    public boolean deleteNote(Integer note) {
        String whereClause = COLUMN_ID + " = ?";
        String[] whereArgs = {String.valueOf(note)};

        int rowsAffected = db.delete(TABLE_NAME, whereClause, whereArgs);
        return rowsAffected > 0;
    }

    @SuppressLint("Range")
    public Note getNote(int id) {
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = db.query(TABLE_NAME, null, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            Note note;
            note = new Note(
                    cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_TEXT))
            );
            cursor.close();
            return note;
        }

        cursor.close();
        return null;
    }

    public List<Note> getListNotes() {
        List<Note> noteList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") Note note = new Note(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_TEXT))
                );
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return noteList;
    }

    public List<Note> getListFilterNotes(String filter) {
        List<Note> noteList = new ArrayList<>();

        String selection = COLUMN_TITLE + " LIKE ?";
        String[] selectionArgs = {"%" + filter + "%"};

        Cursor cursor = db.query(TABLE_NAME, null, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") Note note = new Note(
                        cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_TEXT))
                );
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return noteList;
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
