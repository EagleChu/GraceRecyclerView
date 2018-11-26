package com.mizi.lib.rv.type;

import com.mizi.lib.rv.builder.SingleBuilder;
import com.mizi.lib.rv.event.EventAdapter;

import java.util.List;

public abstract class SingleAdapter<Data> extends EventAdapter<Data, SingleHolder, SingleBuilder> {

    public SingleAdapter() {
    }

    public SingleAdapter(List<Data> data) {
        super(data);
    }
}
