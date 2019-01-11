package com.example.lenovo.ztsandroid.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.fragment.XuanZ_Fragment;
import com.example.lenovo.ztsandroid.utils.BackPopupUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/9.
 */
public class Xuanz_Sy_Activity extends BaseActivity {


    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.danci_viewPager)
    ViewPager danciViewPager;
    private ViewPagerAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();


    @Override
    protected int getLayoutId() {
        return R.layout.xuanz_sy_activity;
    }

    @Override
    protected void initView() {

//        添加 fragment 的 页面
        for (int i = 1; i <= 5; i++) {

            XuanZ_Fragment fragment = new XuanZ_Fragment();
            list.add(fragment);
        }
//        初始化adapter  创建页面
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),list);
        danciViewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        danciViewPager.setOffscreenPageLimit(0);
//        监听 viewpager
        danciViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




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

    @OnClick({R.id.back_jt, R.id.title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                BackPopupUtils.PopupW(view,"正在答题中，确定退出？");
                break;
            case R.id.title:



                break;
        }
    }
}
