package com.mizi.lib.rv.gson;

import android.view.ViewGroup;

import com.mizi.lib.rv.ItemData;
import com.mizi.lib.rv.builder.MultipleBuilder;
import com.mizi.lib.rv.type.MultipleHolder;

/**
 * 参考对应的 {@link GsonAdapter} 中的说明
 *
 * @param <Data> 实际的 ItemData 数据
 */
public class GsonHolder<Data extends ItemData> extends MultipleHolder<Data> {
    public GsonHolder(ViewGroup parent, int viewType, MultipleBuilder builder) {
        super(parent, builder.getLayoutResId(viewType), builder);
    }
}
