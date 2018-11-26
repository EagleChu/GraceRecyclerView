package com.mizi.lib.rv.builder;

import android.support.annotation.LayoutRes;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;

import com.mizi.lib.rv.event.EventInitialer;

public abstract class MultipleBuilder<MB extends MultipleBuilder> extends AdapterBuilder {
    private SparseIntArray itemViewIdAndTypeArray = new SparseIntArray();
    private SparseArray<int[]> bindToArray;
    private SparseArray<int[]> eventToArray;
    private SparseArray<View.OnClickListener> clickArray;
    private SparseArray<EventInitialer> eventArray;

    public MB addItemViewIdAsType(@LayoutRes int layoutResId) {
        itemViewIdAndTypeArray.put(layoutResId, layoutResId);
        return (MB) this;
    }

    public MB addItemViewIdAsTypeAndItemClickListener(@LayoutRes int layoutResId, View.OnClickListener listener) {
        itemViewIdAndTypeArray.put(layoutResId, layoutResId);
        this.addItemClickListener(layoutResId, listener);
        return (MB) this;
    }

    public MB addItemViewIdAsTypeAndClickListener(@LayoutRes int layoutResId, View.OnClickListener listener, int... viewIds) {
        itemViewIdAndTypeArray.put(layoutResId, layoutResId);
        this.addClickListener(layoutResId, listener, viewIds);
        return (MB) this;
    }

    public MB addBindTo(int itemType, int... viewId) {
        if (bindToArray == null) {
            bindToArray = new SparseArray<>();
        }
        bindToArray.put(itemType, viewId);
        return (MB) this;
    }

    public MB addItemClickListener(int itemType, View.OnClickListener listener) {
        this.setClickListener(itemType, listener);
        return (MB) this;
    }

    public MB addClickListener(int itemType, View.OnClickListener listener, int... viewIds) {
        this.setClickListener(itemType, listener);
        this.addEventTo(itemType, viewIds);
        return (MB) this;
    }

    public MB addEventInitialer(int itemType, EventInitialer initialer) {
        if (eventArray == null) {
            eventArray = new SparseArray<>();
        }
        eventArray.put(itemType, initialer);
        return (MB) this;
    }

    public int getLayoutResId(int itemType) {
        return itemViewIdAndTypeArray.get(itemType);
    }

    public int[] getBindTo(int itemType) {
        if (bindToArray == null){
            return null;
        }
        return bindToArray.get(itemType);
    }

    public int[] getEventTo(int itemType) {
        if (eventToArray == null){
            return null;
        }
        return eventToArray.get(itemType);
    }

    public View.OnClickListener getClickListener(int itemType) {
        if (clickArray == null){
            return null;
        }
        return clickArray.get(itemType);
    }

    public EventInitialer getEventInitialer(int itemType) {
        if (eventArray == null){
            return null;
        }
        return eventArray.get(itemType);
    }

    private MultipleBuilder addItemType(int itemType, @LayoutRes int layoutResId) {
        itemViewIdAndTypeArray.put(itemType, layoutResId);
        return this;
    }

    private void setClickListener(int itemType, View.OnClickListener listener) {
        if (clickArray == null) {
            clickArray = new SparseArray<>();
        }
        clickArray.put(itemType, listener);
    }

    private void addEventTo(int itemType, int... viewIds) {
        if (eventToArray == null) {
            eventToArray = new SparseArray<>();
        }
        eventToArray.put(itemType, viewIds);
    }
}
