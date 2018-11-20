package com.mizi.lib.rv.json;

import android.view.View;
import android.view.ViewGroup;

import com.mizi.lib.rv.EventHolder;
import com.mizi.lib.rv.event.Event;


public class ArrayHolder extends EventHolder<String[]> {

    protected int[] to;

    public ArrayHolder(ViewGroup parent, int layoutResId, int... to) {
        super(parent, layoutResId);
        this.to = to;
    }

    public ArrayHolder(ViewGroup parent, int resId, Event initializer, int... to) {
        super(parent, resId, initializer);
        this.to = to;
    }

    @Override
    protected void bindViewByData(View v, Object data) {
        super.bindViewByData(v, data);
        bindView();
    }

    /**
     * 建议在 Adapter 的 onCreateViewHolder 中调用此方法
     *
     * @param to 目标 View 的 Id 集合
     * @return ArrayHolder
     */
    public ArrayHolder setTo(int... to) {
        this.to = to;
        return this;
    }

    @Override
    public void bindView() {
        if (to == null || itemData == null) {
            return;
        }
        if (to == null || to.length <= 0) {
            return;
        }
        for (int i = 0; i < to.length; i++) {
            final View v = itemView.findViewById(to[i]);
            if (v != null) {
                final Object data = itemData[i];
                bindViewByData(v, data);
            }
        }
    }

}
