package com.mizi.gracerecyclerview.json;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mizi.gracerecyclerview.BaseFragment;
import com.mizi.gracerecyclerview.FragmentBuilder;
import com.mizi.gracerecyclerview.R;
import com.mizi.lib.rv.Recycler;
import com.mizi.lib.rv.json.SingleJSONAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SingleJsonFragment extends BaseFragment<SingleJsonFragment.Builder> {

    RecyclerView recyclerView;
    SingleJSONAdapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        adapter = new SingleJSONAdapter.Builder()
                .setKeys("item_key")
                .setSingleResId(android.R.layout.simple_list_item_1)
                .setBindTo(android.R.id.text1)
                .setItemClickListener(builder.getListener()).build();
        Recycler.listView(recyclerView)
                .vertical()
                .hasFixedSize()
                .setup()
                .setAdapter(adapter);

        List<JSONObject> mapList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            JSONObject object = new JSONObject();
            try {
                object.put("item_key", "item" + i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mapList.add(object);
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
