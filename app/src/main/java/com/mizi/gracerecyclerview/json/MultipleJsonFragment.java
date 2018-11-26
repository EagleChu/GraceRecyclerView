package com.mizi.gracerecyclerview.json;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mizi.gracerecyclerview.BaseFragment;
import com.mizi.gracerecyclerview.FragmentBuilder;
import com.mizi.gracerecyclerview.R;
import com.mizi.lib.rv.Recycler;
import com.mizi.lib.rv.json.MultipleJSONAdapter;
import com.mizi.lib.rv.json.data.JsonData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MultipleJsonFragment extends BaseFragment<MultipleJsonFragment.Builder> {

    RecyclerView recyclerView;
    MultipleJSONAdapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = rootView.findViewById(R.id.recyclerView);

        int type1 = android.R.layout.simple_list_item_1;
        int type2 = android.R.layout.simple_list_item_2;

        adapter = new MultipleJSONAdapter.Builder()
                .addItemViewIdAsTypeAndClickListener(type1, builder.getListener())
                .addBindTo(type1, android.R.id.text1)
                .addKeys(type1, "item_key")

                .addItemViewIdAsTypeAndClickListener(type2, builder.getListener())
                .addBindTo(type2, android.R.id.text1, android.R.id.text2)
                .addKeys(type2, "item_key_1", "item_key_2")
                .build(MultipleJSONAdapter.class);
        Recycler.listView(recyclerView)
                .vertical()
                .hasFixedSize()
                .setup()
                .setAdapter(adapter);

        List<JsonData> mapList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            JSONObject object = new JSONObject();
            try {
                object.put("item_key", "item" + i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JsonData jsonData = new JsonData();
            jsonData.data = object;
            jsonData.itemType = type1;

            mapList.add(jsonData);
        }

        for (int i = 0; i < 60; i++) {
            JSONObject object = new JSONObject();
            try {
                object.put("item_key_1", "title" + i);
                object.put("item_key_2", "item" + i + " " + i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JsonData jsonData = new JsonData();
            jsonData.data = object;
            jsonData.itemType = type2;

            mapList.add(jsonData);
        }
        adapter.putData(mapList);
    }

    public static class Builder extends FragmentBuilder<Builder> {
        private View.OnClickListener listener;

        public View.OnClickListener getListener() {
            return listener;
        }

        public Builder setListener(View.OnClickListener listener) {
            this.listener = listener;
            return this;
        }
    }


}
