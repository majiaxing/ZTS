package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Dc_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/28.
 */

public class Tiaoz_Adapter extends BaseAdapter{


    private Context context;
    public ArrayList<YB_XQ_one_Bean.DataBean> channels;

    public Tiaoz_Adapter(Context context, ArrayList<YB_XQ_one_Bean.DataBean> channels) {
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
        List_popup_Adapter.ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new List_popup_Adapter.ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.list_popup_item,null);
            viewHolder.textView = view.findViewById(R.id.Nr_item);
            viewHolder.textbtn = view.findViewById(R.id.Zt_item);
            view.setTag(viewHolder);
        }else {
            viewHolder = (List_popup_Adapter.ViewHolder) view.getTag();
        }

        YB_XQ_one_Bean.DataBean liveBean = channels.get(i);
        viewHolder.textView.setText(liveBean.getYb_word());

        return view;
    }

    static class ViewHolder {
        public TextView textView,textbtn;

    }


}
