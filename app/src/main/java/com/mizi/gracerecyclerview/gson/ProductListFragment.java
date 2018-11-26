package com.mizi.gracerecyclerview.gson;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.mizi.gracerecyclerview.BaseFragment;
import com.mizi.gracerecyclerview.FragmentBuilder;
import com.mizi.gracerecyclerview.R;
import com.mizi.gracerecyclerview.utils.Constant;
import com.mizi.lib.rv.ItemEntity;
import com.mizi.lib.rv.Recycler;

import java.util.ArrayList;
import java.util.List;

public class ProductListFragment extends BaseFragment<ProductListFragment.Builder> {

    RecyclerView recyclerView;
    ProductAdapter adapter;

    List<ItemEntity> dataList;

    int type1 = R.layout.item_product_list_header;
    int type2 = R.layout.item_product_list_recommend;
    int type3 = R.layout.item_product_list;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataList = new ArrayList<>();

        List<String> urlList = JSON.parseArray(Constant.bannerList, String.class);
        BannerBean banner = new BannerBean();
        banner.setUrlList(urlList);
        ItemEntity bEntity = new ItemEntity();
        bEntity.entity = banner;
        bEntity.itemType = type1;

        dataList.add(bEntity);

        List<RecommendBean> recommendList = JSON.parseArray(Constant.recommend, RecommendBean.class);
        ItemEntity rEntity = new ItemEntity();
        rEntity.entity = recommendList;
        rEntity.itemType = type2;

        dataList.add(rEntity);

        for (int i = 0; i < 60; i++) {
            ProductBean product = new ProductBean();
            product.setName("product" + (i * 10) + 1);
            product.setDesc("反倒是卡就付款啦解放路科技奥地利");
            product.setSpec("抵抗力强");
            product.setPrice(99.88);

            ItemEntity pEntity = new ItemEntity();
            pEntity.entity = product;
            pEntity.itemType = type3;

            dataList.add(pEntity);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = rootView.findViewById(R.id.recyclerView);

        adapter = new ProductAdapter.Builder()
                .addItemViewIdAsType(type1)
                .addItemClickListener(type1, builder.getListener())

                .addItemViewIdAsType(type2)
                .addItemClickListener(type2, builder.getListener())

                .addItemViewIdAsType(type3)
                .addBindTo(type3, R.id.tvName, R.id.tvDesc, R.id.tvSpec, R.id.tvPrice)
                .addItemClickListener(type3, builder.getListener())

                .build(ProductAdapter.class);

        Recycler.listView(recyclerView)
                .vertical()
                .hasFixedSize()
                .setup()
                .setAdapter(adapter);

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
