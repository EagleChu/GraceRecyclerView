package com.mizi.lib.rv.json;

import android.support.annotation.LayoutRes;
import android.util.SparseIntArray;

import com.mizi.lib.rv.EventAdapter;

import org.json.JSONObject;

public abstract class JsonAdapter extends EventAdapter<JSONObject, JsonHolder> {

    protected SparseIntArray itemTypeAndLayoutResId = new SparseIntArray();

    public void addItemType(int itemType, int resId) {
        itemTypeAndLayoutResId.put(itemType, resId);
    }

    public void addItemType(@LayoutRes int resId) {
        this.addItemType(resId, resId);
    }

}
