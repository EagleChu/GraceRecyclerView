package com.mizi.lib.rv.event;

import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mizi.lib.rv.BaseHolder;

/**
 * 绑定事件
 */
public abstract class EventHolder<Data> extends BaseHolder<Data> {

    public static final int ITEM_POSITION_KEY = "ITEM_POSITION_KEY".hashCode();

    private int[] clickViewIds;

    public EventHolder(ViewGroup parent, int resId) {
        super(parent, resId);
    }

    @Deprecated
    public EventHolder(ViewGroup parent, int resId, View.OnClickListener listener, int... clickViewIds) {
        super(parent, resId);
        setClickListener(listener, clickViewIds);
    }

    @Deprecated
    public EventHolder(ViewGroup parent, int resId, EventInitialer initializer) {
        super(parent, resId);
        setEventInitializer(initializer);
    }

    @Deprecated
    public EventHolder(ViewGroup parent, int resId, SparseArray events) {
        super(parent, resId);
        initPairEvent(events);
    }

    @Override
    protected void bindView(Data itemData) {
        super.bindView(itemData);
        bindEventPosition(position);
    }

    @Override
    public void bindView(Object... values) {
        super.bindView(values);
        bindEventPosition(position);
    }

    protected void bindEventPosition(int position) {
        if (clickViewIds == null || clickViewIds.length <= 0) {
            itemView.setTag(ITEM_POSITION_KEY, position);
        } else {
            for (int id : clickViewIds) {
                findView(id).setTag(id, position);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends EventHolder> T setClickListener(View.OnClickListener listener, int... clickViewIds) {
        this.clickViewIds = clickViewIds;
        this.initClickListener(listener);
        return (T) this;
    }

    /**
     * 建议在 Adapter 的 onCreateViewHolder 中调用此方法
     *
     * @param initializer EventInitialer 的实现类
     * @return EventHolder
     */
    @SuppressWarnings("unchecked")
    public <T extends EventHolder> T setEventInitializer(EventInitialer initializer) {
        this.initPairEvent(initializer);
        return (T) this;
    }

    private void initPairEvent(EventInitialer initializer) {

        if (initializer instanceof ClickEventInitialer) {
            initClickEvent((ClickEventInitialer) initializer);
        }

        if (initializer instanceof PairEventInitialer) {
            PairEventInitialer pair = (PairEventInitialer) initializer;
            SparseArray events = pair.getPairEventArray();
            initPairEvent(events);
        }

    }

    private void initClickEvent(ClickEventInitialer initializer) {
        ClickEventInitialer click = initializer;
        this.clickViewIds = click.getEventIds();
        if (this.clickViewIds.length == 0 || this.clickViewIds[0] == 0) {
            this.setOnItemClickListener(click.getClickListener());
        } else {
            for (int eventId : clickViewIds) {
                this.setOnClickListener(eventId, click.getClickListener());
            }
        }
    }

    private void initPairEvent(SparseArray events) {
        this.clickViewIds = new int[events.size()];
        for (int i = 0; i < events.size(); i++) {
            Object object = events.valueAt(i);
            int key = this.clickViewIds[i] = events.keyAt(i);
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
        if (clickViewIds == null || clickViewIds.length <= 0) {
            this.setOnItemClickListener(listener);
        } else {
            for (int id : clickViewIds) {
                setOnClickListener(id, listener);
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
