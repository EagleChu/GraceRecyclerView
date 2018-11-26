package com.mizi.gracerecyclerview.gson;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mizi.gracerecyclerview.FragmentBuilder;
import com.mizi.gracerecyclerview.BaseFragment;
import com.mizi.gracerecyclerview.R;
import com.mizi.lib.rv.Recycler;

import java.util.ArrayList;
import java.util.List;

public class SimpleFragment extends BaseFragment<SimpleFragment.Builder> {

    RecyclerView recyclerView;
    SimpleAdapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = rootView.findViewById(R.id.recyclerView);

        int type2 = android.R.layout.simple_list_item_2;

        adapter = new SimpleAdapter.Builder()
                .addItemViewIdAsType(type2)
                .addBindTo(type2, android.R.id.text1, android.R.id.text2)
                .addItemClickListener(type2, builder.getListener())
                .build(SimpleAdapter.class);

        Recycler.listView(recyclerView)
                .vertical()
                .hasFixedSize()
                .setup()
                .setAdapter(adapter);


        List<SimpleBean> dataList = new ArrayList<>();

        for (int i = 0; i < 60; i++) {
            SimpleBean bean = new SimpleBean();
            bean.itemType = type2;
            bean.title = "item " + i + i;
            bean.description = "description " + i + " description" + i;
            dataList.add(bean);
        }

        adapter.putData(dataList);
    }

    public static class Builder extends FragmentBuilder<Builder> {
        View.OnClickListener listener;

        public View.OnClickListener getListener() {
            return listener;
        }

        public Builder setListener(View.OnClickListener listener) {
            this.listener = listener;
            return this;
        }
    }
}
