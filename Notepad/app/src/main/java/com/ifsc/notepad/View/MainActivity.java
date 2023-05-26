package com.ifsc.notepad.View;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.service.controls.actions.FloatAction;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.ifsc.notepad.Model.Note;
import com.ifsc.notepad.Model.NoteAdapter;
import com.ifsc.notepad.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton btnAddNote;
    private ListView listView;
    private PackageManager pm;

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


        // Iniciando Lista de notas
//        ArrayList<Note> Notes = new ArrayList<>();
//        List<Note> apps =
//        for (ApplicationInfo app : apps) {
//            appsNames.add(app.loadLabel(pm).toString());
//        }

        listView = findViewById(R.id.listNote);

//        NoteAdapter adapterPersonalizado = new NoteAdapter(this, R.layout.list_note, null);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ApplicationInfo applicationInfo = (ApplicationInfo) adapterView.getItemAtPosition(i);
                String packageName = applicationInfo.packageName;
                Toast.makeText(MainActivity.this, "Abrindo o nota", Toast.LENGTH_SHORT).show();

                Intent intent = pm.getLaunchIntentForPackage(packageName);
                if (intent != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Não foi possível abrir abrir a nota", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Setando o adapter
//        list.setAdapter(adapterPersonalizado);

    }

    public void openNote(View v, Note note){
        Intent i = new Intent(this, NoteEdit.class);
        startActivity(i);
    }

}