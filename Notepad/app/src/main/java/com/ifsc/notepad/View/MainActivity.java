package com.ifsc.notepad.View;

import android.content.Intent;
import android.service.controls.actions.FloatAction;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.ifsc.notepad.Model.Note;
import com.ifsc.notepad.R;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton btnAddNote;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Bloco de Notas");

        btnAddNote = findViewById(R.id.btnAddNote);
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNote(view, null);
            }
        });

        listView = findViewById(R.id.listNote);

    }

    public void openNote(View v, Note note){
        Intent i = new Intent(this, NoteEdit.class);
        startActivity(i);
    }

}