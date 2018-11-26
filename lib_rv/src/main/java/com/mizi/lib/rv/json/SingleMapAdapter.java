package com.mizi.lib.rv.json;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mizi.lib.rv.builder.SingleBuilder;
import com.mizi.lib.rv.event.EventAdapter;

import java.util.List;
import java.util.Map;

public class SingleMapAdapter extends EventAdapter<Map, SingleMapHolder, SingleMapAdapter.Builder> {

    public SingleMapAdapter() {
    }

    public SingleMapAdapter(List<Map> maps) {
        super(maps);
    }

    @NonNull
    @Override
    public SingleMapHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SingleMapHolder(parent, builder, builder.getKeys());
    }

    public static class Builder extends SingleBuilder<Builder> {

        private String[] keys;

        public Builder setKeys(String... keys) {
            this.keys = keys;
            return this;
        }

        public String[] getKeys() {
            return keys;
        }

        public SingleMapAdapter build() {
            SingleMapAdapter adapter = new SingleMapAdapter();
            adapter.setBuilder(this);
            return adapter;
        }
    }
}
