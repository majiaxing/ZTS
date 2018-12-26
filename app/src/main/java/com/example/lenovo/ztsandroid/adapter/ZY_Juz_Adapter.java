package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.DuiH_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_D_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Dh_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/11/2.
 */

public class ZY_Juz_Adapter extends BaseAdapter {

    private Context context;
    public ArrayList<ZuoY_Dh_Bean.DataBean.TypeListBean> channels;

    public ZY_Juz_Adapter(Context context, ArrayList<ZuoY_Dh_Bean.DataBean.TypeListBean> channels) {
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
            viewHolder.BF_Ly = view.findViewById(R.id.BF_LY);
            viewHolder.textViewA = view.findViewById(R.id.BF_LY_A);
            viewHolder.textViewB = view.findViewById(R.id.BF_LY_B);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        ZuoY_Dh_Bean.DataBean.TypeListBean liveBean = channels.get(i);
        viewHolder.textView.setText(liveBean.getJuese_yw());

//        viewHolder.Text.setText(liveBean.getValue());
//        Boolean aBoolean = false;

//        ArrayList list = new ArrayList();
//        String s,d;
//        MyLog.e("SDSAKAAAAA",channels.size() +"");
//        for(int b = 0 ;b < channels.size(); b ++) {
//            s = "A:" + channels.get(b);
////            d = "B:" + channels.get(b+1);
//            list.set(0,s);
////            list.set(1,d);
//            i++;
//
//            MyLog.e("SDSAKAAAAA",list.toString());
//
//        }
//         if (channels.get(i).getJuese_yw().equals(channels.get(0).getJuese_yw())){
////            aBoolean = false;
//             viewHolder.BF_Ly.setBackgroundResource(R.drawable.a_bg);
//             viewHolder.BF_Ly.setText("A");
//        }else {
//             viewHolder.BF_Ly.setBackgroundResource(R.drawable.b_bg);
//             viewHolder.BF_Ly.setText("B");
//        }
//        if (channels.size() == 0){
////            aBoolean = true;
//            viewHolder.BF_Ly.setBackgroundResource(R.drawable.a_bg);
//            viewHolder.BF_Ly.setText("A");
//        }

        if (liveBean.getJS() == true){
            MyLog.e("我是B","woshiBBB");
            viewHolder.textViewB.setVisibility(View.VISIBLE);

        }else{
            MyLog.e("我是A","woshiAAA");
            viewHolder.textViewA.setVisibility(View.VISIBLE);

        }
        return view;
    }

    static class ViewHolder {
        public TextView textView;
        public TextView Text;
        public TextView BF_Ly;
        public TextView textViewB,textViewA;
    }

}
