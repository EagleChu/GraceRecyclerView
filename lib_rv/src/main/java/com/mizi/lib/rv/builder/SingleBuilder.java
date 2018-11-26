package com.mizi.lib.rv.builder;

import android.view.View;

import com.mizi.lib.rv.event.EventInitialer;

public abstract class SingleBuilder<B extends SingleBuilder> extends AdapterBuilder {
    private int singleResId;
    private int[] bindTo;
    private int[] eventTo;
    private View.OnClickListener clickListener;
    private EventInitialer initializer;

    public int getLayoutResId() {
        return singleResId;
    }

    public B setSingleResId(int singleResId) {
        this.singleResId = singleResId;
        return (B) this;
    }

    public B setBindTo(int... bindTo) {
        this.bindTo = bindTo;
        return (B) this;
    }

    public B setItemClickListener(View.OnClickListener listener) {
        this.clickListener = listener;
        return (B) this;
    }

    public B setClickListenerAndTo(View.OnClickListener listener, int... to) {
        this.clickListener = listener;
        this.eventTo = to;
        return (B) this;
    }

    public B setInitializer(EventInitialer initializer) {
        this.initializer = initializer;
        return (B) this;
    }

    public int[] getBindTo() {
        return bindTo;
    }

    public int[] getEventTo() {
        return eventTo;
    }

    public View.OnClickListener getClickListener() {
        return clickListener;
    }

    public EventInitialer getEventInitialer() {
        return initializer;
    }

}
