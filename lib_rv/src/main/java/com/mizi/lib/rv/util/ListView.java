package com.mizi.lib.rv.util;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ListView extends BaseSetup {

    private int orientation;
    public ListView(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override
    public BaseSetup setup() {
        layoutManager = getLinearManager();
        recyclerView.setLayoutManager(layoutManager);
        return this;
    }

    public ListView vertical() {
        orientation = LinearLayoutManager.VERTICAL;
        return this;
    }

    public ListView horizontal() {
        orientation = LinearLayoutManager.HORIZONTAL;
        return this;
    }


    private RecyclerView.LayoutManager getLinearManager() {
        return new LinearLayoutManager(recyclerView.getContext(), orientation, false);
    }
}
