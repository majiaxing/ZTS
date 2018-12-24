package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/5.
 */

public class Yb_Grid_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<YB_Bean.DataBean> channels;

    public Yb_Grid_Adapter(Context context, ArrayList<YB_Bean.DataBean> channels) {
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
        List_XX_Adapter.ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new List_XX_Adapter.ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.yb_grid_item,null);
            viewHolder.textView = view.findViewById(R.id.YB_text);
            view.setTag(viewHolder);
        }else {
            viewHolder = (List_XX_Adapter.ViewHolder) view.getTag();
        }

        YB_Bean.DataBean liveBean = channels.get(i);
        viewHolder.textView.setText(liveBean.getSymbol());
        return view;
    }

    static class ViewHolder {
        public TextView textView;
    }
}
