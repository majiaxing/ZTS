package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Dy_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/2.
 */

public class List_duanY_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<Dy_Xq_Bean.DataBean> channels;

    public List_duanY_Adapter(Context context, ArrayList<Dy_Xq_Bean.DataBean> channels) {
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
            view = LayoutInflater.from(context).inflate(R.layout.list_popup_item,null);
            viewHolder.textView = view.findViewById(R.id.Nr_item);
            viewHolder.textbtn = view.findViewById(R.id.Zt_item);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Dy_Xq_Bean.DataBean liveBean = channels.get(i);
        viewHolder.textView.setText(liveBean.getPhrase());

        return view;
    }

    static class ViewHolder {
        public TextView textView,textbtn;

    }

}
