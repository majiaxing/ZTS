package com.example.lenovo.ztsandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/11/12.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragmentList;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> mFragmentList) {
        super(fm);
        this.mFragmentList=mFragmentList;
    }

    @Override
    public Fragment getItem(int arg0) {

        return mFragmentList.get(arg0);
    }

    @Override
    public int getCount() {

        return  mFragmentList.size();
    }


}
