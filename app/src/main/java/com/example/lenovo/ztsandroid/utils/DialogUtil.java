package com.example.lenovo.ztsandroid.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lenovo.ztsandroid.R;

/**
 * Created by Administrator on 2018/10/30.
 */

public class DialogUtil {

    private Dialog dialog;
    private View inflate;

    //中间显示的dialog
    public void showCentreDialog(Context context) {
        //自定义dialog显示布局
        inflate = LayoutInflater.from(context).inflate(R.layout.popup_item, null);
        //自定义dialog显示风格
        dialog = new Dialog(context, R.style.DialogCentre);
        //点击其他区域消失
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        wlp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(wlp);
        dialog.show();
    }

    //关闭dialog时调用
    public void close() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }



}
