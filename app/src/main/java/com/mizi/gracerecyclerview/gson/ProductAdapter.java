package com.mizi.gracerecyclerview.gson;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.google.android.flexbox.FlexboxLayout;
import com.mizi.gracerecyclerview.R;
import com.mizi.gracerecyclerview.utils.GlideImageLoader;
import com.mizi.gracerecyclerview.widget.CategoryView;
import com.mizi.lib.rv.ItemEntity;
import com.mizi.lib.rv.builder.MultipleBuilder;
import com.mizi.lib.rv.gson.CommonAdapter;
import com.mizi.lib.rv.gson.CommonHolder;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductAdapter extends CommonAdapter {

    @NonNull
    @Override
    public CommonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == R.layout.item_product_list_header) {
            return new HeaderHolder(parent, builder);
        } else if (viewType == R.layout.item_product_list_recommend) {
            return new RecommendHolder(parent, builder);
        } else {
            return super.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CommonHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == R.layout.item_product_list) {
            ProductBean bean = (ProductBean) dataList.get(position).entity;
            holder.bindView(
                    bean.getName(),
                    bean.getDesc(),
                    bean.getSpec(),
                    bean.getPrice()
            );
        } else {
            super.onBindViewHolder(holder, position);
        }
    }

    public static class HeaderHolder extends CommonHolder {

        @BindView(R.id.banner)
        Banner banner;

        HeaderHolder(ViewGroup parent, MultipleBuilder builder) {
            super(parent, R.layout.item_product_list_header, builder);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void bindView(ItemEntity itemData) {
            super.bindView(itemData);
            BannerBean bean = getEntity();
            banner.setImageLoader(new GlideImageLoader())
                    .setImages(bean.getUrlList())
                    .start();
        }
    }

    public static class RecommendHolder extends CommonHolder {


        @BindView(R.id.cvZero)
        CategoryView cvZero;
        @BindView(R.id.cvOne)
        CategoryView cvOne;
        @BindView(R.id.cvTwo)
        CategoryView cvTwo;
        @BindView(R.id.cvThree)
        CategoryView cvThree;
        @BindView(R.id.cvFour)
        CategoryView cvFour;
        @BindView(R.id.flexbox)
        FlexboxLayout flexbox;

        RecommendHolder(ViewGroup parent, MultipleBuilder builder) {
            super(parent, R.layout.item_product_list_recommend, builder);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void bindView(ItemEntity itemData) {
            super.bindView(itemData);
            List<RecommendBean> beanList = getEntity();
            RecommendBean b0 = beanList.get(0);
            RecommendBean b1 = beanList.get(1);
            RecommendBean b2 = beanList.get(2);
            RecommendBean b3 = beanList.get(3);
            RecommendBean b4 = beanList.get(4);
            cvZero.setCategoryName(b0.getCategory());
            cvZero.setCategoryImage(b0.getImgUrl());

            cvOne.setCategoryName(b1.getCategory());
            cvOne.setCategoryImage(b1.getImgUrl());

            cvTwo.setCategoryName(b2.getCategory());
            cvTwo.setCategoryImage(b2.getImgUrl());

            cvThree.setCategoryName(b3.getCategory());
            cvThree.setCategoryImage(b3.getImgUrl());

            cvFour.setCategoryName(b4.getCategory());
            cvFour.setCategoryImage(b4.getImgUrl());
        }
    }

    public static class ProductHolder extends CommonHolder {

        public ProductHolder(ViewGroup parent, MultipleBuilder builder) {
            super(parent, R.layout.item_product_list, builder);
        }

        @Override
        protected void bindView(ItemEntity itemData) {
            super.bindView(itemData);
            ProductBean bean = getEntity();
            bindView(
                    bean.getName(),
                    bean.getDesc(),
                    bean.getSpec(),
                    bean.getPrice()
            );
        }
    }
}
