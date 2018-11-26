package com.mizi.lib.rv.gson;


import android.util.SparseIntArray;

import com.mizi.lib.rv.BaseAdapter;
import com.mizi.lib.rv.EventAdapter;
import com.mizi.lib.rv.ItemData;
import com.mizi.lib.rv.ItemEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class GsonAdapter<Data extends ItemData> extends EventAdapter<Data, GsonHolder<Data>> {

    @Override
    public int getItemViewType(int position) {
        if (dataList != null && dataList.size() > 0) {
            return dataList.get(position).itemType;
        } else {
            return -1;
        }
    }

    /**
     * key ItemType
     * value ItemCount
     *
     * @param mock 模拟数据
     */
    public static List<ItemData> mockData(SparseIntArray mock) {
        List<ItemData> dataList = new ArrayList<>();
        for (int i = 0; i < mock.size(); i++) {
            int key = mock.keyAt(i);
            int value = mock.valueAt(i);

            for (int v = 0; v < value; v++) {
                ItemData itemData = new ItemData();
                itemData.itemType = key;
                dataList.add(itemData);
            }
        }
        return dataList;
    }

    public static List<ItemData> mockData(int itemType, int itemCount) {
        SparseIntArray mock = new SparseIntArray();
        mock.put(itemType, itemCount);
        return mockData(mock);
    }
}
