package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Kw_erji_list_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/2.
 */

public class kw_nr_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<Kw_erji_list_Bean.DataBean> channels;

    public kw_nr_Adapter(Context context, ArrayList<Kw_erji_list_Bean.DataBean> channels) {
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
            view = LayoutInflater.from(context).inflate(R.layout.kw_neir_item,null);
            viewHolder.textView = view.findViewById(R.id.NR_item);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Kw_erji_list_Bean.DataBean liveBean = channels.get(i);
        viewHolder.textView.setText(liveBean.getText_title());

        return view;
    }

    static class ViewHolder {
        public TextView textView;
    }

}
