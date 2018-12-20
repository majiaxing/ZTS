package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.view.MyListView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/2.
 */

public class Zm_zh_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<YB_XQ_four_Bean.DataBean> channels;
    private ArrayList<YB_XQ_four_Bean.DataBean.WordBean> list = new ArrayList<>();
    private Yb_dancizuhe_Adapter madapter;
    public Zm_zh_Adapter(Context context, ArrayList<YB_XQ_four_Bean.DataBean> channels) {
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
            view = LayoutInflater.from(context).inflate(R.layout.zm_zh_grid_item,null);
            viewHolder.textView = view.findViewById(R.id.zm_item);
            viewHolder.Listview = view.findViewById(R.id.List_dc_zh_item);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        YB_XQ_four_Bean.DataBean liveBean = channels.get(i);
        viewHolder.textView.setText(liveBean.getYb_symbol());

        list.addAll(liveBean.getWord());
        madapter = new Yb_dancizuhe_Adapter(context,list);
        viewHolder.Listview.setAdapter(madapter);
        return view;
    }

    static class ViewHolder {
        public TextView textView;
        private MyListView Listview;
    }

}
