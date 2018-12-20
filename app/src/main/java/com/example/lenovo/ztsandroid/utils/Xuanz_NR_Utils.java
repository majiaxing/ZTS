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
import com.example.lenovo.ztsandroid.adapter.List_popup_Adapter;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/11/13.
 */

public class Xuanz_NR_Utils {



    public static ListView listView;
    public static List_popup_Adapter Gadapter;
    public static PopupWindow popupWindow;
    public static ArrayList<Spinner_Bean> nlist = new ArrayList<>();

    public static void upPopupWindow(View view ,TextView text) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.danc_popup_qh, null);
        popupView(v ,text);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);

    }

    public static void popupView(View v , final TextView text) {

        listView = v.findViewById(R.id.popup_listview);

        for (int i = 1; i <= 10; i++) {
            nlist.add(new Spinner_Bean("name" + i));
        }

        Gadapter = new List_popup_Adapter(App.activity, nlist);
        listView.setAdapter(Gadapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                text.setText(nlist.get(position).getPersonName());
                Log.e("点击传上去的数据", nlist.get(position).getPersonName());
                popupWindow.dismiss();
                nlist.clear();
                Gadapter.notifyDataSetChanged();
            }
        });

    }

}
