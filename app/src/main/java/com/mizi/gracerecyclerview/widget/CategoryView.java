package com.mizi.gracerecyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mizi.gracerecyclerview.R;

public class CategoryView extends LinearLayout {

    TextView textView;
    ImageView imageView;
    Context context;

    public CategoryView(Context context) {
        super(context);
        initView(context);
    }

    public CategoryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initAttrs(attrs);
    }

    public CategoryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initAttrs(attrs);
    }

    void initView(Context context) {
        this.context = context.getApplicationContext();
        LayoutInflater.from(context).inflate(R.layout.view_category, this, true);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        this.setGravity(Gravity.CENTER);
        this.setOrientation(VERTICAL);
    }

    private void initAttrs(@Nullable AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CategoryView);
        int src = array.getResourceId(R.styleable.CategoryView_category_src, R.mipmap.ic_launcher);
        imageView.setImageResource(src);
        String title = array.getString(R.styleable.CategoryView_title_text);
        if (!TextUtils.isEmpty(title)) {
            textView.setText(title);
        }
        array.recycle();
    }

    public void setCategoryName(String categoryName) {
        textView.setText(categoryName);
    }

    public void setCategoryImage(String categoryImage) {
        Glide.with(context).load(categoryImage).into(imageView);
    }

}
