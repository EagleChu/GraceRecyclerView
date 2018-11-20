package com.mizi.lib.rv.json;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.mizi.lib.rv.EventHolder;
import com.mizi.lib.rv.event.Event;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonHolder extends EventHolder<JSONObject> {

    String[] key;
    int[] to;

    public JsonHolder(ViewGroup parent, int resId, SparseArray<String> idsAndKeys) {
        super(parent, resId);
        initIdsAndKeys(idsAndKeys);
    }

    public JsonHolder(ViewGroup parent, int resId, SparseArray<String> idsAndKeys, Event initializer) {
        super(parent, resId, initializer);
        initIdsAndKeys(idsAndKeys);
    }

    private void initIdsAndKeys(SparseArray<String> idsAndKeys) {
        int length = idsAndKeys.size();
        key = new String[length];
        to = new int[length];
        for (int i = 0; i < length; i++) {
            key[i] = idsAndKeys.valueAt(i);
            to[i] = idsAndKeys.keyAt(i);
        }
    }

    /**
     * 此方法必须和 setTo 方法配套使用,
     * 也可以直接调用 setKeyAndTo 方法
     *
     * @param key JSonObject 的 Key 集合
     * @return JsonHolder
     */
    public JsonHolder setKey(String... key) {
        this.key = key;
        return this;
    }

    /**
     * 此方法必须和 setKey 方法配套使用,
     * 也可以直接调用 setKeyAndTo 方法
     *
     * @param to 目标 View 的 Id 集合
     * @return JsonHolder
     */
    public JsonHolder setTo(int... to) {
        this.to = to;
        return this;
    }

    /**
     * 建议在 Adapter 的 onCreateViewHolder 中调用此方法
     *
     * @param key JSonObject 的 Key 集合
     * @param to  目标 View 的 Id 集合
     * @return JsonHolder
     */
    public JsonHolder setKeyAndTo(String[] key, int[] to) {
        this.key = key;
        this.to = to;
        return this;
    }

    @Override
    public void bindView() {
        if (key == null || to == null || itemData == null) {
            return;
        }

        if (key.length != to.length) {
            return;
        }

        try {
            for (int i = 0; i < to.length; i++) {
                final View view = findView(to[i]);
                if (view != null) {
                    final Object data = itemData.get(key[i]);
                    bindViewByData(view, data);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
