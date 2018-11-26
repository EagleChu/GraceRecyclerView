package com.mizi.lib.rv.json;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.mizi.lib.rv.builder.MultipleBuilder;
import com.mizi.lib.rv.json.data.MapData;
import com.mizi.lib.rv.type.MultipleAdapter;

public class MultipleMapAdapter extends MultipleAdapter<MapData, MultipleMapHolder, MultipleMapAdapter.Builder> {

    @NonNull
    @Override
    public MultipleMapHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MultipleMapHolder(parent, viewType, builder).setKey(builder.getKeys(viewType));
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

        public MultipleMapAdapter build() {
            MultipleMapAdapter adapter = new MultipleMapAdapter();
            adapter.setBuilder(this);
            return adapter;
        }
    }
}
