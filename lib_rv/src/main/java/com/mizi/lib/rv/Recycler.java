package com.mizi.lib.rv;

import android.support.v7.widget.RecyclerView;

import com.mizi.lib.rv.util.Flexbox;
import com.mizi.lib.rv.util.GridView;
import com.mizi.lib.rv.util.ListView;
import com.mizi.lib.rv.util.Stagger;

public class Recycler {

    public static ListView listView(RecyclerView recyclerView) {
        return new ListView(recyclerView);
    }

    public static GridView gridView(RecyclerView recyclerView){
        return new GridView(recyclerView);
    }

    public static Stagger staggeredGrid(RecyclerView recyclerView){
        return new Stagger(recyclerView);
    }

    public static Flexbox flexbox(RecyclerView recyclerView){
        return new Flexbox(recyclerView);
    }


}
