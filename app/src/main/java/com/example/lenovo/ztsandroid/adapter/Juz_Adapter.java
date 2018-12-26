package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.DuiH_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/2.
 */

public class Juz_Adapter extends BaseAdapter implements OnListener{

    private Context context;
    public ArrayList<DuiH_XQ_Bean.DataBean> channels;
    private  Boolean mIsShow = false;
    public Juz_Adapter(Context context, ArrayList<DuiH_XQ_Bean.DataBean> channels) {
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
            view = LayoutInflater.from(context).inflate(R.layout.juz_item,null);
            viewHolder.textView = view.findViewById(R.id.Jz_nr);
            viewHolder.Text = view.findViewById(R.id.Fan_Y);
            viewHolder.textViewB = view.findViewById(R.id.BF_LY_B);
            viewHolder.textViewA = view.findViewById(R.id.BF_LY_A);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        DuiH_XQ_Bean.DataBean liveBean = channels.get(i);
        viewHolder.textView.setText(liveBean.getJuese_yw());
        viewHolder.Text.setText(liveBean.getJuese_zw());


        if (liveBean.getJS() == true){
            MyLog.e("我是B","woshiBBB");
            viewHolder.textViewB.setVisibility(View.VISIBLE);
        }else{
            MyLog.e("我是A","woshiAAA");
            viewHolder.textViewA.setVisibility(View.VISIBLE);

        }





        if (mIsShow) {
            viewHolder.Text.setVisibility(View.VISIBLE);
        } else {
            viewHolder.Text.setVisibility(View.GONE);
        }


        return view;
    }

    @Override
    public void onClickeListener(Boolean isShow) {
        mIsShow = isShow;
    }

    static class ViewHolder {
        public TextView textView;
        public TextView Text;
        public TextView textViewB ,textViewA;
    }

}
interface OnListener {
    void onClickeListener(Boolean isShow);
}
