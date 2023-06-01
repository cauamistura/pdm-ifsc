package com.ifsc.notepad.Model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ifsc.notepad.Controll.NoteController;
import com.ifsc.notepad.R;
import com.ifsc.notepad.View.MainActivity;
import com.ifsc.notepad.View.NoteEdit;

import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note> {
    private List<Note> itemList;
    private Context context;

    private NoteController FNoteController;

    public NoteAdapter(Context context, List<Note> itemList) {
        super(context, 0, itemList);
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_note, parent, false);
        }

        Note currentItem = itemList.get(position);

        TextView textView = listItemView.findViewById(R.id.visibleTitle);
        ImageButton editButton = listItemView.findViewById(R.id.editButton);
        ImageButton deleteButton = listItemView.findViewById(R.id.imageButton);

        textView.setText(currentItem.getTitle());

        FNoteController = new NoteController(getContext());

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FNoteController.deleteNote(currentItem.getId());
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NoteEdit.class);
                intent.putExtra("note_id", currentItem.getId());
                getContext().startActivity(intent);
            }
        });


        return listItemView;
    }

}
