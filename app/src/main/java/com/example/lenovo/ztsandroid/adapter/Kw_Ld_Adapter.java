package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/2.
 */

public class Kw_Ld_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<Kw_Bean.DataBean> channels;

    public Kw_Ld_Adapter(Context context, ArrayList<Kw_Bean.DataBean> channels) {
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
            view = LayoutInflater.from(context).inflate(R.layout.kew_ld_item,null);
            viewHolder.title = view.findViewById(R.id.kw_title_item);
            viewHolder.kw_image_item = view.findViewById(R.id.kw_image_item);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Kw_Bean.DataBean liveBean = channels.get(i);
//        viewHolder.nr.setText(liveBean.getType());
        viewHolder.title.setText(liveBean.getDy());
        String photos = liveBean.getPhotos();
        String relative_path = liveBean.getRelative_path();
        String str = "https://zts100.com/demo/file/download" + "/?" + "Relative_path=" + relative_path + "&" + "type=1" + "&" + "fileName=" +photos;
        Glide.with(App.activity).load(str).into(viewHolder.kw_image_item);
        return view;
    }


    static class ViewHolder {
        public TextView title ,nr;
        private ImageView kw_image_item;
    }

}
