package com.mizi.lib.rv.json;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.mizi.lib.rv.builder.MultipleBuilder;
import com.mizi.lib.rv.json.data.JsonData;
import com.mizi.lib.rv.type.MultipleAdapter;

public class MultipleJSONAdapter extends MultipleAdapter<JsonData, MultipleJSONHolder, MultipleJSONAdapter.Builder> {

    @NonNull
    @Override
    public MultipleJSONHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MultipleJSONHolder(parent, viewType, builder)
                .setKey(builder.getKeys(viewType));
    }

    public static class Builder extends MultipleBuilder<Builder> {
        private SparseArray<String[]> keys;

        public Builder addKeys(int viewType, String... keys) {
            if (this.keys == null) {
                this.keys = new SparseArray<>();
            }
            this.keys.put(viewType, keys);
            return this;
        }

        public String[] getKeys(int viewType) {
            return keys.get(viewType);
        }

        public MultipleJSONAdapter build() {
            MultipleJSONAdapter adapter = new MultipleJSONAdapter();
            adapter.setBuilder(this);
            return adapter;
        }
    }
}
