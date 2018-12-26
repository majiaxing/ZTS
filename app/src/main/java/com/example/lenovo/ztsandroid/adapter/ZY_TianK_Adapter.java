package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.TingL_XQ_xz_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_TL_xz_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/9.
 */

public class ZY_TianK_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<ZuoY_TL_xz_Bean.DataBean.TypeListBean> channels;
    public ZY_TianK_Adapter(Context context, ArrayList<ZuoY_TL_xz_Bean.DataBean.TypeListBean> channels) {
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
    private int i = 1;

    @Override
    public View  getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView == null){
            convertView =App.activity.getLayoutInflater().inflate(R.layout.tk_tm_item,  null);
            holder = new Holder();
            convertView.setTag(holder);
        }else{
            holder =  (Holder) convertView.getTag();
        }

        holder.text = (TextView) convertView.findViewById(R.id.Tk_Nr);

        holder.editText = convertView.findViewById(R.id.edit_TK);

        holder.text.setText(i+". "+channels.get(position).getListen_content());
        i++;
        return  convertView;
    }
    private class Holder{
        private TextView text;
        private EditText editText;
    }
}
