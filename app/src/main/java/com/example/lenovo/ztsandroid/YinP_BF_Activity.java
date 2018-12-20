package com.example.lenovo.ztsandroid;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

/**
 * Created by Administrator on 2018/12/1.
 */

public class YinP_BF_Activity extends AppCompatActivity implements View.OnClickListener{


    /**
     * Hello World!
     */
    private Button mBtn;
    MediaPlayer mediaPlayer = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.text);
        mBtn.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁当前activity  音乐暂停
        mediaPlayer.stop();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.text:
                startmusic();
                break;
        }
    }

    private void startmusic() {

        try {
            mediaPlayer.setDataSource("http://sc1.111ttt.cn:8282/2018/1/03m/13/396131229550.m4a?tflag=1519095601&pin=6cd414115fdb9a950d827487b16b5f97#.mp3");
            //3 准备播放
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
