package com.mizi.gracerecyclerview.json;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mizi.gracerecyclerview.BaseFragment;
import com.mizi.gracerecyclerview.FragmentBuilder;
import com.mizi.gracerecyclerview.R;
import com.mizi.lib.rv.Recycler;
import com.mizi.lib.rv.json.MultipleArrayAdapter;
import com.mizi.lib.rv.json.data.StringData;

import java.util.ArrayList;
import java.util.List;

public class MultipleArrayFragment extends BaseFragment<MultipleArrayFragment.Builder> {

    RecyclerView recyclerView;

    MultipleArrayAdapter arrayAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = rootView.findViewById(R.id.recyclerView);

        int type1 = android.R.layout.simple_list_item_1;
        int type2 = android.R.layout.simple_list_item_2;

        arrayAdapter = new MultipleArrayAdapter.Builder()
                .addItemViewIdAsType(type1)
                .addBindTo(type1, android.R.id.text1)
                .addItemClickListener(type1, builder.getListener())

                .addItemViewIdAsTypeAndClickListener(type2, builder.getListener())
                .addBindTo(type2, android.R.id.text2)
                .build(MultipleArrayAdapter.class);

        Recycler.listView(recyclerView)
                .vertical()
                .hasFixedSize()
                .setup()
                .setAdapter(arrayAdapter);

        List<StringData> dataList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            StringData stringData = new StringData();
            stringData.itemType = type1;
            stringData.data = "item " + i;
            dataList.add(stringData);
        }
        for (int i = 0; i < 60; i++) {
            StringData stringData = new StringData();
            stringData.itemType = type2;
            stringData.data = "item " + i + " " + i;
            dataList.add(stringData);
        }

        arrayAdapter.putData(dataList);
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
