package com.example.lenovo.ztsandroid.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Environment;
import android.view.View;

import com.example.lenovo.ztsandroid.R;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018/11/24.
 */

public class MediaPlayerUtils {



    public static MediaPlayer mp = new MediaPlayer();



    public static void button_play(View view, Context context){

        if (!mp.isPlaying()) {
            openRawMusicS(context);
        }

    }

    public static void button_pause(View view){

        if (mp.isPlaying()) {
            mp.pause();//暂停播放
        }

    }
    public static void button_stop(View view){

        mp.reset();//将mp重置为创建状态


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
    public static void openRawMusicS(Context context) {
        mp = MediaPlayer.create(context, R.raw.mmmm);
        //用prepare方法，会报错误java.lang.IllegalStateExceptio
        //mediaPlayer.prepare();
        mp.start();
    }



}
