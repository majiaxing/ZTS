package com.example.lenovo.ztsandroid.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseFragment;

/**
 * Created by Lenovo on 2018/10/24.
 */

public class CSTwofragment extends BaseFragment {
    private ImageView imagTwo;
    @Override
    protected int getLayoutId() {
        return R.layout.cstwo_fragment;
    }

    @Override
    protected void init(View view) {
    imagTwo = view.findViewById(R.id.ImageTwo);
        Glide.with(this).load("com/photoAlbum/page/performance/img/2015/12/28/1451292351735_203.jpg").into(imagTwo);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setParams(Bundle bundle) {

    }
}
