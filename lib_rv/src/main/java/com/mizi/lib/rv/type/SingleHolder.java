package com.mizi.lib.rv.type;

import android.view.ViewGroup;

import com.mizi.lib.rv.builder.SingleBuilder;
import com.mizi.lib.rv.event.EventHolder;

public abstract class SingleHolder<Data> extends EventHolder<Data> {

    public SingleHolder(ViewGroup parent, SingleBuilder builder) {
        super(parent, builder.getLayoutResId());
        bindTo = builder.getBindTo();
        if (builder.getClickListener() != null) {
            setClickListener(builder.getClickListener(), builder.getEventTo());
        }
        if (builder.getEventInitialer() != null) {
            setEventInitializer(builder.getEventInitialer());
        }
    }

}
