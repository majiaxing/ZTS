package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/11/7.
 */

public class DetailsPhotoPageAdapter extends PagerAdapter {

    private ArrayList<Spinner_Bean> mPhoto;
    private Context mContext;
    private int mSize;

    public DetailsPhotoPageAdapter(Context context, ArrayList<Spinner_Bean> photo) {
        mPhoto = photo;
        mContext = context;
        mSize = mPhoto.size();
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;   //实现无限滑动
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position = position % mSize;        //永远不越界
        View view = LayoutInflater.from(mContext).inflate(R.layout.viewpager_danci, null);
        TextView textView = (TextView) view.findViewById(R.id.Nr_danci);
        Spinner_Bean spinner_bean = mPhoto.get(position);
        textView.setText(spinner_bean.getPersonName());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


}
