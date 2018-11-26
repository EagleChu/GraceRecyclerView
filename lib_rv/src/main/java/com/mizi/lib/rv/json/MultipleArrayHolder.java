package com.mizi.lib.rv.json;

import android.view.View;
import android.view.ViewGroup;

import com.mizi.lib.rv.builder.MultipleBuilder;
import com.mizi.lib.rv.json.data.StringData;
import com.mizi.lib.rv.type.MultipleHolder;

public class MultipleArrayHolder extends MultipleHolder<StringData> {
    public MultipleArrayHolder(ViewGroup parent, int viewType, MultipleBuilder builder) {
        super(parent, builder.getLayoutResId(viewType), builder);
    }

    @Override
    protected void bindView(StringData itemData) {
        super.bindView(itemData);
        if (bindTo == null || itemData == null) {
            return;
        }
        if (bindTo == null || bindTo.length <= 0) {
            return;
        }
        for (int i = 0; i < bindTo.length; i++) {
            final View v = itemView.findViewById(bindTo[i]);
            if (v != null) {
                bindDataToView(v, itemData.data);
            }
        }
    }
}
