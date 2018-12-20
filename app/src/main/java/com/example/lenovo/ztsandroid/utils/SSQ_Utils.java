package com.example.lenovo.ztsandroid.utils;

import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.List_xiali_Adapter;
import com.example.lenovo.ztsandroid.model.entity.Diq_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/12/4.
 */

public class SSQ_Utils {


    private static List_xiali_Adapter Gadapter;
    private static ListView listView;
    private static PopupWindow popupWindow;
    private static ArrayList<Diq_Bean.DataBean> nlist = new ArrayList<>();
    private static TextView NJSpinner;
    private static  String sqID;


    public  SSQ_Utils(ArrayList<Diq_Bean.DataBean> nlist, TextView NJSpinner ) {
        this.nlist = nlist;
        this.NJSpinner = NJSpinner;
    }

    public static void upPopupWindow(View view) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.danc_popup_qh, null);
        popupView(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);

    }

    public static void popupView(View v ) {

        listView = v.findViewById(R.id.popup_listview);

        Gadapter = new List_xiali_Adapter(App.activity, nlist);
        listView.setAdapter(Gadapter);
        Gadapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NJSpinner.setText(nlist.get(position).getSheng_name());
                Log.e("点击传上去的数据", nlist.get(position).getSheng_name());
                sqID = nlist.get(position).getSheng_id();
                popupWindow.dismiss();
                Gadapter.notifyDataSetChanged();
            }
        });

    }




}
