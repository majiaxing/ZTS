package com.example.lenovo.ztsandroid.base;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.utils.StatusBarUtil;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;


/**
 * Created by lx on 2017/7/11.
 */

public abstract class BaseActivity extends AutoLayoutActivity {
    private FragmentManager fragmentManager;


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final int REQUEST_EXTERNAL_STORAGET = 2;
    private static final int REQUEST_EXTERNAL_STORAGETH = 4;
    private static final int REQUEST_EXTERNAL_STORAGEF = 5;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.RECORD_AUDIO",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.RECORD_AUDIO"
    };

    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGET);
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGETH);
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGEF);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verifyStoragePermissions(App.activity);
        setContentView(getLayoutId());


        //判断权限够不够，不够就给
        if (ContextCompat.checkSelfPermission(BaseActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(BaseActivity.this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 1);
        }

        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
//        StatusBarUtil.setRootViewFitsSystemWindows(this,true);
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
//        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
//            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
//            //这样半透明+白=灰, 状态栏的文字能看得清
//            StatusBarUtil.setStatusBarColor(this,0x55000000);
//        }



        ButterKnife.bind(this);
        App.activity = this;
        initView();
        initData();
        loadData();
//        if (ContextCompat.checkSelfPermission(BaseActivity.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(BaseActivity.this, new String[]{android.Manifest.permission.CAMERA, android.Manifest.permission.VIBRATE}, 1);
//        }

    }

private boolean mFlag;
    @Override
    protected void onResume() {
        super.onResume();
        //记住当前的BaseActivity
        App.activity = this;
        //当页面可见时加载数据

        App.activity = this;
        if(mFlag) {
            loadData();
            mFlag=false;
        }

    }

    public void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //加载布局
    protected abstract int getLayoutId();

    //初始化view
    protected abstract void initView();

    //初始化数据
    public abstract void initData();

    //加载数据
    public abstract void loadData();



}
