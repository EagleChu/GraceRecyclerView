package com.mizi.lib.rv;

import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mizi.lib.rv.event.ClickEvent;
import com.mizi.lib.rv.event.Event;
import com.mizi.lib.rv.event.PairEvent;

/**
 * 绑定事件
 */
public abstract class EventHolder<Data> extends BaseHolder<Data> {

    public static final int ITEM_CLICK_KEY = "Item_Click_Key".hashCode();

    private int[] eventIds;

    public EventHolder(ViewGroup parent, int resId) {
        super(parent, resId);
    }

    public EventHolder(ViewGroup parent, int resId, View.OnClickListener listener, int... eventIds) {
        super(parent, resId);
        this.eventIds = eventIds;
        initClickListener(listener);
    }

    public EventHolder(ViewGroup parent, int resId, Event initializer) {
        super(parent, resId);
        initPairEvent(initializer);
    }

    @Deprecated
    public EventHolder(ViewGroup parent, int resId, SparseArray events) {
        super(parent, resId);
        initPairEvent(events);
    }

    @Override
    protected void bindView(Data itemData) {
        super.bindView(itemData);
        setEventViewTag(position);
    }
    @SuppressWarnings("unchecked")
    public <T extends EventHolder> T setClickListener(View.OnClickListener listener, int... eventIds) {
        this.eventIds = eventIds;
        this.initClickListener(listener);
        return (T) this;
    }

    /**
     * 建议在 Adapter 的 onCreateViewHolder 中调用此方法
     *
     * @param initializer Event 的实现类
     * @return EventHolder
     */
    @SuppressWarnings("unchecked")
    public <T extends EventHolder> T setEventInitializer(Event initializer) {
        this.initPairEvent(initializer);
        return (T) this;
    }

    private void initPairEvent(Event initializer) {

        if (initializer instanceof ClickEvent) {
            initClickEvent((ClickEvent) initializer);
        }

        if (initializer instanceof PairEvent) {
            PairEvent pair = (PairEvent) initializer;
            SparseArray events = pair.getPairEventArray();
            initPairEvent(events);
        }

    }

    private void initClickEvent(ClickEvent initializer) {
        ClickEvent click = initializer;
        this.eventIds = click.getEventIds();
        if (this.eventIds.length == 0 || this.eventIds[0] == 0) {
            this.setOnItemClickListener(click.getClickListener());
        } else {
            for (int eventId : eventIds) {
                this.setOnClickListener(eventId, click.getClickListener());
            }
        }
    }

    private void initPairEvent(SparseArray events) {
        this.eventIds = new int[events.size()];
        for (int i = 0; i < events.size(); i++) {
            Object object = events.valueAt(i);
            int key = this.eventIds[i] = events.keyAt(i);
            if (object instanceof View.OnClickListener) {
                this.setOnClickListener(key, (View.OnClickListener) object);
            } else if (object instanceof View.OnLongClickListener) {
                this.setOnLongClickListener(key, (View.OnLongClickListener) object);
            } else if (object instanceof RadioGroup.OnCheckedChangeListener) {
                this.setOnCheckedChangeListener(key, (RadioGroup.OnCheckedChangeListener) object);
            } else if (object instanceof TextWatcher) {
                TextView tv = findView(key);
                tv.addTextChangedListener((TextWatcher) object);
            } else if (object instanceof View.OnFocusChangeListener) {
                this.setOnFocusChangeListener(key, (View.OnFocusChangeListener) object);
            } else {
                // 其他未支持事件
            }
        }
    }

    private void initClickListener(View.OnClickListener listener) {
        if (eventIds == null || eventIds.length <= 0) {
            this.setOnItemClickListener(listener);
        } else {
            for (int id : eventIds) {
                setOnClickListener(id, listener);
            }
        }
    }

    private void setEventViewTag(int position) {
        if (eventIds == null || eventIds.length <= 0) {
            itemView.setTag(ITEM_CLICK_KEY, position);
        } else {
            for (int id : eventIds) {
                findView(id).setTag(id, position);
            }
        }
    }

    private void setOnItemClickListener(View.OnClickListener listener) {
        this.itemView.setOnClickListener(listener);
    }

    private void setOnClickListener(int eventId, View.OnClickListener listener) {
        findView(eventId).setOnClickListener(listener);
    }

    private void setOnLongClickListener(int eventId, View.OnLongClickListener listener) {
        findView(eventId).setOnLongClickListener(listener);
    }

    private void setOnCheckedChangeListener(int eventId, RadioGroup.OnCheckedChangeListener listener) {
        RadioGroup rg = findView(eventId);
        rg.setOnCheckedChangeListener(listener);
    }

    private void setOnFocusChangeListener(int eventId, View.OnFocusChangeListener listener) {
        findView(eventId).setOnFocusChangeListener(listener);
    }

}
