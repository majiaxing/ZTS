package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;

import com.example.lenovo.ztsandroid.fragment.task.xq_ym.ZY_Kw_Fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_DuanY_Fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_Duihua_Fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_JuZ_Fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_TingL_TK_Fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_TingL_XZ_Fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_YueDu_Fragment;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_erJ_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/23.
 */
public class ZY_ml_Adapter extends BaseAdapter{

    private ArrayList<ZuoY_erJ_Bean.DataBean.HomeworkTypeBean> list = new ArrayList<>();
    private Context context;

    public ZY_ml_Adapter(ArrayList<ZuoY_erJ_Bean.DataBean.HomeworkTypeBean> list, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.zy_ml_item,null);
            viewHolder.textView = convertView.findViewById(R.id.ZY_LeiX);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ZuoY_erJ_Bean.DataBean.HomeworkTypeBean liveBean = list.get(position);



        switch (liveBean.getHw_type()){
            case "2":

                viewHolder.textView.setText("单词" +"("+liveBean.getAvgScore() +")");
                break;
            case "0":
                viewHolder.textView.setText("音标"+"("+liveBean.getAvgScore() +")");
                break;
            case "8":
                viewHolder.textView.setText("短语"+"("+liveBean.getAvgScore() +")");
                break;
            case "1":
                viewHolder.textView.setText("课文"+"("+liveBean.getAvgScore() +")");
                break;
            case "3":

                viewHolder.textView.setText("句子"+"("+liveBean.getAvgScore() +")");
                break;
            case "5":
//                switch (liveBean.getListen_type()){
//                    case "1":
//                        viewHolder.textView.setText("听力选择"+"("+liveBean.getAvgScore() +")");
//                        break;
//                    case "2":
//                        viewHolder.textView.setText("听力填空"+"("+liveBean.getAvgScore() +")");
//                        break;
//                }
                viewHolder.textView.setText("听力"+"("+liveBean.getAvgScore() +")");
                break;
            case "6":
                viewHolder.textView.setText("阅读"+"("+liveBean.getAvgScore() +")");
                break;
            case "4":
                viewHolder.textView.setText("对话"+"("+liveBean.getAvgScore() +")");
                break;
        }


        return convertView;
    }


    public class ViewHolder{
        TextView textView;
    }


}
