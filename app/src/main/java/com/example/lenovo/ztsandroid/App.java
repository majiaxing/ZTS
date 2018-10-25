package com.example.lenovo.ztsandroid;

import android.app.Application;
import android.widget.RadioGroup;

import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.base.BaseFragment;


/**
 * Created by Lenovo on 2017/10/16.
 */

public class App extends Application {

    public static BaseActivity context = null;

    public static RadioGroup mRadiogroup;

    public static BaseActivity activity;

    public static BaseFragment lastFragment;

}