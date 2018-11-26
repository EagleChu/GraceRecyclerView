package com.mizi.lib.rv;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 绑定数据
 */
public abstract class BaseHolder<Data> extends RecyclerView.ViewHolder {
    protected final SparseArray<View> views;
    protected Context context;
    protected Data itemData;
    protected int[] bindTo;
    protected int position;

    public BaseHolder(ViewGroup parent, @LayoutRes int resId) {
        super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
        this.context = itemView.getContext();
        views = new SparseArray<>();
    }

    /**
     * 和 {@link #bindView(Object...)} 对应,
     * 需要子类在此基础上重载此方法
     * @param itemData 实际的 Item 数据
     */
    protected void bindView(Data itemData) {
        this.itemData = itemData;
        this.position = getAdapterPosition();
    }


    /**
     * 和 {@link #bindView(Object)} 对应
     * 用于子类或者其他类调用
     * @param values ItemData 中的相应属性的取值
     */
    public void bindView(Object... values){
        this.position = getAdapterPosition();
        bindData(values);
    }

    /**
     * 最终的目标子类复写 bindView 方法,
     * 整理 Data 中相应数据成 from 数组,
     * 调用此方法并传入 from 数组,
     * 直接调用此方法时则应该是在构造函数中传入了 to 数组
     *
     * @param from 绑定要用到的数据数组
     */
    public void bindData(Object[] from) {
        if (bindTo != null && from.length != bindTo.length) {
            return;
        } else {
            for (int i = 0; i < from.length; i++) {
                bindDataToViewByResId(bindTo[i], from[i]);
            }
        }
    }

    /**
     * 最终的目标子类复写 bindView 方法,
     * 整理 Data 中相应数据成 from 数组,
     * 调用此方法并传入得到的 from 数组,
     * 直接调用此方法时则应该是在构造函数中没有传 to 数组
     *
     * @param to   绑定的目标View的Id数组
     * @param from 相应的数据数组
     */
    public void bindData(int[] to, Object[] from) {
        this.bindTo = to;
        bindData(from);
    }

    /**
     * 绑定数据到相应的View中
     *
     * @param v    绑定的目标
     * @param data 相应的数据
     */
    protected void bindDataToView(View v, Object data) {
        String text = data == null ? "" : String.valueOf(data);
        if (v instanceof Checkable) {
            if (data instanceof Boolean) {
                ((Checkable) v).setChecked((Boolean) data);
            } else if (v instanceof TextView) {
                // Note: keep the instanceof TextView check at the bottom of these
                // ifs since a lot of views are TextViews (e.g. CheckBoxes).
                setViewText((TextView) v, text);
            } else {
                throw new IllegalStateException(v.getClass().getName() +
                        " should be bound to a Boolean, not a " +
                        (data == null ? "<unknown type>" : data.getClass()));
            }
        } else if (v instanceof TextView) {
            // Note: keep the instanceof TextView check at the bottom of these
            // ifs since a lot of views are TextViews (e.g. CheckBoxes).
            setViewText((TextView) v, text);
        } else if (v instanceof ImageView) {
            if (data instanceof Integer) {
                setViewImage((ImageView) v, (Integer) data);
            } else {
                setViewImage((ImageView) v, text);
            }
        } else {
            throw new IllegalStateException(v.getClass().getName() + " is not a " +
                    " view that can be bounds by this SingleArrayAdapter");
        }
    }

    /**
     * 绑定数据到相应的View(通过findView(resId)获得)中
     *
     * @param resId 目标的 resId
     * @param data  相应的数据
     */
    protected void bindDataToViewByResId(@IdRes int resId, Object data) {
        View view = findView(resId);
        bindDataToView(view, data);
    }

    protected void findViews() {
        if (bindTo != null && bindTo.length > 0) {
            for (int id : bindTo) {
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
    public BaseHolder setBindTo(int... to) {
        this.bindTo = to;
        return this;
    }

    public <T extends View> T findView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public void setViewImage(ImageView v, String value) {
        try {
            v.setImageResource(Integer.parseInt(value));
        } catch (NumberFormatException nfe) {
            v.setImageURI(Uri.parse(value));
        }
    }

    public void setViewImage(ImageView v, int value) {
        v.setImageResource(value);
    }

    public void setViewText(TextView v, String text) {
        v.setText(text);
    }

}
