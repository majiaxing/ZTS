package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/19.
 */

public class Yb_dancizuhe_Adapter extends BaseAdapter{

    private ArrayList<YB_XQ_four_Bean.DataBean.WordBean> list = new ArrayList<>();
    private Context context;
    public Yb_dancizuhe_Adapter(Context context, ArrayList<YB_XQ_four_Bean.DataBean.WordBean> channels) {
        this.context = context;
        this.list = channels;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class Holder{
        private TextView zh_O;
        private TextView text_O;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder = null;
        if (convertView == null){
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.yb_nr_item,null);
            holder.zh_O = convertView.findViewById(R.id.zh_O);
            holder.text_O = convertView.findViewById(R.id.text_O);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

        YB_XQ_four_Bean.DataBean.WordBean liveBean = list.get(position);
        holder.zh_O.setText(liveBean.getYb_sym_word());
        holder.text_O.setText("["+liveBean.getYb_sym_tran()+"]");
        return convertView;
    }
}
