package com.ifsc.notepad.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.ifsc.notepad.Controll.NoteController;
import com.ifsc.notepad.Model.Note;
import com.ifsc.notepad.R;

public class NoteEdit extends AppCompatActivity {

    // Componentes
    private EditText title, content;
    private Button   saveButton;

    // Objetos - Nota
    private NoteController FNoteController;
    private Note note;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_edit);

        getSupportActionBar().setTitle("Bloco de Notas");

        FNoteController = new NoteController(getApplicationContext());
        title = findViewById(R.id.txtTitle);
        content = findViewById(R.id.txtContent);
        saveButton = findViewById(R.id.btnSave);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note = new Note(
                        String.valueOf(title.getText()),
                        String.valueOf(content.getText())
                );
                FNoteController.insertNote(note);
            }
        });
    }
}
