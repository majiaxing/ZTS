package com.example.lenovo.ztsandroid.fragment.study.yb_sy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.TiaoZan_Activity;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.YB_XiangQ_Cotract;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_three_Bean;
import com.example.lenovo.ztsandroid.presenter.YB_Two_XQ_Presenter;
import com.example.lenovo.ztsandroid.presenter.YB_three_Xq_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/6.
 */

public class YB_xq_three_fragment extends BaseFragment implements YB_XiangQ_Cotract.View ,View.OnClickListener{


    TextView YBTitle;

    CheckBox BFCsFay;

    CheckBox CsFayLY;

    Button TZYXT;

    CheckBox BFangSelf;

    private Bundle bundle;
    private String yBid;
    private YB_XiangQ_Cotract.Presenter presenter;
    private String symbol;


    private MediaRecorder mediaRecorder = new MediaRecorder();  //用于录音
    private File file = new File("/mnt/sdcard", System.currentTimeMillis()+".mp3");  //创建一个临时的音频文件
    private MediaPlayer mediaPlayer = new MediaPlayer();  //用于播放录音
    private MediaPlayer mPlayer = new MediaPlayer();  //用于播放音频
    private long currenttime;  //用于确定当前录音时间
    private boolean isrecording = false;  //用于判断当前是否在录音
    private boolean Isplaying = false;  //用于判断是否正在处于播放录音状

    private String save_path;
    private String hw_answerId;



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (mPlayer == null){
            mPlayer = new MediaPlayer();
        }
        if (!isVisibleToUser){
//            mediaPlayer.start();
            mPlayer.stop();
        }else {
            try {
                mPlayer = null;
                mPlayer = new MediaPlayer();
                mPlayer.setDataSource("http://sc1.111ttt.cn:8282/2018/1/03m/13/396131229550.m4a?tflag=1519095601&pin=6cd414115fdb9a950d827487b16b5f97#.mp3");
                //3 准备播放
                mPlayer.prepareAsync();
                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {

                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
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
//        volumehandler.postDelayed(runnable_1,100);
//        timehandler.postDelayed(runnable_2,1000);
    }

    private void stop(){
        mediaRecorder.stop();
//        start.setImageResource(btn_radio);
//        volumehandler.removeCallbacks(runnable_1);
//        timehandler.removeCallbacks(runnable_2);//停止相关线程
//        time.setText("00:00");
        isrecording=false;
        Toast.makeText(App.activity,"录音完成！", Toast.LENGTH_SHORT).show();

//        relativeLayout.setVisibility(View.VISIBLE);
//        next_t.setVisibility(View.VISIBLE);



    }

    private void play(){
        if(!Isplaying) {
            if (file != null && file.exists()) {
                try {
                    mediaPlayer.setDataSource(App.activity, Uri.fromFile(file));//设置音频来源
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(App.activity, "未发现录音文件", Toast.LENGTH_SHORT).show();
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
//        playhandler.postDelayed(runnable_3,1000);
    }

    private void pause(){
        mediaPlayer.pause();
//        playhandler.removeCallbacks(runnable_3);
//        play.setImageResource(ic_media_play);
    }



    @Override
    protected int getLayoutId() {
        return R.layout.yb_xq_three_fragment;
    }

    @Override
    protected void init(View view) {
        YBTitle = view.findViewById(R.id.YB_title);
        BFCsFay = view.findViewById(R.id.BF_cs_fay);
        CsFayLY = view.findViewById(R.id.Cs_fay_lY);
        TZYXT = view.findViewById(R.id.TZ_YX_t);
        BFangSelf = view.findViewById(R.id.B_fang_self);

        TZYXT.setOnClickListener(this);
        BFangSelf.setOnClickListener(this);
        CsFayLY.setOnClickListener(this);
        BFCsFay.setOnClickListener(this);

        yBid = bundle.getString("YBid");

        presenter = new YB_three_Xq_Presenter(this);
        presenter.SetUrl(yBid,"3","");
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setParams(Bundle bundle) {
    this.bundle = bundle;
    }




    @Override
    public void getManager(YB_XQ_four_Bean yb_bean) {


    }

    @Override
    public void getManagerO(YB_XQ_one_Bean yb_xq_one_bean) {

    }

    @Override
    public void getManagerT(YB_XQ_Two_Bean yb_xq_two_bean) {

    }

    @Override
    public void getManagerR(YB_XQ_one_Bean yb_xq_one_bean) {

    }

    @Override
    public void getManagerTh(YB_XQ_three_Bean postYinB_XQ_three) {
        symbol = postYinB_XQ_three.getData().get(0).getSymbol();

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                YBTitle.setText(symbol);
            }
        });


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(YB_XiangQ_Cotract.Presenter presenter) {

    }


    final Boolean[] b = {false};
    private Boolean[] aBoolean = {false};
    private Boolean[] bool  = {false};

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BF_cs_fay:

                if (bool[0]){
                    if (mPlayer.isPlaying()){
                        MyLog.e("lalall","ahahahahh");
                        mPlayer.pause();
                    }
                    bool[0] = false;
                }else {
                    if (!mPlayer.isPlaying()){
                        MyLog.e("holle dnsjk","ahahahahh");
                        mPlayer.start();
                    }
                    bool[0] = true;
                }


                break;
            case R.id.Cs_fay_lY:

                if (b[0]){

                    if (isrecording){
                        stop();


                    }
                    b[0] = false;

                }else {
                    if (!isrecording){
                        record();
                    }
                    b[0] = true;
                }

                break;
            case R.id.TZ_YX_t:

                Intent intent = new Intent(App.activity,TiaoZan_Activity.class);
                intent.putExtra("YB_id",yBid);
                startActivity(intent);

                break;
            case R.id.B_fang_self:
                if (aBoolean[0]){

                    if (mediaPlayer.isPlaying()){

                        pause();
                    }
                    aBoolean[0] = false;

                }else {
                    if (!mediaPlayer.isPlaying()){
                        play();
                    }
                    aBoolean[0] = true;

                }

                break;
        }
    }
}
