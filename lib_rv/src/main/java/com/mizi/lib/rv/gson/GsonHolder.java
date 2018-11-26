package com.mizi.lib.rv.gson;

import android.support.annotation.IdRes;
import android.view.View;
import android.view.ViewGroup;

import com.mizi.lib.rv.EventHolder;
import com.mizi.lib.rv.ItemData;
import com.mizi.lib.rv.event.Event;

public abstract class GsonHolder<Data extends ItemData> extends EventHolder<Data> {

    private int[] to;

    public GsonHolder(ViewGroup parent, int layoutResId, int... to) {
        super(parent, layoutResId);
        this.to = to;
        findViews();
    }

    public GsonHolder(ViewGroup parent, int resId, View.OnClickListener listener, int... eventIds) {
        super(parent, resId, listener, eventIds);
    }

    protected void findViews() {
        if (to != null && to.length > 0) {
            for (int id : to) {
                findView(id);
            }
        }
    }

    /**
     * 此方法必须和 setKey 方法配套使用,
     * 也可以直接调用 setKeyAndTo 方法
     *
     * @param to 目标 View 的 Id 集合
     * @return JsonHolder
     */
    public GsonHolder setTo(int... to) {
        this.to = to;
        return this;
    }

    /**
     * 子类复写 bindView 方法,
     * 整理 Data 中相应数据成 from 数组,
     * 调用此方法并传入 from 数组,
     * 直接调用此方法时则应该是在构造函数中传入了 to 数组
     *
     * @param from 绑定要用到的数据数组
     */
    public void bindData(Object[] from) {
        if (to != null && from.length != to.length) {
            return;
        } else {
            for (int i = 0; i < from.length; i++) {
                bindViewByData(views.get(to[i]), from[i]);
            }
        }
    }

    /**
     * @param to   绑定的目标View的Id数组
     * @param from 相应的数据数组
     */
    public void bindViewByData(int[] to, Object[] from) {
        this.to = to;
        bindData(from);
    }

    public <T> void bindViewByResId(@IdRes int resId, T data) {
        String text = data == null ? "" : String.valueOf(data);
        View view = itemView.findViewById(resId);
        bindViewByData(view, data);
    }
}
