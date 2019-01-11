package com.example.lenovo.ztsandroid.fragment;

import android.Manifest;
import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.cotract.ZhiL_Yuyin_Cotract;
import com.example.lenovo.ztsandroid.model.entity.SC_YX_Bean;
import com.example.lenovo.ztsandroid.model.entity.Stdey_Bean;
import com.example.lenovo.ztsandroid.model.entity.YuYinPinG_Bean;
import com.example.lenovo.ztsandroid.presenter.Lu_SC_Stdey_Presenter;
import com.example.lenovo.ztsandroid.presenter.Lu_Study_Presenter;
import com.example.lenovo.ztsandroid.presenter.PinC_Fay_presenter;
import com.example.lenovo.ztsandroid.presenter.ZhiL_Csh_Fy_Presenter;
import com.example.lenovo.ztsandroid.utils.ConvertUtil;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.ZhiL_Key_Velue;
import com.example.lenovo.ztsandroid.view.CustomProgressDialog;
import com.example.lenovo.ztsandroid.view.RippleIntroView;
import com.tencent.cloud.soe.TencentSOE;
import com.tencent.cloud.soe.model.InitOralProcessResponse;
import com.tencent.cloud.soe.model.SOECallback;
import com.tencent.cloud.soe.model.SOEError;
import com.tencent.cloud.soe.model.TransmitOralProcessResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.NumberUtil;

import static com.example.lenovo.ztsandroid.App.activity;
import static com.example.lenovo.ztsandroid.utils.ZhiL_Key_Velue.MSG_INIT_OK;

/**
 * Created by Administrator on 2018/11/12.
 */

public class DanCi_fragment extends BaseFragment implements View.OnClickListener,ZhiL_Yuyin_Cotract.View{

    private RelativeLayout relativeLayout;
    private LinearLayout bf_ly;
    private Button next_t;
    private RadioButton CheckO, CheckT,CheckOXanz,CheckTXanz;
    private TextView dc_jx_text;
    private Bundle bundle;
    private TextView title;
    private TextView YeMa;
    private MediaRecorder mediaRecorder = new MediaRecorder();  //用于录音
    private File file = new File("/mnt/sdcard", System.currentTimeMillis()+".mp3");  //创建一个临时的音频文件
    private MediaPlayer mPlayer = new MediaPlayer();  //用于播放音频

    private String save_path;
    private String hw_answerId;
    private Boolean bbbb = false;
    private ZhiL_Yuyin_Cotract.Presenter presenter;
    private String s;
    private String word_id;
    private String type;
    private String relative_path;
    private String word_video;
    private String word;
    private String sessionId;

    private TextView pf_fs;
    private RatingBar xinx_bar;
    private TextView gl_;
    private RippleIntroView rippleIntroView;
    private LinearLayout linearLayout;
    private ImageView pinF_jd;
    private Animation hyperspaceJumpAnimation;
    private CheckBox ly_btn;
    private CheckBox bf_zt;
    private Boolean[] bool  = {false};

    //评估 返回结果
    private Handler mMyHandler = new Handler(new HandlerCallback());

    class HandlerCallback implements Handler.Callback {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_INIT_OK:
                    toast("初始化成功");
                    break;
                case ZhiL_Key_Velue.MSG_INIT_ERROR:
                    MyLog.e("评估结果",msg.obj.toString());
                    break;
                case ZhiL_Key_Velue.MSG_TRANSMIT_OK:
                    int index = msg.arg1;
                    int isEnd = msg.arg2;
                    MyLog.e("完成度",index + (isEnd == 1 ? " - 已完成" : " - 未完成"));
                    break;
                case ZhiL_Key_Velue.MSG_TRANSMIT_ERROR:
                    MyLog.e("评估结果",msg.obj.toString());
                    break;
                case ZhiL_Key_Velue.MSG_ERROR:
                    MyLog.e("评估结果",msg.obj.toString());
                    break;
            }
            return true;
        }
    }




    @Override
    protected int getLayoutId() {
        return R.layout.viewpager_danci;
    }

//    动态获取权限
    public void getPersimmions() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.System.canWrite(App.activity)) {
                    requestPermissions(new String[]{
                            Manifest.permission.RECORD_AUDIO,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    }, 10);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void init(View view) {

        getPersimmions();
//初始化控件
        title = view.findViewById(R.id.Nr_danci);
        CheckO = view.findViewById(R.id.BF_One);
        CheckOXanz = view.findViewById(R.id.BF_One_Xuanz);
        CheckTXanz = view.findViewById(R.id.BF_Two_Xuanz);
        CheckT = view.findViewById(R.id.BF_Two);

//初始化点击事件
        CheckO.setOnClickListener(this);
        CheckT.setOnClickListener(this);
        CheckOXanz.setOnClickListener(this);
        CheckTXanz.setOnClickListener(this);

        dc_jx_text = view.findViewById(R.id.dc_jx_text);
        relativeLayout = view.findViewById(R.id.relativeLayout);
        pf_fs = view.findViewById(R.id.PF_fs);
        gl_ = view.findViewById(R.id.GL_);
        xinx_bar = view.findViewById(R.id.Xinx_bar);
        next_t = view.findViewById(R.id.next_T);
        bf_ly = view.findViewById(R.id.BF_LY);
        rippleIntroView = view.findViewById(R.id.Ripple);
        linearLayout = view.findViewById(R.id.linear);
        pinF_jd = view.findViewById(R.id.PinF_jd);
        YeMa = view.findViewById(R.id.textView3);
//        定义评估加载的 动画
        hyperspaceJumpAnimation = AnimationUtils.loadAnimation(activity, R.anim.loading_animation);
        // 使用ImageView显示动画
        pinF_jd.startAnimation(hyperspaceJumpAnimation);
        bf_zt = view.findViewById(R.id.BF_zt);
        ly_btn = view.findViewById(R.id.Ly_btn);
        bf_ly.setOnClickListener(this);
        bf_zt.setOnClickListener(this);
        ly_btn.setOnClickListener(this);
        next_t.setOnClickListener(this);
        title.setText("shit");
        String yema = bundle.getString("yema");
        String dangq = bundle.getString("dangq");
        MyLog.e("一共有————",yema);
//        Toast.makeText(App.activity, dangq+"一共有_"+yema,Toast.LENGTH_LONG).show();
        YeMa.setText(dangq+"/"+yema);
        relativeLayout.setVisibility(View.GONE);
        next_t.setVisibility(View.GONE);


//        creatAudioRecord();
    }

//     评估 的toast
    private void toast(String text) {
        final Toast toast = Toast.makeText(App.activity, text, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, 1000);
    }


    private static final String TAG = "AudioRecordActivity";
    private int bufferSizeInBytes = 0;//缓冲区大小
    //音频获取来源
    private int audioSource = MediaRecorder.AudioSource.MIC;
    //设置音频的采样率，44100是目前的标准，但是某些设备仍然支持22050,16000,11025
    private static int sampleRateInHz = 16000;
    //设置音频的录制声道，CHANNEL_IN_STEREO 为双声道，CHANNEL_CONFIGURATION_MONO 为单声道
    private static int channelConfig = AudioFormat.CHANNEL_CONFIGURATION_MONO;
    //设置音频数据格式:PCM 16位每个样本，保证设备支持。PCM 8位每个样本，不一定能得到设备的支持。
    private static int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
    //AudioName裸音频数据文件
    private static final String AudioName = "/sdcard/love.raw";
    //NewAudioName可播放的音频文件
    private static final String NewAudioName = "/sdcard/"+System.currentTimeMillis()+".wav";

    private AudioRecord audioRecord;

    //播放音频
    private MediaPlayer mediaPlayer;


    private boolean isRecord = false;//设置录制状态

    // 初始化录音
    private void creatAudioRecord() {
        //根据AudioRecord的音频采样率、音频录制声道、音频数据格式获取缓冲区大小
        bufferSizeInBytes = AudioRecord.getMinBufferSize(sampleRateInHz, channelConfig, audioFormat);
        Log.d(TAG, "creatAudioRecord-->bufferSizeInBytes="+bufferSizeInBytes);

        //根据音频获取来源、音频采用率、音频录制声道、音频数据格式和缓冲区大小来创建AudioRecord对象
        audioRecord = new AudioRecord(audioSource, sampleRateInHz, channelConfig, audioFormat, bufferSizeInBytes);

        //创建播放实例
        mediaPlayer = new MediaPlayer();
    }

    private final class PrepareListener implements MediaPlayer.OnPreparedListener {

        @Override
        public void onPrepared(MediaPlayer mp) {
            // TODO Auto-generated method stub
            mediaPlayer.start();//开始播放
        }

    }

    /**
     * 播放录制的音频
     */
    private void playMusic() {


//        byte[] bytes = readBytesFromFile(NewAudioName);
//        byte[] bytes1 = byteMerger(bytes);
//        writeBytesToFileClassic(bytes1,NewAudioName);

        File file = new File(NewAudioName);
        if(file.exists()) {
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(filePath);
                mediaPlayer.prepare();//进行数据缓冲
                mediaPlayer.setOnPreparedListener(new PrepareListener());
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SecurityException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalStateException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    /**
     * 开始录制音频
     */
    private void startAudioRecord() {

        if (audioRecord != null){
            audioRecord.startRecording();//开始录制
            isRecord = true;
            new AudioRecordThread().start();//开启线程来把录制的音频数据保留下来
        } else {
            audioRecord = new AudioRecord(audioSource,sampleRateInHz, channelConfig, audioFormat, bufferSizeInBytes);
            audioRecord.startRecording();//开始录制
            isRecord = true;
            new AudioRecordThread().start();//开启线程来把录制的音频数据保留下来
        }
    }

    /**
     * 停止录制音频
     */
    private void  stopAudioRecord() {
        close();
        File file = new File(NewAudioName);

        byte[] bytes = FileUtil.readBytes(file);
        String toBase64 = Base64Encoder.encode(bytes, CharsetUtil.CHARSET_ISO_8859_1);

        if (sessionId != null){
//            mProgressDialog = new CustomProgressDialog(App.activity,R.style.loading_dialog);
//            mProgressDialog.show();

            linearLayout.setVisibility(View.VISIBLE);
            ly_btn.setVisibility(View.GONE);

            presenter = new PinC_Fay_presenter(this);
            presenter.seturlZhiL("1", "1", "2","1",toBase64, sessionId);
        }
    }
//    结束录音
    private void close() {
        if (audioRecord != null) {

            System.out.println("stopRecord");
            isRecord = false;//停止文件写入
            audioRecord.stop();
            audioRecord.release();//释放资源
            audioRecord = null;
        }
    }

    /**
     * 音频数据写入线程
     * @author Administrator
     *
     */
    class AudioRecordThread extends Thread {
        @Override
        public void run()
        {
            super.run();
            writeDataToFile();//把录制的音频裸数据写入到文件中去
            copyWaveFile(AudioName, NewAudioName);//给裸数据加上头文件
        }
    }
    /**
     * 把录制的音频裸数据写入到文件中去
     * 这里将数据写入文件，但是并不能播放，因为AudioRecord获得的音频是原始的裸音频，
     * 如果需要播放就必须加入一些格式或者编码的头信息。但是这样的好处就是你可以对音频的 裸数据进行处理，比如你要做一个爱说话的TOM
     * 猫在这里就进行音频的处理，然后重新封装 所以说这样得到的音频比较容易做一些音频的处理。
     */
    private void writeDataToFile() {
        // new一个byte数组用来存一些字节数据，大小为缓冲区大小
        byte[] audioData = new byte[bufferSizeInBytes];
        int readSize = 0;
        FileOutputStream fos = null;
        File file = new File(AudioName);
        if(file.exists())
            file.delete();
        try
        {
            fos = new FileOutputStream(file);//获取一个文件的输出流
        } catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        while(isRecord == true) {
            readSize = audioRecord.read(audioData, 0, bufferSizeInBytes);
            Log.d(TAG, "readSize ="+readSize);
            if(AudioRecord.ERROR_INVALID_OPERATION != readSize) {
                try {
                    fos.write(audioData);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        try
        {
            fos.close();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
// 把 头文件 写入音频中
    private void copyWaveFile(String inFileName, String outFileName) {
        FileInputStream in = null;
        FileOutputStream out = null;
        long totalAudioLen = 0;
        long totalDataLen = totalAudioLen + 36;
        long longSampleRate = sampleRateInHz;
        int channels = 1;
        long byteRate = 16 * sampleRateInHz * channels / 8;

        byte[] data = new byte[bufferSizeInBytes];
        try
        {
            in = new FileInputStream(inFileName);
            out = new FileOutputStream(outFileName);

            totalAudioLen = in.getChannel().size();
            totalDataLen = totalAudioLen + 36;
            WriteWaveFileHeader(out, totalAudioLen, totalDataLen, longSampleRate, channels, byteRate);
            while(in.read(data) != -1)
            {
                out.write(data);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 这里提供一个头信息。插入这些信息就可以得到可以播放的文件。
     * 为我为啥插入这44个字节，这个还真没深入研究，不过你随便打开一个wav
     * 音频的文件，可以发现前面的头文件可以说基本一样哦。每种格式的文件都有
     * 自己特有的头文件。
     */
    private void WriteWaveFileHeader(FileOutputStream out, long totalAudioLen,
                                     long totalDataLen, long longSampleRate, int channels, long byteRate)
            throws IOException {
        byte[] header = new byte[44];
        header[0] = 'R'; // RIFF/WAVE header
        header[1] = 'I';
        header[2] = 'F';
        header[3] = 'F';
        header[4] = (byte) (totalDataLen & 0xff);
        header[5] = (byte) ((totalDataLen >> 8) & 0xff);
        header[6] = (byte) ((totalDataLen >> 16) & 0xff);
        header[7] = (byte) ((totalDataLen >> 24) & 0xff);
        header[8] = 'W';
        header[9] = 'A';
        header[10] = 'V';
        header[11] = 'E';
        header[12] = 'f'; // 'fmt ' chunk
        header[13] = 'm';
        header[14] = 't';
        header[15] = ' ';
        header[16] = 16; // 4 bytes: size of 'fmt ' chunk
        header[17] = 0;
        header[18] = 0;
        header[19] = 0;
        header[20] = 1; // format = 1
        header[21] = 0;
        header[22] = (byte) channels;
        header[23] = 0;
        header[24] = (byte) (longSampleRate & 0xff);
        header[25] = (byte) ((longSampleRate >> 8) & 0xff);
        header[26] = (byte) ((longSampleRate >> 16) & 0xff);
        header[27] = (byte) ((longSampleRate >> 24) & 0xff);
        header[28] = (byte) (byteRate & 0xff);
        header[29] = (byte) ((byteRate >> 8) & 0xff);
        header[30] = (byte) ((byteRate >> 16) & 0xff);
        header[31] = (byte) ((byteRate >> 24) & 0xff);
        header[32] = (byte) (2 * 16 / 8); // block align
        header[33] = 0;
        header[34] = 16; // bits per sample
        header[35] = 0;
        header[36] = 'd';
        header[37] = 'a';
        header[38] = 't';
        header[39] = 'a';
        header[40] = (byte) (totalAudioLen & 0xff);
        header[41] = (byte) ((totalAudioLen >> 8) & 0xff);
        header[42] = (byte) ((totalAudioLen >> 16) & 0xff);
        header[43] = (byte) ((totalAudioLen >> 24) & 0xff);
        out.write(header, 0, 44);
    }
//    结束 方法
    private void pause(){
        mediaPlayer.pause();
//        playhandler.removeCallbacks(runnable_3);
//        play.setImageResource(ic_media_play);
    }

//    页面滑动的回调
    public interface FragmentToActivity{
        public void huidiao(String str);
    }

    FragmentToActivity fragmentToActivity;
    @Override
    protected void loadData() {

        String word_tran = bundle.getString("word_tran");
        word_id = bundle.getString("word_id");
        type = bundle.getString("type");



        title.setText(word);
        dc_jx_text.setText(word_tran);

    }
//    在fragment 构建的时候  开始加载播放方法  fragment隐藏以后  销毁
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        fragmentToActivity=(FragmentToActivity) activity;
        word = bundle.getString("word");

        fragmentToActivity.huidiao(word);
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
                relative_path = bundle.getString("Relative_path");
                word_video = bundle.getString("word_video");

                String bofUrl = "https://zts100.com/demo/file/download"+"/?"+"Relative_path="+relative_path+"&"+"type=2"+"&"+"fileName="+word_video;
                mPlayer.setDataSource(bofUrl);
                MyLog.e("sahdisauhdiuahdiuaw",bofUrl);
                //3 准备播放
                mPlayer.prepareAsync();
                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                    }
                });
                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {

                        MyLog.e("CheckBox_状态",bf_zt.isChecked() + "");
//                        Toast.makeText(App.activity,"CheckBox_状态"+bf_zt.isChecked(),Toast.LENGTH_LONG).show();
                        bf_zt.setChecked(false);
//                        Toast.makeText(App.activity,"播放器_状态"+mPlayer.isPlaying(),Toast.LENGTH_LONG).show();
                        bool[0] = false;
                        MyLog.e("结束","");


                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPlayer.stop();
    }

    @Override
    public void setParams(Bundle bundle) {
        this.bundle = bundle;
    }
//        智聆评估录音
    private String filePath = "/sdcard/SOE/soe.mp3";
    private void sendMessage(int what, Object obj) {
        Message msg = new Message();
        msg.what = what;
        msg.obj = obj;
        mMyHandler.sendMessage(msg);
    }
//    评估结果的回调
    private SOECallback callback = new SOECallback() {
        public void onInitSuccess(InitOralProcessResponse response) {
            sendMessage(MSG_INIT_OK, response.toString());
        }
//        评估成功的回调
        public void onTransmitSuccess(int index, int isEnd, TransmitOralProcessResponse response) {
            Message msg = new Message();
            msg.what = ZhiL_Key_Velue.MSG_TRANSMIT_OK;
            msg.arg1 = index;
            msg.arg2 = isEnd;
            msg.obj = response.toString();
            MyLog.e("评估结果___",response.toString() +"");
            JsonDemo(response.toString());
            mMyHandler.sendMessage(msg);


            linearLayout.setVisibility(View.GONE);
            ly_btn.setVisibility(View.VISIBLE);
        }
//        评估失败的回调
        public void onError(SOEError e) {
            sendMessage(ZhiL_Key_Velue.MSG_INIT_ERROR, e.getMessage());

            App.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
            linearLayout.setVisibility(View.GONE);
            ly_btn.setVisibility(View.VISIBLE);
                }
            });
        }
    };
// 执行一次性 评估
    private void doExecuteOnce() {
        try {

            if (filePath.endsWith(".mp3")) {// 只有MP3需要校验
                try {
                    TencentSOE.checkMP3Format(filePath);
                } catch (Exception e) {
                    sendMessage(ZhiL_Key_Velue.MSG_ERROR, e.getMessage());
                    return;
                }
            }
            String base64String = TencentSOE.encodeAudioFile(filePath);
            TencentSOE.newInstance(ZhiL_Key_Velue.SECRETID, ZhiL_Key_Velue.SECRETKEY)
                    .setRootUrl("soe.tencentcloudapi.com")// 非必要
                    .setRegion("")// 非必要
                    .setSoeAppId("default")// 非必要
                    .setRefText(word)
                    .setEvalMode(TencentSOE.EVAL_MODE_WORD)
                    .setScoreCoeff(1.0f)
                    .setIsLongLifeSession(TencentSOE.SESSION_LIFE_LONG)
                    .setVoiceFileType(TencentSOE.AUDIO_TYPE_MP3)
                    .setUserVoiceData(base64String)
                    .execute(callback);
        } catch (Exception e) {
            sendMessage(ZhiL_Key_Velue.MSG_ERROR, e.getMessage());
        }
    }

    final Boolean[] b = {false};
    private Boolean[] aBoolean = {false};

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BF_LY:
                if (aBoolean[0]){
                    if (mediaPlayer.isPlaying()){
                        pause();
                    }
                    aBoolean[0] = false;
                }else {
                    if (!mediaPlayer.isPlaying()){
                        playMusic();
                    }
                    aBoolean[0] = true;
                }
                break;
            case R.id.BF_zt:
                if (bool[0]){
                if (mPlayer.isPlaying()){
                    mPlayer.pause();
                    bool[0] = false;
                }
            }else {
                if (!mPlayer.isPlaying()){
                    mPlayer.start();
                    bool[0] = true;
                }
            }
                break;
            case R.id.next_T:
                break;
            case R.id.Ly_btn:
                if (b[0]){
//                    stopAudioRecord();
                    TencentSOE.stopRecord();

                    rippleIntroView.setColor(this.getResources().getColor(R.color.pe_gray));
                    linearLayout.setVisibility(View.VISIBLE);
                    ly_btn.setVisibility(View.GONE);
                    doExecuteOnce();
                    b[0] = false;
                }else {
//                    startAudioRecord();
//                    presenter = new ZhiL_Csh_Fy_Presenter(this);
//                    presenter.setUrlsZhiL("0",word,System.currentTimeMillis() + "","1","4.0");
                    TencentSOE.startRecordMp3(Environment.getExternalStorageDirectory().getAbsolutePath() + "/SOE/", "soe");
                    b[0] = true;
                    rippleIntroView.setColor(this.getResources().getColor(R.color.text_color_red));
                }
//                relativeLayout.setVisibility(View.VISIBLE);
//                next_t.setVisibility(View.VISIBLE);
                break;
            case R.id.BF_One:
                CheckOXanz.setVisibility(View.VISIBLE);
                CheckTXanz.setVisibility(View.GONE);
                break;
            case R.id.BF_Two:
                CheckOXanz.setVisibility(View.GONE);
                CheckTXanz.setVisibility(View.VISIBLE);
                break;
        }
    }
    private CustomProgressDialog mProgressDialog;
    private float f;

//    评估结果的解析
    private void JsonDemo(String string) {

//        第一步，string参数相当于一个JSON,依次解析下一步
        JSONObject json = null;

        try {
            json = new JSONObject(string);

            JSONObject response = json.optJSONObject("Response");
            String PronAccuracy = response.optString("PronAccuracy");

            JSONObject Error = response.optJSONObject("Error");

            if (Error != null){
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        linearLayout.setVisibility(View.GONE);
                        ly_btn.setVisibility(View.VISIBLE);
//                        Toast.makeText(activity,"评估失败",Toast.LENGTH_LONG).show();

                        Toast toast = Toast.makeText(App.activity, "评估失败", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

                    }
                });
                return;
            }
            if (PronAccuracy != "0"){
               // final int i = Integer.parseInt(PronAccuracy);
                final int i= NumberUtil.parseInt(PronAccuracy);
                MyLog.e("发音得到的评分————", i + "");
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        pf_fs.setText(i+"");
                        relativeLayout.setVisibility(View.VISIBLE);
                        next_t.setVisibility(View.VISIBLE);

                        MyLog.e("评估出来的分数" ,i + "");

                        if (i>=85){
                            gl_.setText("nice 非常棒~");
                        }else {
                            gl_.setText("加油，继续努力");
                        }
                        float in = i/20;

                        MyLog.e("zhanshi出来的分数" ,i + "");
                        xinx_bar.setIsIndicator(true);
                        xinx_bar.setRating(in);
                        xinx_bar.setNumStars(5);
                        xinx_bar.setMax(5);
                        linearLayout.setVisibility(View.GONE);
                        ly_btn.setVisibility(View.VISIBLE);
                    }
                });

                presenter = new Lu_SC_Stdey_Presenter(this);
                presenter.SetU(App.stuid,word_id,System.currentTimeMillis()+".mp3", String.valueOf(i),type);

            }else {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        linearLayout.setVisibility(View.GONE);
                        ly_btn.setVisibility(View.VISIBLE);
                        Toast toast = Toast.makeText(App.activity, "请正常朗读", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

//                        Toast.makeText(activity,"请正常朗读",Toast.LENGTH_SHORT).show();
                    }
                });
                return;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getManager(YuYinPinG_Bean yuYinPinGBean) {

        if (yuYinPinGBean.getResponse().getSessionId() == null){
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    Toast.makeText(activity,"评估失败",Toast.LENGTH_SHORT).show();
                    Toast toast = Toast.makeText(App.activity, "评估失败", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                }
            });
        }else {
            MyLog.e("初始化发音",yuYinPinGBean.getResponse().getRequestId()+"________"+yuYinPinGBean.getResponse().getSessionId());
            sessionId = yuYinPinGBean.getResponse().getSessionId();
        }
    }

    @Override
    public void getManagerO(String pinC_fay_bean) {

        MyLog.e("请求成功——得到的json",pinC_fay_bean);
        JsonDemo(pinC_fay_bean);
    }

    @Override
    public void getManagerT(Stdey_Bean xq_bean) {
//        上传成功的回调
        save_path = xq_bean.getData().getSave_path();

        MyLog.e("获取到的 上传文件路径",save_path+ "");
        presenter = new Lu_Study_Presenter(this);
        presenter.seturl(file,"2",save_path);
    }

    @Override
    public void getWJSC(SC_YX_Bean sc_yx_bean) {

    }
    @Override
    public void showmessage(String str) {
    }
    @Override
    public void setBasePresenter(ZhiL_Yuyin_Cotract.Presenter presenter) {

    }
}
