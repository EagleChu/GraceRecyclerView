package com.mizi.lib.rv.json;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mizi.lib.rv.EventAdapter;
import com.mizi.lib.rv.event.Event;

import java.util.List;

public class ArrayAdapter extends EventAdapter<String[], ArrayHolder> {

    int[] to;
    Event initializer;

    public ArrayAdapter(List<String[]> from, int... to) {
        super(from);
        this.to = to;
    }

    public ArrayAdapter(Event initializer, List<String[]> from, int... to) {
        super(from);
        this.to = to;
    }

    @NonNull
    @Override
    public ArrayHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        if (initializer != null){
            return new ArrayHolder(parent,position,initializer,to);
        }else {
            return new ArrayHolder(parent, position, to);
        }
    }

}
