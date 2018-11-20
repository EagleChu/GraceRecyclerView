package com.mizi.lib.rv;

import android.content.Context;
import android.net.Uri;
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
    protected int position;
    protected Context context;
    protected Data itemData;

    public BaseHolder(ViewGroup parent, @LayoutRes int resId) {
        super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
        this.context = itemView.getContext();
        views = new SparseArray<>();
    }

    protected void bindView(Data itemData) {
        this.position = getAdapterPosition();
        this.itemData = itemData;
        bindView();
    }

    /**
     * 绑定数据到相应的View中
     *
     * @param v    绑定的目标
     * @param data 相应的数据
     */
    protected void bindViewByData(View v, Object data) {
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
                    " view that can be bounds by this ArrayAdapter");
        }
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

    public abstract void bindView();
}
