package com.example.lenovo.ztsandroid.activity;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.fragment.CSFragment;
import com.example.lenovo.ztsandroid.utils.ConfigFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bofang)
    Button bofang;
    String string;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {


    }

    //媒体播放器 定义成员变量
    private MediaPlayer mediaPlayer;
    public void play_onclick(View view) {
        if (mediaPlayer == null) {
            //调用MediaPlayer的静态方法create
            mediaPlayer = MediaPlayer.create(App.activity, Uri.parse(string));
        }

        mediaPlayer.start();

        bofang.setText("播放状态：正在播放。。。");
    }


    public void stop_onclick(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();//停止
            mediaPlayer.reset();//重置
            mediaPlayer.release();//释放资源
            mediaPlayer = null;//重新赋值为空
        }
        bofang.setText("播放状态：停止播放。。。");
    }

    public void pause_onclick(View view) {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();

            bofang.setText("播放状态：暂停播放。。。");
        }
    }
    public void exit_onclick(View view) {
        stop_onclick(view);
        finish();
    }




    @Override
    public void initData() {

    }

    public void loadData() {
//        ConfigFragment.getInstance().init().start(CSFragment.class).build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bofang)
    public void onViewClicked() {


    }
}
