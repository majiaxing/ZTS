package com.example.lenovo.ztsandroid;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.base.BaseActivity;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/25.
 */

public class LuY_Activity extends BaseActivity {


    @BindView(R.id.kaish)
    Button kaish;
    @BindView(R.id.zhant)
    Button zhant;
    @BindView(R.id.jieshu)
    Button jieshu;
    @BindView(R.id.bofang)
    Button bofang;
    @BindView(R.id.bofang_jieshu)
    Button bofangJieshu;

    private TextView time;

    private MediaRecorder mediaRecorder = new MediaRecorder();  //用于录音
    private File file = new File("/mnt/sdcard", "new.amr");  //创建一个临时的音频文件
    private MediaPlayer mediaPlayer = new MediaPlayer();  //用于播放录音
    private long currenttime;  //用于确定当前录音时间
    private boolean isrecording = false;  //用于判断当前是否在录音
    private boolean Isplaying = false;  //用于判断是否正在处于播放录音状态


    //定义Handler
    private Handler volumehandler=new Handler();  //显示音量
    private Handler timehandler=new Handler();  //显示录音时间
    private Handler playhandler=new Handler();  //显示播放时间


    private Runnable runnable_1=new Runnable() {  //音量
        @Override
        public void run() {
            int volume=0;
            int ratio;
            ratio = mediaRecorder.getMaxAmplitude() / 600;
            if(ratio>1){
                volume= (int) (20 * Math.log10(ratio));
            } //将getMaxAmplitude()的返回值转换为分贝
            volumehandler.postDelayed(runnable_1, 100);
        }
    };

    private Runnable runnable_2=new Runnable() {//录音时间
        @Override
        public void run() {
            time.setText(getTime((int) (System.currentTimeMillis()-currenttime)));
//调用前先获取当前时间，再通过System.currentTimeMillis()-currenttime获得录音时间并转换成文本
            timehandler.postDelayed(runnable_2,1000);
        }
    };

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final int REQUEST_EXTERNAL_STORAGET = 2;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.RECORD_AUDIO"};

    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGET);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected int getLayoutId() {

        verifyStoragePermissions(this);
        return R.layout.cs_lu_y_activity;
    }

    @Override
    protected void initView() {
    time = (TextView) findViewById(R.id.luyshij);
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }
    private Runnable runnable_3=new Runnable() {//播放时间
        @Override
        public void run() {
            time.setText(getTime(mediaPlayer.getCurrentPosition()));
//MediaPlayer类的getCurrentPosition()方法可以获得音频的当前播放时间
            playhandler.postDelayed(runnable_3,1000);
        }
    };

    private String getTime(int timeMs) {
        int total=timeMs/1000;
        StringBuilder stringBuilder=new StringBuilder();
        Formatter formatter=new Formatter(stringBuilder, Locale.getDefault());
        int seconds=total%60;
        int minutes=(total/60)%60;
        int hours=total/3600;
        stringBuilder.setLength(0);
        if (hours>0){
            return formatter.format("%d:%02d:%02d",hours,minutes,seconds).toString();
        }
        else{
            return formatter.format("%02d:%02d",minutes,seconds).toString();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.kaish, R.id.zhant, R.id.jieshu, R.id.bofang, R.id.bofang_jieshu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.kaish:

                if (!isrecording){
                    record();
                }


                break;
            case R.id.zhant:

                break;
            case R.id.jieshu:

                if (isrecording){
                   stop();
                }

                break;
            case R.id.bofang:

                if(!mediaPlayer.isPlaying()){
                    play();
                }

                break;
            case R.id.bofang_jieshu:

                if(mediaPlayer.isPlaying()){
                    play();
                }
                break;
        }
    }

    private void record(){
        if(file.exists()) {
            file.delete();
        }
        mediaRecorder.reset();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //设置音频来源为麦克风
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        //默认的输出格式和编码方式
        mediaRecorder.setOutputFile(file.getAbsolutePath());//指定音频输出路径
        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaRecorder.start();//开始录音
//        start.setImageResource(ic_media_pause);
        isrecording=true;
        currenttime=System.currentTimeMillis();
        volumehandler.postDelayed(runnable_1,100);
        timehandler.postDelayed(runnable_2,1000);
    }

    private void stop(){
        mediaRecorder.stop();
//        start.setImageResource(btn_radio);
        volumehandler.removeCallbacks(runnable_1);
        timehandler.removeCallbacks(runnable_2);//停止相关线程
        time.setText("00:00");
        isrecording=false;
        Toast.makeText(this,"录音完成！", Toast.LENGTH_SHORT).show();
    }

    private void play(){
        if(!Isplaying) {
            if (file != null && file.exists()) {
                try {
                    mediaPlayer.setDataSource(this, Uri.fromFile(file));//设置音频来源
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(this, "未发现录音文件", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Isplaying = true;
        }
        mediaPlayer.start();//开始播放
//        play.setImageResource(ic_media_pause);
        playhandler.postDelayed(runnable_3,1000);
    }

    private void pause(){
        mediaPlayer.pause();
        playhandler.removeCallbacks(runnable_3);
//        play.setImageResource(ic_media_play);
    }


    MediaPlayer.OnCompletionListener playerListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
//            play.setImageResource(ic_media_play);
            playhandler.removeCallbacks(runnable_3);
            time.setText("00:00");
            Isplaying=false;
            mediaPlayer.reset();
        }
    };




}
