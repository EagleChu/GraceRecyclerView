package com.mizi.lib.rv.util;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class GridView extends BaseSetup {

    private int spanCount;
    private int orientation;

    public GridView(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @Override
    public BaseSetup setup() {
        layoutManager = getGridManager();
        recyclerView.setLayoutManager(layoutManager);
        return this;
    }

    public Setup vertical() {
        this.orientation = GridLayoutManager.VERTICAL;
        return this;
    }

    public Setup horizontal() {
        this.orientation = GridLayoutManager.HORIZONTAL;
        return this;
    }

    public GridView setSpanCount(int spanCount){
        this.spanCount = spanCount;
        return this;
    }

    private RecyclerView.LayoutManager getGridManager() {
        return new GridLayoutManager(recyclerView.getContext(), spanCount, orientation, false);
    }
}
