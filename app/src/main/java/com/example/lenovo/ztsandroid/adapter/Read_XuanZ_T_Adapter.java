package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Read_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.Read_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_T_Bean;
import com.example.lenovo.ztsandroid.view.MyListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/11/22.
 */

public class Read_XuanZ_T_Adapter extends BaseAdapter {
    private Context context;
    public ArrayList<Read_XQ_Bean.DataBean.ReadQuestionListBean> channels;
    private ZuoY_Xuanz_Adapter adapter;

    public Read_XuanZ_T_Adapter(Context context, ArrayList<Read_XQ_Bean.DataBean.ReadQuestionListBean> channels) {
        this.context = context;
        this.channels = channels;
    }


    @Override
    public int getCount() {
        return channels.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private HashMap mHashMap = new HashMap();
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (mHashMap.get(position) == null ){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.read_xianz_item,null);
            viewHolder.textView = convertView.findViewById(R.id.Item_Tm);
            viewHolder.radio_A = convertView.findViewById(R.id.Xuanz_btn_A);
            viewHolder.radio_B = convertView.findViewById(R.id.Xuanz_btn_B);
            viewHolder.radio_C = convertView.findViewById(R.id.Xuanz_btn_C);
            viewHolder.radio_D = convertView.findViewById(R.id.Xuanz_btn_D);
            viewHolder.text_A = convertView.findViewById(R.id.Xuanz_nr_A);
            viewHolder.text_B = convertView.findViewById(R.id.Xuanz_nr_B);
            viewHolder.text_C = convertView.findViewById(R.id.Xuanz_nr_C);
            viewHolder.text_D = convertView.findViewById(R.id.Xuanz_nr_D);
            mHashMap.put(position, convertView);
            convertView.setTag(viewHolder);

        }else {
            convertView = (View) mHashMap.get(position);
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Read_XQ_Bean.DataBean.ReadQuestionListBean liveBeanA = channels.get(position);
        viewHolder.textView.setText(liveBeanA.getRead_question());
//        viewHolder.radio_A.setText(liveBean.getRead_optionA()+"." +liveBean.getRead_optionTextA());
        viewHolder.text_A.setText(liveBeanA.getRead_optionList().get(0).getRead_option() + ". "+liveBeanA.getRead_optionList().get(0).getRead_optionText());

//        viewHolder.radio_B.setText(liveBean.getRead_optionB()+". "+liveBean.getRead_optionTextB());
        viewHolder.text_B.setText(liveBeanA.getRead_optionList().get(1).getRead_option() + ". "+liveBeanA.getRead_optionList().get(1).getRead_optionText());

//        viewHolder.radio_C.setText(liveBean.getRead_optionC());
        viewHolder.text_C.setText(liveBeanA.getRead_optionList().get(2).getRead_option() + ". "+liveBeanA.getRead_optionList().get(2).getRead_optionText());

//        viewHolder.radio_D.setText(liveBean.getRead_optionD());
        viewHolder.text_D.setText(liveBeanA.getRead_optionList().get(3).getRead_option() + ". "+liveBeanA.getRead_optionList().get(3).getRead_optionText());


        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.radio_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalViewHolder.radio_A.setChecked(true);
                finalViewHolder.radio_B.setChecked(false);
                finalViewHolder.radio_C.setChecked(false);
                finalViewHolder.radio_D.setChecked(false);

            }
        });
        viewHolder.radio_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalViewHolder.radio_A.setChecked(false);
                finalViewHolder.radio_B.setChecked(true);
                finalViewHolder.radio_C.setChecked(false);
                finalViewHolder.radio_D.setChecked(false);
            }
        });
        viewHolder.radio_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalViewHolder.radio_A.setChecked(false);
                finalViewHolder.radio_B.setChecked(false);
                finalViewHolder.radio_C.setChecked(true);
                finalViewHolder.radio_D.setChecked(false);
            }
        });
        viewHolder.radio_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalViewHolder.radio_A.setChecked(false);
                finalViewHolder.radio_B.setChecked(false);
                finalViewHolder.radio_C.setChecked(false);
                finalViewHolder.radio_D.setChecked(true);
            }
        });



        return convertView;
    }


    static class ViewHolder {
        public TextView textView;
        public CheckBox radio_A,radio_B ,radio_C ,radio_D;
        private TextView text_A,text_B,text_C,text_D;
    }
}
