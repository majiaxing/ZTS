package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.JiaoC_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/2.
 */

public class Grid_popup_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<JiaoC_Bean.DataBean> channels;

    public Grid_popup_Adapter(Context context, ArrayList<JiaoC_Bean.DataBean> channels) {
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
            view = LayoutInflater.from(context).inflate(R.layout.grid_popup_item,null);
            viewHolder.textView = view.findViewById(R.id.nr);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        JiaoC_Bean.DataBean liveBean = channels.get(i);
        Log.e("AAAAAAAAABBBBBAAAAA",liveBean.getJclx()+"");
        viewHolder.textView.setText(liveBean.getJclx()+liveBean.getNj()+liveBean.getSxc());
        return view;
    }

    static class ViewHolder {
        public TextView textView;
    }

}
