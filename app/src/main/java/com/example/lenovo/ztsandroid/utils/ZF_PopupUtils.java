package com.example.lenovo.ztsandroid.utils;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.Qrdd_Activity;

/**
 * Created by Administrator on 2018/10/31.
 */

public class ZF_PopupUtils {

    public static PopupWindow popupWindow;
    public static Button G_mai,E_ka;
    public static TextView text;
    public static LinearLayout fanH;




    public static void PopupW(View view , String str){


        final View inflate = View.inflate(App.activity, R.layout.zf_popup, null);
        popupWindow = new PopupWindow(inflate,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        G_mai= inflate.findViewById(R.id.Zfb_zf);
        E_ka  = inflate.findViewById(R.id.Vx_zf);
        fanH = inflate.findViewById(R.id.Q_X);
        text = inflate.findViewById(R.id.text);
        text.setText(str);
        G_mai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        E_ka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        fanH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                backgroundAlpha(1f);
            }
        });
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAtLocation(inflate, Gravity.CENTER,0,0);
        backgroundAlpha(0.5f);
        popupWindow.showAsDropDown(inflate,100,100);


    }
    public static void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = App.activity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        App.activity.getWindow().setAttributes(lp);
        App.activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    public static void PopupDimiss(){
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
    }

}
