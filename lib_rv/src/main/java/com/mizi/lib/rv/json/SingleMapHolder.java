package com.mizi.lib.rv.json;

import android.view.View;
import android.view.ViewGroup;

import com.mizi.lib.rv.builder.SingleBuilder;
import com.mizi.lib.rv.type.SingleHolder;

import java.util.Map;

public class SingleMapHolder extends SingleHolder<Map<String, Object>> {

    String[] keys;

    public SingleMapHolder(ViewGroup parent, SingleBuilder builder, String... keys) {
        super(parent, builder);
        this.keys = keys;
    }

    /**
     * @param keys Map 的 Key 集合
     * @return SingleJSONHolder
     */
    public SingleMapHolder setKey(String... keys) {
        this.keys = keys;
        return this;
    }

    @Override
    protected void bindView(Map<String, Object> itemData) {
        super.bindView(itemData);
        if (keys == null || bindTo == null || itemData == null) {
            return;
        }

        if (keys.length > bindTo.length) {
            return;
        }

        for (int i = 0; i < keys.length; i++) {
            final View view = findView(bindTo[i]);
            if (view != null) {
                final Object o = itemData.get(keys[i]);
                bindDataToView(view, o);
            }
        }
    }

}
