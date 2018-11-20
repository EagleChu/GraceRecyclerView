package com.mizi.lib.rv.gson;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.util.SparseIntArray;

import com.mizi.lib.rv.ItemData;
import com.mizi.lib.rv.ItemEntity;

import java.util.ArrayList;
import java.util.List;


public abstract class CommonAdapter extends GsonAdapter<ItemEntity> {

    @Override
    public void onBindViewHolder(@NonNull GsonHolder<ItemEntity> holder, int position) {
        if (holder instanceof CommonHolder) {
            bindView((CommonHolder) holder);
        } else {
            super.onBindViewHolder(holder, position);
        }
    }

    public abstract void bindView(CommonHolder holder);
}
