package com.mizi.lib.rv.json;

import android.view.View;
import android.view.ViewGroup;

import com.mizi.lib.rv.builder.MultipleBuilder;
import com.mizi.lib.rv.json.data.JsonData;
import com.mizi.lib.rv.type.MultipleHolder;

import org.json.JSONException;

public class MultipleJSONHolder extends MultipleHolder<JsonData> {
    public MultipleJSONHolder(ViewGroup parent, int viewType, MultipleBuilder builder) {
        super(parent, builder.getLayoutResId(viewType), builder);
    }

    private String[] keys;

    /**
     * @param keys JSONObject 的 Key 集合
     * @return SingleJSONHolder
     */
    public MultipleJSONHolder setKey(String... keys) {
        this.keys = keys;
        return this;
    }

    @Override
    protected void bindView(JsonData itemData) {
        super.bindView(itemData);
        if (keys == null || bindTo == null || itemData == null) {
            return;
        }

        if (keys.length > bindTo.length) {
            return;
        }

        try {
            for (int i = 0; i < keys.length; i++) {
                final View view = findView(bindTo[i]);
                if (view != null) {
                    final Object o = itemData.data.get(keys[i]);
                    bindDataToView(view, o);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
