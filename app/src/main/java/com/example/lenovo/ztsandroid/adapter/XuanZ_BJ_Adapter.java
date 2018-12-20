package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.BanJBean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/12/5.
 */

public class XuanZ_BJ_Adapter extends BaseAdapter {
    private Context context;
    public ArrayList<BanJBean.DataBean> channels;

    public XuanZ_BJ_Adapter(Context context, ArrayList<BanJBean.DataBean> channels) {
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
            view = LayoutInflater.from(context).inflate(R.layout.list_banj_xz_item,null);
            viewHolder.textView = view.findViewById(R.id.BanJ_XZ);
            view.setTag(viewHolder);
        }else {
            viewHolder = (List_popup_Adapter.ViewHolder) view.getTag();
        }

        BanJBean.DataBean liveBean = channels.get(i);
        viewHolder.textView.setText(liveBean.getClassName());



        return view;
    }

    static class ViewHolder {
        public CheckBox textView;

    }
}
