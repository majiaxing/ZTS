package com.example.lenovo.ztsandroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/26.
 */

public class KE_FragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<String> list;
    private String [] title = {"半元音","舌边音","鼻音","破擦音","摩擦音","爆破音","集中双元音","合口双元音","后元音","中元音","前元音"};
    private List<Fragment> fragmentList;

    public KE_FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, ArrayList<String> list) {
        super(fm);
        this.fragmentList = fragmentList;
        this.list = list;
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
        return list.get(position);

    }



}
