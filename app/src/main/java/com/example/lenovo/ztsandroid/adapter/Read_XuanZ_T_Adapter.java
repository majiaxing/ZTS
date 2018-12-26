package com.example.lenovo.ztsandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.model.entity.Read_XQ_Bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/11/22.
 */

public class Read_XuanZ_T_Adapter extends BaseAdapter {
    private Context context;
    public ArrayList<Read_XQ_Bean.DataBean.ReadQuestionListBean> channels;
    private ArrayList<String> answer = new ArrayList<>();
    private ArrayList<String> read_qidList = new ArrayList<>();
    private ZuoY_Xuanz_Adapter adapter;
    public Read_XuanZ_T_Adapter(Context context, ArrayList<Read_XQ_Bean.DataBean.ReadQuestionListBean> channels) {
        this.context = context;
        this.channels = channels;
        for (int i = 0; i < channels.size(); i++) {
            answer.add("");
        }
        for (int a = 0;a<channels.size();a++){
            read_qidList.add("");
        }

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
//    private HashMap mHashMap = new HashMap();
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
//        if (mHashMap.get(position) == null){
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

//            mHashMap.put(position, convertView);
            convertView.setTag(viewHolder);
//        }else {
//            convertView = (View) mHashMap.get(position);
//            viewHolder = (ViewHolder) convertView.getTag();
//        }

        Read_XQ_Bean.DataBean.ReadQuestionListBean liveBeanA = channels.get(position);

        final String read_qid = liveBeanA.getRead_qid();

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
        viewHolder.XXA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.set(position,"A");
                read_qidList.set(position,read_qid);
                finalViewHolder.BF_A_Xuanz.setVisibility(View.VISIBLE);
                finalViewHolder.BF_B_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_C_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_D_Xuanz.setVisibility(View.GONE);

//                onItemlick.onlick(v,liveBean.getHw_answerId());

            }
        });
        viewHolder.XXB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.set(position,"B");
                read_qidList.set(position,read_qid);
                finalViewHolder.BF_A_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_B_Xuanz.setVisibility(View.VISIBLE);
                finalViewHolder.BF_C_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_D_Xuanz.setVisibility(View.GONE);
//                onItemlick.onlick(v,liveBean.getHw_answerId());
            }
        });
        viewHolder.XXC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.set(position,"C");
                read_qidList.set(position,read_qid);
                finalViewHolder.BF_A_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_B_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_C_Xuanz.setVisibility(View.VISIBLE);
                finalViewHolder.BF_D_Xuanz.setVisibility(View.GONE);
//                onItemlick.onlick(v,liveBean.getHw_answerId());
            }
        });
        viewHolder.XXD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.set(position,"D");
                read_qidList.set(position,read_qid);
                finalViewHolder.BF_A_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_B_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_C_Xuanz.setVisibility(View.GONE);
                finalViewHolder.BF_D_Xuanz.setVisibility(View.VISIBLE);
//                onItemlick.onlick(v,liveBean.getHw_answerId());
            }
        });

        return convertView;
    }

    public ArrayList<String>  getAnswer() {
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i).equals("")){
                return null;
            }
        }
        return answer;
    }

       public ArrayList<String>  getRead_qid() {

           for (int a = 0;a<channels.size();a++){
               if (read_qidList.get(a).equals("")){
                   return null;
               }
           }
           return read_qidList;
    }




    static class ViewHolder {
        public TextView textView;
        public TextView radio_A,radio_B ,radio_C ,radio_D;
        private TextView BF_A_Xuanz, BF_B_Xuanz,BF_C_Xuanz,BF_D_Xuanz;
        private TextView text_A,text_B,text_C,text_D;
        private LinearLayout XXA,XXB,XXC,XXD;
    }
}
