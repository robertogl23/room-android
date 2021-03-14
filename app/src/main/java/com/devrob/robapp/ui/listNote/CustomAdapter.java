package com.devrob.robapp.ui.listNote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.devrob.robapp.R;
import com.devrob.robapp.room.entity.NoteEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter implements Filterable {
    public Context ctx;
    public List<NoteEntity> noteList = new ArrayList<>();

    public CustomAdapter(Context ctx, List<NoteEntity> noteList) {
        this.ctx = ctx;
        this.noteList = noteList;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtVTitle;
        if(convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_list,null);
        }

        NoteEntity note = noteList.get(position);
        txtVTitle = convertView.findViewById(R.id.txtVTitle);
        txtVTitle.setText(note.getTitle());
        return convertView;
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };
    }
}
