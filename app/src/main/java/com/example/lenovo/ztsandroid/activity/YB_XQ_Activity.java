package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.YB_FragmentAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.fragment.study.yb_sy.BYY_Fragment;
import com.example.lenovo.ztsandroid.fragment.study.yb_sy.YB_four_fragment;
import com.example.lenovo.ztsandroid.fragment.study.yb_sy.YB_xq_one_fragment;
import com.example.lenovo.ztsandroid.fragment.study.yb_sy.YB_xq_three_fragment;
import com.example.lenovo.ztsandroid.fragment.study.yb_sy.YBxq_two_fragment;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/5.
 */
public class YB_XQ_Activity extends BaseActivity {
    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.YB_xq_title)
    TextView YBXqTitle;
    @BindView(R.id.YB_Tablayout)
    TabLayout YBTablayout;
    @BindView(R.id.YB_viewPager)
    ViewPager YBViewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private YB_FragmentAdapter adapter;
    private Bundle bundle;
    @Override
    protected int getLayoutId() {
        return R.layout.yin_b_xq_activity;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        Log.e("AAAAAAAAAAAAAAAAAA",intent.getStringExtra("音标"));
        YBXqTitle.setText(intent.getStringExtra("音标"));
        int id = intent.getIntExtra("ID",1);
        String ids = String.valueOf(id);
        MyLog.e("ADASDSADSADSA",id + "");
        bundle = new Bundle();

        YB_xq_one_fragment fragment1 = new YB_xq_one_fragment();
        bundle.putString("YBid",ids);

        fragment1.setParams(bundle);
        YBxq_two_fragment fragment2 = new YBxq_two_fragment();
        bundle.putString("YBid",ids);
        fragment2.setParams(bundle);
        YB_xq_three_fragment fragment3 = new YB_xq_three_fragment();
        bundle.putString("YBid",ids);
        fragment3.setParams(bundle);
        YB_four_fragment fragment4 = new YB_four_fragment();
        bundle.putString("YBid",ids);
        fragment4.setParams(bundle);

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);

        adapter = new YB_FragmentAdapter(getSupportFragmentManager(),fragments);
        YBViewPager.setAdapter(adapter);
        YBTablayout.setupWithViewPager(YBViewPager);

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
        App.activity.onBackPressed();
    }
}
