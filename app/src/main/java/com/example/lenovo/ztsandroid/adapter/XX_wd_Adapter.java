package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_Bean;
import com.example.lenovo.ztsandroid.utils.SetViewListener;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/2.
 */

public class XX_wd_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<XiaoX_Bean.DataBean> channels;
    public SetViewListener listner;
    public XX_wd_Adapter(Context context, ArrayList<XiaoX_Bean.DataBean> channels ) {
        this.context = context;
        this.channels = channels;
    }
    public void SetViewListner(SetViewListener listner) {
        this.listner = listner;
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

        viewHolder.Xuanz_item.setVisibility(View.GONE);
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

            viewHolder.lin.setVisibility(View.GONE);
        }







        return view;
    }

    static class ViewHolder {
        public ImageView touxiang;
        public TextView title,Wd_Ts;
        public TextView neirong;
        public TextView data;
        public TextView wdxx;
        public LinearLayout lin;
        private CheckBox Xuanz_item;
    }
}
