package com.mizi.lib.rv.gson;

import android.view.ViewGroup;

import com.mizi.lib.rv.ItemEntity;
import com.mizi.lib.rv.builder.MultipleBuilder;
import com.mizi.lib.rv.type.MultipleHolder;

import java.util.List;

/**
 * 参考对应的 {@link CommonAdapter} 中的说明
 */
public class CommonHolder extends MultipleHolder<ItemEntity> {

    public CommonHolder(ViewGroup parent, int viewType, MultipleBuilder builder) {
        super(parent, builder.getLayoutResId(viewType), builder);
    }

    @SuppressWarnings("unchecked")
    protected <Entity> Entity getEntity() {
        return (Entity) itemData.entity;
    }
    @SuppressWarnings("unchecked")
    public <Entity> Entity getEntity(List<ItemEntity> dataList,int position){
        return (Entity) dataList.get(position).entity;
    }

}
