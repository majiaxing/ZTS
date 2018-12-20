package com.example.lenovo.ztsandroid;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.ztsandroid.utils.YinY_Utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018/11/24.
 */

public class Main_CS_Activity extends AppCompatActivity implements View.OnClickListener {

    private Button playButton;
    private Button pausebutton;
    private Button stopButton;
    private MediaPlayer mp = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yy);
        playButton = (Button)findViewById(R.id.button_play);
        pausebutton = (Button)findViewById(R.id.button_pause);
        stopButton = (Button)findViewById(R.id.button_stop);
        initMP();//初始化mp对象
        //三个按钮设置监听器
        playButton.setOnClickListener(this);
        pausebutton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_play:
                if (!mp.isPlaying()) {
//                    mp.start();//播放音频
                    openRawMusicS();
                }



                break;
            case R.id.button_pause:



                break;
            case R.id.button_stop:
                mp.reset();//将mp重置为创建状态
                initMP();//初始化mp，这样保证按下stop按钮后再按play按钮可以播放
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp != null) {
            //释放mp
            mp.stop();
            mp.release();
        }
    }

    //初始化mp
    private void initMP() {
        File file = new File(Environment.getExternalStorageDirectory(), "好久不见-陈奕迅.mp3");
        try {
            mp.setDataSource(file.getPath());//设置播放音频文件的路径
            mp.prepare();//mp就绪
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 打开raw目录下的音乐mp3文件
     */
    private void openRawMusicS() {
        mp = MediaPlayer.create(this, R.raw.mmmm);
        //用prepare方法，会报错误java.lang.IllegalStateExceptio
        //mediaPlayer.prepare();
        mp.start();
    }




}
