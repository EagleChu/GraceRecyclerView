package com.mizi.lib.rv.event;

import android.support.annotation.NonNull;

import com.mizi.lib.rv.BaseAdapter;
import com.mizi.lib.rv.builder.AdapterBuilder;

import java.util.List;

public abstract class EventAdapter<Data, Holder extends EventHolder, BB extends AdapterBuilder> extends BaseAdapter<Data, Holder> {
    protected BB builder;

    public EventAdapter() {
    }

    public EventAdapter(List<Data> data) {
        super(data);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    public void setBuilder(BB builder) {
        this.builder = builder;
    }
}
