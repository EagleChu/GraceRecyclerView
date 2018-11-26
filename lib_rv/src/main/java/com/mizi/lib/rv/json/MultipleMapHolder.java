package com.mizi.lib.rv.json;

import android.view.View;
import android.view.ViewGroup;

import com.mizi.lib.rv.builder.MultipleBuilder;
import com.mizi.lib.rv.json.data.MapData;
import com.mizi.lib.rv.type.MultipleHolder;

public class MultipleMapHolder extends MultipleHolder<MapData> {

    public MultipleMapHolder(ViewGroup parent, int viewType, MultipleBuilder builder) {
        super(parent, builder.getLayoutResId(viewType), builder);
    }

    private String[] keys;

    /**
     * @param keys Map 的 Key 集合
     * @return SingleJSONHolder
     */
    public MultipleMapHolder setKey(String... keys) {
        this.keys = keys;
        return this;
    }

    @Override
    protected void bindView(MapData itemData) {
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
                final Object o = itemData.data.get(keys[i]);
                bindDataToView(view, o);
            }
        }
    }

}
