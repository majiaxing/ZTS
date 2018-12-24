package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Spinner_T_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.OnItemlick;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/11/22.
 */

public class Read_zy_O_Adapter extends BaseAdapter{

    private Context context;
    public ArrayList<Spinner_T_Bean> channels;
    private Boolean mIsShow = false;
    OnItemlick onItemlick;

    public void setOnItemlick(OnItemlick onItemlick){
        this.onItemlick = onItemlick;
    }

    public Read_zy_O_Adapter(Context context, ArrayList<Spinner_T_Bean> channels ) {
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
            viewHolder.text_A = convertView.findViewById(R.id.Xuanz_nr_A);
            viewHolder.text_B = convertView.findViewById(R.id.Xuanz_nr_B);
            viewHolder.text_C = convertView.findViewById(R.id.Xuanz_nr_C);
            viewHolder.text_D = convertView.findViewById(R.id.Xuanz_nr_D);

            viewHolder.BF_A_Xuanz = convertView.findViewById(R.id.BF_A_Xuanz);
            viewHolder.BF_B_Xuanz = convertView.findViewById(R.id.BF_B_Xuanz);
            viewHolder.BF_C_Xuanz = convertView.findViewById(R.id.BF_C_Xuanz);
            viewHolder.BF_D_Xuanz = convertView.findViewById(R.id.BF_D_Xuanz);


            viewHolder.XXA = convertView.findViewById(R.id.XXA);
            viewHolder.XXB = convertView.findViewById(R.id.XXB);
            viewHolder.XXC = convertView.findViewById(R.id.XXC);
            viewHolder.XXD = convertView.findViewById(R.id.XXD);

            mHashMap.put(position, convertView);
            convertView.setTag(viewHolder);
        }else {
            convertView = (View) mHashMap.get(position);
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Spinner_T_Bean liveBean = channels.get(position);
        viewHolder.textView.setText(liveBean.getPersonName());
//        viewHolder.radio_A.setText(liveBean.getRead_optionA()+"." +liveBean.getRead_optionTextA());
        viewHolder.text_A.setText(liveBean.getRead_optionA()+"." +liveBean.getRead_optionTextA());

//        viewHolder.radio_B.setText(liveBean.getRead_optionB()+". "+liveBean.getRead_optionTextB());
        viewHolder.text_B.setText(liveBean.getRead_optionB()+". "+liveBean.getRead_optionTextB());

//        viewHolder.radio_C.setText(liveBean.getRead_optionC());
        viewHolder.text_C.setText(liveBean.getRead_optionC()+". "+liveBean.getRead_optionTextC());

//        viewHolder.radio_D.setText(liveBean.getRead_optionD());
        viewHolder.text_D.setText(liveBean.getRead_optionD()+". "+liveBean.getRead_optionTextD());


        final ViewHolder finalViewHolder = viewHolder;
        final String read_answer = liveBean.getRead_answer();
        MyLog.e("真确选项",liveBean.getRead_answer());
        viewHolder.XXA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalViewHolder.BF_A_Xuanz.setVisibility(View.VISIBLE);
                finalViewHolder.BF_B_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_C_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_D_Xuanz.setVisibility(View.GONE);

                onItemlick.onlick(v,liveBean.getHw_answerId());

            }
        });
          viewHolder.XXB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalViewHolder.BF_A_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_B_Xuanz.setVisibility(View.VISIBLE);
                finalViewHolder.BF_C_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_D_Xuanz.setVisibility(View.GONE);
                onItemlick.onlick(v,liveBean.getHw_answerId());
            }
        });
          viewHolder.XXC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalViewHolder.BF_A_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_B_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_C_Xuanz.setVisibility(View.VISIBLE);
                finalViewHolder.BF_D_Xuanz.setVisibility(View.GONE);
                onItemlick.onlick(v,liveBean.getHw_answerId());
            }
        });
          viewHolder.XXD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finalViewHolder.BF_A_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_B_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_C_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_D_Xuanz.setVisibility(View.VISIBLE);
                onItemlick.onlick(v,liveBean.getHw_answerId());
            }
        });



        if (mIsShow){
        if ( finalViewHolder.BF_A_Xuanz.getVisibility() == View.VISIBLE){
                if (liveBean.getRead_optionA().equals(read_answer)) {
                    finalViewHolder.radio_A.setBackgroundResource(R.drawable.ture);
                    finalViewHolder.text_A.setTextColor(App.activity.getResources().getColor(R.color.colortext));
                } else {
                    finalViewHolder.radio_A.setBackgroundResource(R.drawable.false_cuo);
                    finalViewHolder.text_A.setTextColor(App.activity.getResources().getColor(R.color.text_color_red));
                    if (read_answer.equals(liveBean.getRead_optionB())) {
                        finalViewHolder.radio_B.setBackgroundResource(R.drawable.ture);
                        finalViewHolder.text_B.setTextColor(App.activity.getResources().getColor(R.color.colortext));

                    } else if (read_answer.equals(liveBean.getRead_optionC())) {

                        finalViewHolder.radio_C.setBackgroundResource(R.drawable.ture);
                        finalViewHolder.text_C.setTextColor(App.activity.getResources().getColor(R.color.colortext));

                    } else if (read_answer.equals(liveBean.getRead_optionD())) {

                        finalViewHolder.radio_D.setBackgroundResource(R.drawable.ture);
                        finalViewHolder.text_D.setTextColor(App.activity.getResources().getColor(R.color.colortext));
                    }
                }
        }else if (finalViewHolder.BF_B_Xuanz.getVisibility() == View.VISIBLE){
                if (liveBean.getRead_optionB().equals(read_answer)){
                    finalViewHolder.radio_B.setBackgroundResource(R.drawable.ture);
                    finalViewHolder.text_B.setTextColor(App.activity.getResources().getColor(R.color.colortext));
                }else {
                    finalViewHolder.radio_B.setBackgroundResource(R.drawable.false_cuo);
                    finalViewHolder.text_B.setTextColor(App.activity.getResources().getColor(R.color.text_color_red));

                    if (read_answer.equals(liveBean.getRead_optionA())){

                        finalViewHolder.radio_A.setBackgroundResource(R.drawable.ture);
                        finalViewHolder.text_A.setTextColor(App.activity.getResources().getColor(R.color.colortext));

                    }else if (read_answer.equals(liveBean.getRead_optionC())){

                        finalViewHolder.radio_C.setBackgroundResource(R.drawable.ture);
                        finalViewHolder.text_C.setTextColor(App.activity.getResources().getColor(R.color.colortext));

                    }else if (read_answer.equals(liveBean.getRead_optionD())){

                        finalViewHolder.radio_D.setBackgroundResource(R.drawable.ture);
                        finalViewHolder.text_D.setTextColor(App.activity.getResources().getColor(R.color.colortext));
                    }
            }
        }else if (finalViewHolder.BF_C_Xuanz.getVisibility() == View.VISIBLE){
                if (liveBean.getRead_optionC().equals(read_answer)){
                    finalViewHolder.radio_C.setBackgroundResource(R.drawable.ture);
                    finalViewHolder.text_C.setTextColor(App.activity.getResources().getColor(R.color.colortext));
                }else {
                    finalViewHolder.radio_C.setBackgroundResource(R.drawable.false_cuo);
                    finalViewHolder.text_C.setTextColor(App.activity.getResources().getColor(R.color.text_color_red));

                    if (read_answer.equals(liveBean.getRead_optionA())){

                        finalViewHolder.radio_A.setBackgroundResource(R.drawable.ture);
                        finalViewHolder.text_A.setTextColor(App.activity.getResources().getColor(R.color.colortext));

                    }else if (read_answer.equals(liveBean.getRead_optionB())){

                        finalViewHolder.radio_B.setBackgroundResource(R.drawable.ture);
                        finalViewHolder.text_B.setTextColor(App.activity.getResources().getColor(R.color.colortext));

                    }else if (read_answer.equals(liveBean.getRead_optionD())){

                        finalViewHolder.radio_D.setBackgroundResource(R.drawable.ture);
                        finalViewHolder.text_D.setTextColor(App.activity.getResources().getColor(R.color.colortext));
                    }
            }
        }else if (finalViewHolder.BF_D_Xuanz.getVisibility() == View.VISIBLE){
                if (liveBean.getRead_optionD().equals(read_answer)){
                    finalViewHolder.radio_D.setBackgroundResource(R.drawable.ture);
                    finalViewHolder.text_D.setTextColor(App.activity.getResources().getColor(R.color.colortext));
                }else {
                    finalViewHolder.radio_D.setBackgroundResource(R.drawable.false_cuo);
                    finalViewHolder.text_C.setTextColor(App.activity.getResources().getColor(R.color.text_color_red));

                    if (read_answer.equals(liveBean.getRead_optionA())){

                        finalViewHolder.radio_A.setBackgroundResource(R.drawable.ture);
                        finalViewHolder.text_D.setTextColor(App.activity.getResources().getColor(R.color.colortext));

                    }else if (read_answer.equals(liveBean.getRead_optionB())){

                        finalViewHolder.radio_B.setBackgroundResource(R.drawable.ture);
                        finalViewHolder.text_D.setTextColor(App.activity.getResources().getColor(R.color.colortext));

                    }else if (read_answer.equals(liveBean.getRead_optionC())){

                        finalViewHolder.radio_C.setBackgroundResource(R.drawable.ture);
                        finalViewHolder.text_D.setTextColor(App.activity.getResources().getColor(R.color.colortext));
                    }
                }
        }
        }

        return convertView;
    }

//    private void onItemlick(View v) {
//
//    }
//
//    @Override
//    public void onClickeListener(Boolean isShow) {
//
//        mIsShow = isShow;
//        notifyDataSetChanged();
//
//    }


    static class ViewHolder {
        public TextView textView;
        public TextView radio_A,radio_B ,radio_C ,radio_D;
        private TextView BF_A_Xuanz, BF_B_Xuanz,BF_C_Xuanz,BF_D_Xuanz;
        private TextView text_A,text_B,text_C,text_D;
        private LinearLayout XXA,XXB,XXC,XXD;
    }





}




interface OnItemClickeListener {
    void onClickeListener(Boolean isShow);
}
