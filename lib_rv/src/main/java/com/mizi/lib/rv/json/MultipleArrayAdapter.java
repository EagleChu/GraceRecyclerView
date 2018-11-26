package com.mizi.lib.rv.json;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mizi.lib.rv.builder.MultipleBuilder;
import com.mizi.lib.rv.json.data.StringData;
import com.mizi.lib.rv.type.MultipleAdapter;
import com.mizi.lib.rv.type.MultipleHolder;

public class MultipleArrayAdapter extends MultipleAdapter<StringData,MultipleHolder<StringData>,MultipleArrayAdapter.Builder> {

    @NonNull
    @Override
    public MultipleHolder<StringData> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MultipleArrayHolder(parent,viewType,builder);
    }

    public static class Builder extends MultipleBuilder<Builder>{

    }
}
