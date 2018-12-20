package com.example.lenovo.ztsandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/10/26.
 */

public class YB_FragmentAdapter extends FragmentPagerAdapter {

    private String [] title = {"发音实例","发音详解","尝试发音","字母及其组合"};
    private List<Fragment> fragmentList;
    public YB_FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }



}
