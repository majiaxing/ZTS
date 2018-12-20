package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.TingL_TK_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_TL_xz_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/9.
 */

public class ZuoY_TX_Xuanz_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<ZuoY_TL_xz_Bean.DataBean.TypeListBean.ListenQuestionListBean.ListenOptionListBean> channels;
    public ZuoY_TX_Xuanz_Adapter(Context context, ArrayList<ZuoY_TL_xz_Bean.DataBean.TypeListBean.ListenQuestionListBean.ListenOptionListBean> channels) {
        this.context = context;
        this.channels = channels;
    }


    private int temp = -6;

    @Override
    public int getCount() {
        // TODO  Auto-generated method stub
        return channels.size();
    }

    @Override
    public Object getItem(int position)  {
        // TODO Auto-generated method stub
        return  null;
    }

    @Override
    public long getItemId(int  position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View  getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView == null){
            convertView =App.activity.getLayoutInflater().inflate(R.layout.xz_tm_item,  null);
            holder = new Holder();
            holder.radioButton = convertView.findViewById(R.id.Xuanz_btn);
            holder.text = (TextView) convertView.findViewById(R.id.Xuanz_nr);
            convertView.setTag(holder);
        }else{
            holder =  (Holder) convertView.getTag();
        }



        ZuoY_TL_xz_Bean.DataBean.TypeListBean.ListenQuestionListBean.ListenOptionListBean listBean = channels.get(position);

        holder.text.setText(listBean.getListen_option() + ". "+listBean.getListen_optionContent());

        holder.text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(App.activity, "button", Toast.LENGTH_SHORT).show();
            }
        });





        return  convertView;
    }
    private class Holder{
        private TextView text;
        private RadioButton radioButton;
    }
}
