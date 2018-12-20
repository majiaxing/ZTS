package com.example.lenovo.ztsandroid.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/23.
 */
public class ChY_SB_Activity extends BaseActivity {

    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.Title)
    TextView Title;
    @BindView(R.id.Sbh)
    TextView Sbh;

    @Override
    protected int getLayoutId() {
        return R.layout.chy_sb_activity;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back_jt)
    public void onViewClicked() {
    }
}
