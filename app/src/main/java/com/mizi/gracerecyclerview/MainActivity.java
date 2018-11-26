package com.mizi.gracerecyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mizi.gracerecyclerview.gson.ProductListFragment;
import com.mizi.gracerecyclerview.gson.SimpleFragment;
import com.mizi.gracerecyclerview.json.MultipleArrayFragment;
import com.mizi.gracerecyclerview.json.MultipleJsonFragment;
import com.mizi.gracerecyclerview.json.MultipleMapFragment;
import com.mizi.gracerecyclerview.json.SingleArrayFragment;
import com.mizi.gracerecyclerview.json.SingleJsonFragment;
import com.mizi.gracerecyclerview.json.SingleMapFragment;
import com.mizi.lib.rv.event.EventHolder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SingleArrayFragment singleArrayFragment;
    SingleJsonFragment singleJsonFragment;
    SingleMapFragment singleMapFragment;

    MultipleArrayFragment multipleArrayFragment;
    MultipleJsonFragment multipleJsonFragment;
    MultipleMapFragment multipleMapFragment;

    SimpleFragment simpleFragment;
    ProductListFragment productListFragment;

    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        singleArrayFragment = new SingleArrayFragment.Builder()
                .setLayoutResId(R.layout.include_recycler_view)
                .setListener(this)
                .build(SingleArrayFragment.class);
        replaceFragment(R.id.clContent, singleArrayFragment);

        singleJsonFragment = new SingleJsonFragment.Builder()
                .setLayoutResId(R.layout.include_recycler_view)
                .build(SingleJsonFragment.class);

        singleMapFragment = new SingleMapFragment.Builder()
                .setLayoutResId(R.layout.include_recycler_view)
                .build(SingleMapFragment.class);

        multipleArrayFragment = new MultipleArrayFragment.Builder()
                .setLayoutResId(R.layout.include_recycler_view)
                .build(MultipleArrayFragment.class);

        multipleJsonFragment = new MultipleJsonFragment.Builder()
                .setLayoutResId(R.layout.include_recycler_view)
                .build(MultipleJsonFragment.class);

        multipleMapFragment = new MultipleMapFragment.Builder()
                .setLayoutResId(R.layout.include_recycler_view)
                .build(MultipleMapFragment.class);

        simpleFragment = new SimpleFragment.Builder()
                .setLayoutResId(R.layout.include_recycler_view)
                .build(SimpleFragment.class);

        productListFragment = new ProductListFragment.Builder()
                .setLayoutResId(R.layout.include_recycler_view)
                .build(ProductListFragment.class);
    }

    public void replaceFragment(int replaceIds, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(replaceIds, fragment, fragment.getClass().getSimpleName());
        transaction.commit();
        currentFragment = fragment;
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag(EventHolder.ITEM_POSITION_KEY);
        if (position == 0) {
            replaceFragment(R.id.clContent, singleArrayFragment);
        } else if (position == 1) {
            replaceFragment(R.id.clContent, singleJsonFragment);
        } else if (position == 2) {
            replaceFragment(R.id.clContent, singleMapFragment);
        } else if (position == 3) {
            replaceFragment(R.id.clContent, multipleArrayFragment);
        } else if (position == 4) {
            replaceFragment(R.id.clContent, multipleJsonFragment);
        } else if (position == 5) {
            replaceFragment(R.id.clContent, multipleMapFragment);
        } else if (position == 6) {
            replaceFragment(R.id.clContent, simpleFragment);
        } else if (position == 7) {
            replaceFragment(R.id.clContent, productListFragment);
        }
    }

    @Override
    public void onBackPressed() {
        if (!(currentFragment instanceof SingleArrayFragment)) {
            replaceFragment(R.id.clContent, singleArrayFragment);
        } else {
            super.onBackPressed();
        }
    }
}
