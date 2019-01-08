package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_list_Bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.lenovo.ztsandroid.R.drawable.zy_list_item_bg_w;

/**
 * Created by Administrator on 2018/11/23.
 */
public class ZY_lsit_Adapter extends BaseAdapter{

    private ArrayList<ZuoY_list_Bean.DataBean> list = new ArrayList<>();
    private Context context;

    public ZY_lsit_Adapter(ArrayList<ZuoY_list_Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.zy_list_item,null);

            viewHolder.textView = convertView.findViewById(R.id.ZY_title);
            viewHolder.zuoY_Data = convertView.findViewById(R.id.ZY_data);
            viewHolder.JZ_data = convertView.findViewById(R.id.Jz_Data);
            viewHolder.layout = convertView.findViewById(R.id.layout);
            viewHolder.linear = convertView.findViewById(R.id.linear);
            viewHolder.FenS = convertView.findViewById(R.id.FenS);
            viewHolder.ZT_wc = convertView.findViewById(R.id.ZT_wc);
            viewHolder.ZT_wc_W = convertView.findViewById(R.id.ZT_wc_W);
            viewHolder.TZWC = convertView.findViewById(R.id.ZT_WC);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ZuoY_list_Bean.DataBean liveBean = list.get(position);
        viewHolder.textView.setText(liveBean.getHomewordName());


        String startTime = liveBean.getStartTime();
        String s = startTime.substring(0, 10);


        SimpleDateFormat formatter   =   new   SimpleDateFormat   ("yyyy年MM月dd日");
        Date curDate =  new Date(System.currentTimeMillis());
        String   str   =   formatter.format(curDate);

        if (s.equals(str)){
            viewHolder.zuoY_Data.setText("今日作业");
            viewHolder.layout.setBackgroundResource(R.drawable.zy_list_item_bg_w);


        }else {
            viewHolder.zuoY_Data.setText(s);
            viewHolder.layout.setBackgroundResource(R.drawable.zy_list_item_bg);

        }


        String endTime = liveBean.getEndTime();
        String nian = endTime.substring(0, 4);
        String yue = endTime.substring(5,7);
        String ri = endTime.substring(8,10);
        viewHolder.JZ_data.setText("截止日期："+nian+"年"+yue+"月"+ri+"日");

        String scoreAll = liveBean.getScoreAll();

        if (scoreAll  == null) {

            viewHolder.ZT_wc_W.setVisibility(View.GONE);
            viewHolder.ZT_wc.setVisibility(View.GONE);
        }else{

            if (scoreAll.equals("待完成")) {

                viewHolder.linear.setVisibility(View.GONE);
                viewHolder.ZT_wc.setVisibility(View.VISIBLE);
                viewHolder.ZT_wc_W.setVisibility(View.GONE);
            }else if (scoreAll.equals("0")){
                viewHolder.linear.setVisibility(View.GONE);
                viewHolder.ZT_wc.setVisibility(View.VISIBLE);
                viewHolder.ZT_wc_W.setVisibility(View.GONE);

            } else {
                viewHolder.FenS.setText(scoreAll);
                viewHolder.ZT_wc.setVisibility(View.GONE);
                viewHolder.ZT_wc_W.setVisibility(View.VISIBLE);
                viewHolder.TZWC.setText("已完成");
                viewHolder.TZWC.setTextColor(App.activity.getResources().getColor(R.color.pe_text_bg_gray));
                viewHolder.TZWC.setBackgroundResource(R.drawable.yiwc);

            }
        }
        return convertView;
    }
    public class ViewHolder{
        TextView textView;
        TextView zuoY_Data;
        TextView JZ_data;
        LinearLayout layout,linear;
        TextView FenS;
        TextView ZT_wc,ZT_wc_W,TZWC;
    }


}
