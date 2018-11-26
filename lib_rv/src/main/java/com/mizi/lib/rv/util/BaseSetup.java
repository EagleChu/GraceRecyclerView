package com.mizi.lib.rv.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.mizi.lib.rv.BaseAdapter;

public abstract class BaseSetup implements Setup {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Context context;
    public BaseSetup(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        context = recyclerView.getContext();
    }

    public BaseSetup hasFixedSize() {
        recyclerView.setHasFixedSize(true);
        return this;
    }

    public abstract BaseSetup setup();

    public <T extends BaseAdapter> void setAdapter(T adapter) {
        recyclerView.setAdapter(adapter);
    }

}
