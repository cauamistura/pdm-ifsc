package com.ifsc.notepad.Model;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ifsc.notepad.R;

import java.util.List;

public class NoteAdapter extends ArrayAdapter {

    Context context;
    List<ApplicationInfo> notes;
    int resouceLayout;


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resouceLayout, parent, false);

        TextView textView   =  convertView.findViewById(R.id.visibleTitle);

        ApplicationInfo app = notes.get(position);
        textView.setText(app.loadLabel(context.getPackageManager()));

        return convertView;
    }

    public NoteAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List objects) {
        super(context, resource, textViewResourceId, objects);

        this.context       = context;
        this.notes         = objects;
        this.resouceLayout = resource;
    }
}
