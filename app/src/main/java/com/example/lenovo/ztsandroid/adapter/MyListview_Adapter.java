package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.JiaoC_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/2.
 */

public class MyListview_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<YB_XQ_one_Bean.DataBean> channels;

    public MyListview_Adapter(Context context, ArrayList<YB_XQ_one_Bean.DataBean> channels) {
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
            view = LayoutInflater.from(context).inflate(R.layout.yb_one_item,null);
            viewHolder.textView = view.findViewById(R.id.yb_one_item);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        YB_XQ_one_Bean.DataBean liveBean = channels.get(i);
//        MyLog.e("GridView得到的数据",liveBean.getJclx()+liveBean.getNj()+liveBean.getSxc());
//        Log.e("AAAAAAAAABBBBBAAAAA",liveBean.getYb_word()+"");

            viewHolder.textView.setText("vt."+liveBean.getYb_translate());


        return view;
    }

    static class ViewHolder {
        public TextView textView;
    }

}
