package com.mizi.lib.rv.gson;

import android.support.annotation.NonNull;

public abstract class SimpleAdapter extends GsonAdapter<SimpleData> {

    @Override
    public void onBindViewHolder(@NonNull GsonHolder<SimpleData> holder, int position) {
        if (holder instanceof SimpleHolder) {
            bindView((SimpleHolder) holder);
        } else {
            super.onBindViewHolder(holder, position);
        }
    }

    public abstract void bindView(SimpleHolder holder);

}


