package com.mizi.gracerecyclerview.gson;

import android.support.annotation.NonNull;

import com.mizi.lib.rv.gson.GsonAdapter;
import com.mizi.lib.rv.gson.GsonHolder;

public class SimpleAdapter extends GsonAdapter<SimpleBean> {
    @Override
    public void onBindViewHolder(@NonNull GsonHolder<SimpleBean> holder, int position) {
        SimpleBean itemBean = dataList.get(position);
        holder.bindView(itemBean.title, itemBean.description);
    }

}
