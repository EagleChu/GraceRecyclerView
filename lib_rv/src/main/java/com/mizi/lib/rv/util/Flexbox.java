package com.mizi.lib.rv.util;

import android.support.v7.widget.RecyclerView;

import com.google.android.flexbox.FlexboxLayoutManager;

public class Flexbox extends BaseSetup {
    public Flexbox(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override
    public BaseSetup setup() {
        layoutManager = new FlexboxLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        return this;
    }

}
