package com.example.lenovo.ztsandroid.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Read_XQ_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/22.
 */
public class XuanX_Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Read_XQ_Bean.DataBean.ReadQuestionListBean.ReadOptionListBean> channels = new ArrayList<>();

    public XuanX_Adapter(Context context, ArrayList<Read_XQ_Bean.DataBean.ReadQuestionListBean.ReadOptionListBean> channels) {
        this.context = context;
        this.channels = channels;
    }

    @Override
    public int getCount() {
        return channels.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder{

        public TextView textView;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.xz_tm_item,null);
            viewHolder.textView = convertView.findViewById(R.id.Xuanz_nr);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Read_XQ_Bean.DataBean.ReadQuestionListBean.ReadOptionListBean liveBean = channels.get(position);

        viewHolder.textView.setText(liveBean.getRead_option()+"."+liveBean.getRead_optionText());
        return convertView;
    }
}
