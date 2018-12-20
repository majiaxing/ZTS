package com.example.lenovo.ztsandroid.utils;

import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by Administrator on 2018/12/1.
 */

public class YP_BF_Utils {

    public  static MediaPlayer mediaPlayer = new MediaPlayer();

    public static void start(String url) {

        try {
            mediaPlayer.setDataSource(url);
            //3 准备播放
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    if (!mediaPlayer.isPlaying()){
                        mediaPlayer.start();
                    }

                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pause(String url) {

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();//暂停播放
        }
    }


     public static void stop(String url) {

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();//暂停播放
        }
    }







}
