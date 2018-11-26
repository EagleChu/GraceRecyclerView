package com.mizi.lib.rv;

import android.support.annotation.NonNull;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.mizi.lib.rv.event.Event;

import java.util.List;

public abstract class EventAdapter<Data, Holder extends EventHolder> extends BaseAdapter<Data, Holder> {

    private View.OnClickListener listener;
    private int[] eventIds = null;

    public EventAdapter() {
    }

    public EventAdapter(List<Data> data) {
        super(data);
    }

    public EventAdapter(View.OnClickListener listener) {
        this.listener = listener;
    }

    public EventAdapter setOnItemClickListener(View.OnClickListener listener) {
        this.listener = listener;
        return this;
    }

    public EventAdapter setOnClickListener(View.OnClickListener listener, int... eventIds) {
        this.listener = listener;
        this.eventIds = eventIds;
        return this;
    }


}
