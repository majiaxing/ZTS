package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.XX_Activity;
import com.example.lenovo.ztsandroid.fragment.QuanB_XX_Fragment;
import com.example.lenovo.ztsandroid.model.entity.Model;
import com.example.lenovo.ztsandroid.model.entity.XX_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.SetViewListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.R.id.list;

/**
 * Created by Administrator on 2018/11/2.
 */

public class XX_Adapter extends BaseAdapter implements OnItemListener{

    private Context context;
    public ArrayList<XiaoX_Bean.DataBean> channels;
    private Boolean mIsShow = false;
    private QuanB_XX_Fragment.AllCheckListener allCheckListener;
    private String id ,id1;


    public XX_Adapter(Context context, ArrayList<XiaoX_Bean.DataBean> channels ,QuanB_XX_Fragment.AllCheckListener allCheckListener ) {
        this.context = context;
        this.channels = channels;
        this.allCheckListener = allCheckListener;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
       ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.xx_list_item,null);
            viewHolder.touxiang = view.findViewById(R.id.A_Image_TX);
            viewHolder.title = view.findViewById(R.id.title);
            viewHolder.neirong = view.findViewById(R.id.neirong);
            viewHolder.data = view.findViewById(R.id.data);
            viewHolder.Wd_Ts = view.findViewById(R.id.Wd_Ts);
            viewHolder.lin = view.findViewById(R.id.linear);
            viewHolder.Xuanz_item = view.findViewById(R.id.XuanZ_item);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        XiaoX_Bean.DataBean liveBean = channels.get(i);

        viewHolder = (ViewHolder) view.getTag();
        final ViewHolder hdFinal = viewHolder;
        viewHolder.Xuanz_item.setChecked(liveBean.ischeck());

        MyLog.e("消息发布的时间",liveBean.getNewtime());
        String substring = liveBean.getNewtime().substring(0, 10);
        MyLog.e("消息发布的时间",substring);
        viewHolder.data.setText(substring);

        viewHolder.Xuanz_item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    channels.get(i).setIscheck(true);
                    id = String.valueOf(channels.get(i).getId());
                }else {
                    channels.get(i).setIscheck(false);
                    id = String.valueOf(channels.get(i).getId());
                }
            }
        });
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CheckBox checkBox = hdFinal.Xuanz_item;
//                if (checkBox.isChecked()) {
//                    checkBox.setChecked(false);
//                    channels.get(i).setIscheck(false);
//                } else {
//                    checkBox.setChecked(true);
//                    channels.get(i).setIscheck(true);
//                }
//                //监听每个item，若所有checkbox都为选中状态则更改main的全选checkbox状态
//                for ( XiaoX_Bean.DataBean liveBean : channels) {
//                    if (!liveBean.ischeck()) {
//                        allCheckListener.onCheckedChanged(false);
//                        return;
//                    }
//                }
//                allCheckListener.onCheckedChanged(true);
//
//
//            }
//        });
        switch (liveBean.getNewtype()){
            case "作业消息":
                Glide.with(context).load(R.drawable.zuoy).into(viewHolder.touxiang);
                break;
            case "学习资料":
                Glide.with(context).load(R.drawable.jiaoy).into(viewHolder.touxiang);
                break;
            case "系统消息":
                Glide.with(context).load(R.drawable.xit).into(viewHolder.touxiang);
                break;
        }

        viewHolder.title.setText(liveBean.getNewtype());
        viewHolder.neirong.setText(liveBean.getNewcontent());
        if (liveBean.getNewstate().equals("1")){

            viewHolder.Wd_Ts.setVisibility(View.GONE);

        }else if (liveBean.getNewstate().equals("0")){

            viewHolder.Wd_Ts.setVisibility(View.VISIBLE);
        }


        if (mIsShow) {
            viewHolder.Xuanz_item.setVisibility(View.VISIBLE);
        } else {
            viewHolder.Xuanz_item.setVisibility(View.GONE);
        }

//        viewHolder.data.setText(liveBean.getData());

//        if (boo){
//            App.textView.setVisibility(View.GONE);
//        }else {
//            App.textView.setText(liveBean.getWdxx());
//        }
        return view;
    }

    @Override
    public void onClickeListener(Boolean isShow) {
        mIsShow = isShow;
        notifyDataSetChanged();
    }

    @Override
    public String onClickeID() {

        return id;
    }

    class ViewHolder {
        public ImageView touxiang;
        public TextView title,Wd_Ts;
        public TextView neirong;
        public TextView data;
        public LinearLayout lin;
        public CheckBox Xuanz_item;

    }
}

interface OnItemListener {
    void onClickeListener(Boolean isShow);
    String onClickeID();
}
