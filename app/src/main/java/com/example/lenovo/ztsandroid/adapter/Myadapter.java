package com.example.lenovo.ztsandroid.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2018/10/24.
 */

public class Myadapter extends BaseAdapter {

    private Context context;
    public ArrayList<CeSBean.LiveBean> channels;

    public Myadapter(Context context, ArrayList<CeSBean.LiveBean> channels) {
        this.context = context;
        this.channels = channels;
    }

    @Override
    public int getCount() {
        return channels.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.cs_listview_item,null);
            viewHolder.textView = view.findViewById(R.id.list_item_text);
            viewHolder.imageView = view.findViewById(R.id.list_item_image);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        CeSBean.LiveBean liveBean = channels.get(i);
        viewHolder.textView.setText(liveBean.getTitle());
        Glide.with(context).load(liveBean.getImage()).into(viewHolder.imageView);
        MyLog.e("图片数据",liveBean.getImage());
        return view;
    }

    static class ViewHolder {
        public TextView textView;
        public ImageView imageView;
    }


}
