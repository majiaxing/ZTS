package com.example.lenovo.ztsandroid.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.ztsandroid.utils.SetViewPagerListener;

import java.util.List;

/**
 * Created by lx on 2017/10/18.
 * 轮播图适配器
 */

public class lutuAdapter extends PagerAdapter {
    private List<View> list;
     SetViewPagerListener listner;
    private int mChildCount = 0;
    public lutuAdapter(List<View> list) {
        this.list = list;
    }


    @Override
    public void notifyDataSetChanged() {
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        if ( mChildCount > 0) {
            mChildCount--;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return list.size() > 0 ? Integer.MAX_VALUE : 0;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (list.size() > 0)
            container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = list.get(position % list.size());
        if (container != null) {
            container.removeView(list.get(position % list.size()));
        }
        if (list.size() > 0)
            container.addView(list.get(position % list.size()));
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                if (list.size() > 0)
////                    listner.setViewPager(position % list.size());
//            }
//        });
        return list.get(position % list.size());
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;

    }
}

