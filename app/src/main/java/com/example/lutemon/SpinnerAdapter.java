package com.example.lutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SpinnerAdapter extends BaseAdapter implements android.widget.SpinnerAdapter {
    private Context context;
    private HashMap<Integer, Lutemon> lutemons;

    List<Integer> ids;

    public SpinnerAdapter(Context context, HashMap<Integer, Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
        ids = new ArrayList<Integer>(lutemons.keySet());
    }

    @Override
    public int getCount() {
        return ids.size();
    }

    @Override
    public Lutemon getItem(int position) {
        return lutemons.get(ids.get(position));
    }

    @Override
    public long getItemId(int position) {
        return ids.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.spinner_item_text);
        Lutemon lutemon = lutemons.get(ids.get(position));


        textView.setText(lutemon.getName());

        return convertView;
    }
}

