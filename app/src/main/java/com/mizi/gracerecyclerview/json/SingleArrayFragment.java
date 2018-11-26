package com.mizi.gracerecyclerview.json;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mizi.gracerecyclerview.BaseFragment;
import com.mizi.gracerecyclerview.FragmentBuilder;
import com.mizi.gracerecyclerview.R;
import com.mizi.lib.rv.Recycler;
import com.mizi.lib.rv.json.SingleArrayAdapter;

import java.util.Arrays;
import java.util.List;

public class SingleArrayFragment extends BaseFragment<SingleArrayFragment.Builder> {

    RecyclerView recyclerView;

    SingleArrayAdapter arrayAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = rootView.findViewById(R.id.recyclerView);

        arrayAdapter = new SingleArrayAdapter.Builder()
                .setSingleResId(android.R.layout.simple_list_item_1)
                .setBindTo(android.R.id.text1)
                .setItemClickListener(builder.getListener()).build();

        Recycler.listView(recyclerView)
                .vertical()
                .hasFixedSize()
                .setup()
                .setAdapter(arrayAdapter);

        String[] data = {
                "SingleArray", "SingleJson",
                "SingleMap", "MultipleArray",
                "MultipleJson", "MultipleMap",
                "Gson", "Common"
        };

        List<String> dataList = Arrays.asList(data);

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
