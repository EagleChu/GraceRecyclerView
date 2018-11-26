package com.mizi.lib.rv.util;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class Stagger extends BaseSetup {

    private int spanCount;
    private int orientation;

    public Stagger(RecyclerView recyclerView) {
        super(recyclerView);
    }

    public Setup vertical() {
        this.orientation = GridLayoutManager.VERTICAL;
        return this;
    }

    public Setup horizontal() {
        this.orientation = GridLayoutManager.HORIZONTAL;
        return this;
    }

    public Stagger setSpanCount(int spanCount) {
        this.spanCount = spanCount;
        return this;
    }

    @Override
    public BaseSetup setup() {
        layoutManager = getStaggeredManager();
        recyclerView.setLayoutManager(layoutManager);
        return this;
    }


    private RecyclerView.LayoutManager getStaggeredManager() {
        return new StaggeredGridLayoutManager(spanCount, orientation);
    }
}
