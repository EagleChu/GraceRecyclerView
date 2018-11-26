package com.mizi.lib.rv.gson;

import android.view.ViewGroup;

import com.mizi.lib.rv.event.Event;

public class SimpleHolder extends GsonHolder<SimpleData> {

    public SimpleHolder(ViewGroup parent, int resId) {
        super(parent, resId);
    }

    public SimpleHolder(ViewGroup parent, int layoutResId, int[] to) {
        super(parent, layoutResId, to);
    }

    @Override
    public void bindView() {

    }
}
