package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Kw_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.utils.SetViewListener;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/2.
 */

public class Kw_sy_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<Kw_Xq_Bean.DataBean> channels;
    public Kw_sy_Adapter(Context context, ArrayList<Kw_Xq_Bean.DataBean> channels) {
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
            view = LayoutInflater.from(context).inflate(R.layout.kw_item,null);
            viewHolder.textView = view.findViewById(R.id.Jz_nr);
            viewHolder.layout = view.findViewById(R.id.CK_zs);
            viewHolder.textViewT = view.findViewById(R.id.Fy_text);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Kw_Xq_Bean.DataBean liveBean = channels.get(i);
        viewHolder.textView.setText(liveBean.getText_yw());
        viewHolder.textViewT.setText(liveBean.getText_zw());
        final ViewHolder finalViewHolder = viewHolder;

        final Boolean[] b = {false};
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            if (b[0]){
                b[0] =  false;
                finalViewHolder.textViewT.setVisibility(View.GONE);

            }else{
                b[0] =true;
                finalViewHolder.textViewT.setVisibility(View.VISIBLE);

            }


            }
        });

        return view;
    }

    static class ViewHolder {
        public TextView textView ,textViewT;
        public LinearLayout layout;
    }

}
