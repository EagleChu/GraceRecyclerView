package com.mizi.lib.rv.type;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mizi.lib.rv.ItemData;
import com.mizi.lib.rv.builder.MultipleBuilder;
import com.mizi.lib.rv.event.EventAdapter;

import java.util.List;


public abstract class MultipleAdapter<Data extends ItemData,Holder extends MultipleHolder, MB extends MultipleBuilder> extends EventAdapter<Data, Holder, MB> {

    public MultipleAdapter() {
    }

    public MultipleAdapter(List<Data> data) {
        super(data);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemViewType(int position) {
        if (dataList != null && dataList.size() > 0) {
            return dataList.get(position).itemType;
        } else {
            return -1;
        }
    }

}
