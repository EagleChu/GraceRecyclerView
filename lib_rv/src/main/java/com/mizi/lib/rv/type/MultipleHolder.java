package com.mizi.lib.rv.type;

import android.view.ViewGroup;

import com.mizi.lib.rv.builder.MultipleBuilder;
import com.mizi.lib.rv.event.EventHolder;

public abstract class MultipleHolder<Data> extends EventHolder<Data> {

    public MultipleHolder(ViewGroup parent, int resId, MultipleBuilder builder) {
        super(parent, resId);
        this.bindTo = builder.getBindTo(resId);
        if (builder.getClickListener(resId) != null) {
            setClickListener(builder.getClickListener(resId), builder.getEventTo(resId));
        }
        if (builder.getEventInitialer(resId) != null) {
            setEventInitializer(builder.getEventInitialer(resId));
        }
    }

}
