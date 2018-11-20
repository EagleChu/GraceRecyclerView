package com.mizi.lib.rv.gson;

import android.view.View;
import android.view.ViewGroup;

import com.mizi.lib.rv.EventHolder;
import com.mizi.lib.rv.ItemEntity;
import com.mizi.lib.rv.event.Event;

public abstract class CommonHolder<Entity> extends GsonHolder<ItemEntity<Entity>> {

    private Entity entity;

    public CommonHolder(ViewGroup parent, int layoutResId, int... to) {
        super(parent, layoutResId, to);
    }

    public CommonHolder(ViewGroup parent, int resId, View.OnClickListener listener, int... eventIds) {
        super(parent, resId, listener, eventIds);
    }

    @Override
    protected void bindView(ItemEntity<Entity> itemData) {
        super.bindView(itemData);
        if (itemData != null)
            entity = itemData.entity;
    }
}
