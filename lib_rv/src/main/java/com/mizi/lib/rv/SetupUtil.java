package com.mizi.lib.rv;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.google.android.flexbox.FlexboxLayoutManager;


public class SetupUtil {
    private RecyclerView recyclerView;
    private BaseAdapter adapter;

    private int itemMargin = -1;
    private int spanCount = -1;
    private LayoutType layoutType;

    public SetupUtil(RecyclerView view) {
        this.recyclerView = view;
    }

    public SetupUtil setSpanCount(int spanCount) {
        this.spanCount = spanCount;
        return this;
    }

    public SetupUtil setLayoutType(LayoutType layoutType) {
        this.layoutType = layoutType;
        return this;
    }

    public SetupUtil setup() {
        RecyclerView.LayoutManager layoutManager = null;
        switch (layoutType) {
            case List_V:
                layoutManager = getLinearManager(LinearLayoutManager.VERTICAL);
                break;
            case List_H:
                layoutManager = getLinearManager(LinearLayoutManager.HORIZONTAL);
                break;
            case Grid_V:
                layoutManager = getGridManager(GridLayoutManager.VERTICAL);
                break;
            case Gird_H:
                layoutManager = getGridManager(GridLayoutManager.HORIZONTAL);
                break;
            case Stag_V:
                layoutManager = getStaggeredManager(StaggeredGridLayoutManager.HORIZONTAL);
                break;
            case Stag_H:
                layoutManager = getStaggeredManager(StaggeredGridLayoutManager.VERTICAL);
                break;
            case Flex_Box:
                layoutManager = getFlexManager();
        }
        recyclerView.setLayoutManager(layoutManager);
        return this;
    }

    public SetupUtil hasFixedSize() {
        recyclerView.setHasFixedSize(true);
        return this;
    }

    public <T extends BaseAdapter> void setAdapter(T adapter) {
        this.adapter = adapter;
        recyclerView.setAdapter(adapter);
    }

    private RecyclerView.LayoutManager getLinearManager(int orientation) {

        return new LinearLayoutManager(recyclerView.getContext(), orientation, false);
    }

    private RecyclerView.LayoutManager getGridManager(int orientation) {
        return new GridLayoutManager(recyclerView.getContext(), spanCount, orientation, false);
    }

    private RecyclerView.LayoutManager getStaggeredManager(int orientation) {
        return new StaggeredGridLayoutManager(spanCount, orientation);
    }

    private RecyclerView.LayoutManager getFlexManager(){
        return  new FlexboxLayoutManager(recyclerView.getContext());

    }

    public enum LayoutType {
        List_V, // LinearLayoutManager.VERTICAL
        List_H, // LinearLayoutManager.HORIZONTAL
        Grid_V, // GridLayoutManager.VERTICAL
        Gird_H, // GridLayoutManager.HORIZONTAL
        Stag_V, // StaggeredGridLayoutManager.VERTICAL
        Stag_H,  // StaggeredGridLayoutManager.HORIZONTAL
        Flex_Box
    }

}
