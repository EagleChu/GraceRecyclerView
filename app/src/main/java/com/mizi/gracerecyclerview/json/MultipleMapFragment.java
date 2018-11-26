package com.mizi.gracerecyclerview.json;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mizi.gracerecyclerview.BaseFragment;
import com.mizi.gracerecyclerview.FragmentBuilder;
import com.mizi.gracerecyclerview.R;
import com.mizi.lib.rv.Recycler;
import com.mizi.lib.rv.json.MultipleMapAdapter;
import com.mizi.lib.rv.json.data.MapData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipleMapFragment extends BaseFragment<MultipleMapFragment.Builder> {

    RecyclerView recyclerView;
    MultipleMapAdapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        int type1 = android.R.layout.simple_list_item_1;

        int type2 = android.R.layout.simple_list_item_2;

        adapter = new MultipleMapAdapter.Builder()
                .addItemViewIdAsTypeAndClickListener(type1, builder.getListener())
                .addBindTo(type1, android.R.id.text1)
                .addKeys(type1, "item_key")

                .addItemViewIdAsTypeAndClickListener(type2, builder.getListener())
                .addBindTo(type2, android.R.id.text1, android.R.id.text2)
                .addKeys(type2, "item_key_1", "item_key_2")
                .build(MultipleMapAdapter.class);

        Recycler.listView(recyclerView)
                .vertical()
                .hasFixedSize()
                .setup()
                .setAdapter(adapter);

        List<MapData> mapList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("item_key", "item" + i);

            MapData data = new MapData();
            data.data = map;
            data.itemType = type1;
            mapList.add(data);
        }

        for (int i = 0; i < 60; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("item_key_1", "title" + i);
            map.put("item_key_2", "item" + i + " " + i);
            MapData data = new MapData();
            data.data = map;
            data.itemType = type2;
            mapList.add(data);
        }
        adapter.putData(mapList);
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
