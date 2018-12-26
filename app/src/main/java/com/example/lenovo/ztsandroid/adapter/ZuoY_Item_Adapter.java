package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Zuoy_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/12/9.
 */
public class ZuoY_Item_Adapter extends BaseAdapter{

    private Context context;
    public ArrayList<Spinner_Zuoy_Bean.DataBean> channels;

    public ZuoY_Item_Adapter(Context context, ArrayList<Spinner_Zuoy_Bean.DataBean> channels) {
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
    private HashMap mHashMap = new HashMap();
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (mHashMap.get(i) == null ){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.zuoy_item_tiaomo,null);
            viewHolder.textView = view.findViewById(R.id.T_H);
            viewHolder.textView_XZ = view.findViewById(R.id.T_H_XZ);
            mHashMap.put(i, view);
            view.setTag(viewHolder);

        }else {
            view = (View) mHashMap.get(i);
            viewHolder = (ViewHolder) view.getTag();
        }
        Spinner_Zuoy_Bean.DataBean liveBean = channels.get(i);
        viewHolder.textView.setText(liveBean.getSize()+"");
        viewHolder.textView_XZ.setText(liveBean.getSize()+"");

        String value = liveBean.getValue();
        if (!value.equals("")){
            viewHolder.textView.setBackgroundResource(R.drawable.yizuo);
        }

        return view;
    }

    static class ViewHolder {
        public TextView textView,textView_XZ;

    }
}
