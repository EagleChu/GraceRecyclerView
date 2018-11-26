package com.mizi.gracerecyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;

public class BaseFragment<B extends FragmentBuilder> extends Fragment {

    protected B builder;
    protected View rootView;

    public void setBuilder(B builder) {
        this.builder = builder;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(builder.getLayoutResId(), container, false);
        return rootView;
    }

    public void toast(int resId) {
        ToastUtils.showShort(resId);
    }

    public void toast(String msg) {
        ToastUtils.showShort(msg);
    }


}
