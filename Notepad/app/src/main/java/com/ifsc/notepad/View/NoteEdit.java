package com.ifsc.notepad.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ifsc.notepad.Controll.NoteController;
import com.ifsc.notepad.Model.Note;
import com.ifsc.notepad.R;

public class NoteEdit extends AppCompatActivity {
    private EditText title, content;
    private Button saveButton;

    private NoteController noteController;
    private Note note;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_edit);

        getSupportActionBar().setTitle("Bloco de Notas");

        noteController = new NoteController(this);
        title = findViewById(R.id.txtTitle);
        content = findViewById(R.id.txtContent);
        saveButton = findViewById(R.id.btnSave);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("note_id")) {
            int noteId = extras.getInt("note_id");
            note = noteController.getNote(noteId);

            title.setText(note.getTitle());
            content.setText(note.getContent());
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Atualize ou insira a nota, conforme necessário
                String titleText = title.getText().toString();
                String contentText = content.getText().toString();

                if (note != null) {
                    note.setTitle(titleText);
                    note.setContent(contentText);
                    noteController.updateNote(note);
                } else {
                    Note newNote = new Note(titleText, contentText);
                    noteController.insertNote(newNote);
                }

                finish();
            }
        });
    }
}
