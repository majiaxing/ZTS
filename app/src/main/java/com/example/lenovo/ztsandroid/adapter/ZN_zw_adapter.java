package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/5.
 */

public class ZN_zw_adapter extends BaseAdapter {

    private Context context;
    public ArrayList<Spinner_Bean> channels;

    public ZN_zw_adapter(Context context, ArrayList<Spinner_Bean> channels) {
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
            view = LayoutInflater.from(context).inflate(R.layout.zn_zw_listview_item,null);
            viewHolder.textView = view.findViewById(R.id.item_title);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Spinner_Bean liveBean = channels.get(i);
        viewHolder.textView.setText(liveBean.getPersonName());
        return view;
    }

    static class ViewHolder {
        public TextView textView;
    }
}
