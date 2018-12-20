package com.example.lenovo.ztsandroid.utils;

import android.content.Context;

/**
 * Created by Administrator on 2018/10/30.
 */

public class ScreenUtils {

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
    /**
     * 获取屏幕宽度(px)
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

}
