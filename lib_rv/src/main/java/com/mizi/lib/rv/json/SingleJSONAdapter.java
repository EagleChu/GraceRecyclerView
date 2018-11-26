package com.mizi.lib.rv.json;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mizi.lib.rv.builder.SingleBuilder;
import com.mizi.lib.rv.event.EventAdapter;

import org.json.JSONObject;

import java.util.List;

public class SingleJSONAdapter extends EventAdapter<JSONObject, SingleJSONHolder, SingleJSONAdapter.Builder> {

    public SingleJSONAdapter() {
    }

    public SingleJSONAdapter(List<JSONObject> jsonObjects) {
        super(jsonObjects);
    }

    @NonNull
    @Override
    public SingleJSONHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SingleJSONHolder(parent, builder, builder.getKeys());
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

        public SingleJSONAdapter build() {
            SingleJSONAdapter adapter = new SingleJSONAdapter();
            adapter.setBuilder(this);
            return adapter;
        }
    }
}
