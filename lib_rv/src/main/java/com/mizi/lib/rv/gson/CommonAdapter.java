package com.mizi.lib.rv.gson;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.mizi.lib.rv.ItemEntity;
import com.mizi.lib.rv.builder.MultipleBuilder;
import com.mizi.lib.rv.type.MultipleAdapter;

import java.util.List;

/**
 * 和 {@link GsonAdapter} 对应, 此两类用来规范 Item 的数据格式;
 * <p>
 * CommonAdapter 有两种使用方式 ({@link GsonAdapter} 也是一样)
 * 一种是对于 Item 比较简单的, 此时继承的子类只需覆写
 * onBindViewHolder 方法, 调用 holder 的 bindView 方法,
 * 传入 ItemData 中相关属性对应的值即可
 * <p>
 * 第二种是 Item 的效果复杂, 此时同时创建 CommonAdapter(GsonAdapter) 和 CommonHolder(GsonHolder) 的子类,
 * 此时子 Adapter 中只需覆写 onCreateViewHolder, 根据 viewType 来传入相关的 ViewHolder,
 * 而子 ViewHolder 则覆写 bindView 来指定 ItemData 的数据关联到相应的 View 中
 * <p>
 * 在第二种方式中, 自定义 ViewHolder 可以配合 ButterKnife 来使用, 此时务必使用 LayoutResId 作为 ViewType,
 * 参考 Demo 中 ProductAdapter 类中的内部类 HeaderHolder(RecommendHolder) 和 ProductHolder 中的区别
 */
public class CommonAdapter extends MultipleAdapter<ItemEntity, CommonHolder, CommonAdapter.Builder> {
    public CommonAdapter() {
    }

    public CommonAdapter(List<ItemEntity> itemEntities) {
        super(itemEntities);
    }

    @NonNull
    @Override
    public CommonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommonHolder(parent, viewType, builder);
    }

    @Override
    public void onBindViewHolder(@NonNull CommonHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }

    public static class Builder extends MultipleBuilder<Builder> {

    }
}
