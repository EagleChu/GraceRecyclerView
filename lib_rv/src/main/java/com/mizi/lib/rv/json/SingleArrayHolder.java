package com.mizi.lib.rv.json;

import android.view.View;
import android.view.ViewGroup;

import com.mizi.lib.rv.builder.SingleBuilder;
import com.mizi.lib.rv.type.SingleHolder;


public class SingleArrayHolder extends SingleHolder<String> {


    public SingleArrayHolder(ViewGroup parent, SingleBuilder builder) {
        super(parent, builder);
    }

    @Override
    protected void bindView(String itemData) {
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
                bindDataToView(v, itemData);
            }
        }
    }

}
