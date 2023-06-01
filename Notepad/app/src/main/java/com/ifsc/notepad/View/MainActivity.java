package com.ifsc.notepad.View;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.ifsc.notepad.Controll.NoteController;
import com.ifsc.notepad.Model.Note;
import com.ifsc.notepad.Model.NoteAdapter;
import com.ifsc.notepad.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Bloco de Notas");

        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listNote);

        NoteController FNoteController = new NoteController(this);
        List<Note> itemList = FNoteController.getListNotes();

        adapter = new NoteAdapter(this, itemList);

        listView.setAdapter(adapter);

        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNote();
            }
        });

    }

    private void openNote() {
        Intent intent = new Intent(MainActivity.this, NoteEdit.class);
        startActivity(intent);
    }
}
