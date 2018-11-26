package com.mizi.lib.rv.json;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mizi.lib.rv.builder.SingleBuilder;
import com.mizi.lib.rv.event.EventAdapter;

public class SingleArrayAdapter extends EventAdapter<String, SingleArrayHolder, SingleArrayAdapter.Builder> {

    @NonNull
    @Override
    public SingleArrayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SingleArrayHolder(parent, builder);
    }

    public static class Builder extends SingleBuilder<Builder> {

        public SingleArrayAdapter build() {
            SingleArrayAdapter adapter = new SingleArrayAdapter();
            adapter.setBuilder(this);
            return adapter;
        }
    }
}
