package com.example.lenovo.ztsandroid.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Read_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_T_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/22.
 */
public class ZuoY_Xuanz_Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Spinner_T_Bean> channels = new ArrayList<>();

    public ZuoY_Xuanz_Adapter(Context context, ArrayList<Spinner_T_Bean> channels) {
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
        Spinner_T_Bean liveBean = channels.get(position);
//        viewHolder.textView.setText(liveBean.getPersonName()+"."+liveBean.getPresonValue());
//
//        MyLog.e("List选项里面的数据",liveBean.getPersonName()+"."+liveBean.getPresonValue());

        return convertView;
    }
}
