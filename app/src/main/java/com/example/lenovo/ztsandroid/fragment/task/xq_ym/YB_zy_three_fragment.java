package com.example.lenovo.ztsandroid.fragment.task.xq_ym;

import android.content.Intent;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.activity.TiaoZan_Activity;
import com.example.lenovo.ztsandroid.activity.ZuoY_TiaoZan_Activity;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_Three_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_four_Bean;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Yb_Cotract;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_One_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_Two_Bean;
import com.example.lenovo.ztsandroid.presenter.zuoye.ZuoY_YB_Three_presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.view.RippleIntroView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;

/**
 * Created by Administrator on 2018/11/6.
 */

public class YB_zy_three_fragment extends BaseFragment implements ZuoY_Yb_Cotract.View ,View.OnClickListener{

    TextView YBTitle;

    CheckBox BFCsFay;

    CheckBox CsFayLY;

    Button TZYXT;

    CheckBox BFangSelf;

    private RippleIntroView rippleIntroView;
    private LinearLayout linearLayout;
    private ImageView pinF_jd;
    private Animation hyperspaceJumpAnimation;


    private Bundle bundle;
    private String yBid;
    private ZuoY_Yb_Cotract.Presenter presenter;
    private String symbol;


    private MediaRecorder mediaRecorder = new MediaRecorder();  //用于录音
    private File file = new File("/mnt/sdcard", System.currentTimeMillis()+".mp3");  //创建一个临时的音频文件
    private MediaPlayer mPlayer = new MediaPlayer();  //用于播放音频
    private long currenttime;  //用于确定当前录音时间
    private boolean isrecording = false;  //用于判断当前是否在录音
    private boolean Isplaying = false;  //用于判断是否正在处于播放录音状

    private String save_path;
    private String hw_answerId;
    private String video;
    private String relative_path;
    private String hw_type;
    private String hw_content;
    private String hwid;
    private String avgScores;


    @Override
    protected int getLayoutId() {
        return R.layout.yb_xq_three_fragment;
    }

    @Override
    protected void init(View view) {
        YBTitle = view.findViewById(R.id.YB_title);
        BFCsFay = view.findViewById(R.id.BF_cs_fay);
        CsFayLY = view.findViewById(R.id.Ly_btn);
        TZYXT = view.findViewById(R.id.TZ_YX_t);


        TZYXT.setOnClickListener(this);

        CsFayLY.setOnClickListener(this);
        BFCsFay.setOnClickListener(this);

        rippleIntroView = view.findViewById(R.id.Ripple);

        linearLayout = view.findViewById(R.id.linear);

        pinF_jd = view.findViewById(R.id.PinF_jd);

        hyperspaceJumpAnimation = AnimationUtils.loadAnimation(App.activity, R.anim.loading_animation);
        // 使用ImageView显示动画
        pinF_jd.startAnimation(hyperspaceJumpAnimation);

        hw_answerId = bundle.getString("hw_answerId");
        hw_type = bundle.getString("hw_type");
        hw_content = bundle.getString("hw_content");
        hwid = bundle.getString("hwid");
        avgScores = bundle.getString("avgScores");



        yBid = bundle.getString("YBid");

        presenter = new ZuoY_YB_Three_presenter(this);
        presenter.SetUrl(App.stuid, hwid,"3","", hw_type, hw_content, avgScores,"");

        creatAudioRecord();

    }





    public void setVisibleHint(boolean isVisibleToUser) {
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

                String bofUrl = "https://zts100.com/demo/file/download"+"/?"+"Relative_path="+relative_path+"&"+"type=2"+"&"+"fileName="+video;
                mPlayer.setDataSource(bofUrl);
                MyLog.e("sahdisauhdiuahdiuaw",bofUrl);
                //3 准备播放
                mPlayer.prepareAsync();
                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mPlayer.start();
                    }
                });
                mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {

                        MyLog.e("CheckBox_状态",BFCsFay.isChecked() + "");
                        BFCsFay.setChecked(false);
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    private static final String TAG = "AudioRecordActivity";
    private int bufferSizeInBytes = 0;//缓冲区大小
    //音频获取来源
    private int audioSource = MediaRecorder.AudioSource.MIC;
    //设置音频的采样率，44100是目前的标准，但是某些设备仍然支持22050,16000,11025
    private static int sampleRateInHz = 16000;
    //设置音频的录制声道，CHANNEL_IN_STEREO 为双声道，CHANNEL_CONFIGURATION_MONO 为单声道
    private static int channelConfig = AudioFormat.CHANNEL_IN_STEREO;
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


    private void creatAudioRecord() {
        //根据AudioRecord的音频采样率、音频录制声道、音频数据格式获取缓冲区大小
        bufferSizeInBytes = AudioRecord.getMinBufferSize(sampleRateInHz, channelConfig, audioFormat);
        Log.d(TAG, "creatAudioRecord-->bufferSizeInBytes="+bufferSizeInBytes);

        //根据音频获取来源、音频采用率、音频录制声道、音频数据格式和缓冲区大小来创建AudioRecord对象
        audioRecord = new AudioRecord(audioSource, sampleRateInHz, channelConfig, audioFormat, bufferSizeInBytes);

        //创建播放实例
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void setBasePresenter(ZuoY_Yb_Cotract.Presenter presenter) {

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
//
//        writeBytesToFileClassic(bytes1,NewAudioName);

        File file = new File(NewAudioName);
        if(file.exists()) {
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(NewAudioName);
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
            audioRecord = new AudioRecord(audioSource, sampleRateInHz, channelConfig, audioFormat, bufferSizeInBytes);
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

//        if (sessionId != null){
//            presenter = new PinC_Fay_presenter(this);
//            presenter.seturlZhiL("1", "1", "2","1",toBase64, sessionId);
//        }
    }

    private void close() {
        if (audioRecord != null) {

            System.out.println("stopRecord");
            isRecord = false;//停止文件写入
//            Toast.makeText(App.activity,"录音成功",Toast.LENGTH_SHORT).show();
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




    private void copyWaveFile(String inFileName, String outFileName) {
        FileInputStream in = null;
        FileOutputStream out = null;
        long totalAudioLen = 0;
        long totalDataLen = totalAudioLen + 36;
        long longSampleRate = sampleRateInHz;
        int channels = 2;
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


    private void pause(){
        mediaPlayer.pause();
//        playhandler.removeCallbacks(runnable_3);
//        play.setImageResource(ic_media_play);
    }





    @Override
    protected void loadData() {

    }

    @Override
    public void setParams(Bundle bundle) {
    this.bundle = bundle;
    }





    @Override
    public void getManagerOne(YB_Zy_One_Bean yb_xq_one_bean) {

    }

    @Override
    public void getManagerTwo(YB_Zy_Two_Bean yb_xq_two_bean) {

    }

    @Override
    public void getManagerThree(YB_Zy_Three_Bean yb_xq_three_bean) {
        symbol = yb_xq_three_bean.getData().getTypeList().get(0).getSymbol();
        video = yb_xq_three_bean.getData().getTypeList().get(0).getVideo();
        relative_path = yb_xq_three_bean.getData().getTypeList().get(0).getRelative_path();
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                YBTitle.setText(symbol);
            }
        });
    }

    @Override
    public void getManagerFour(YB_Zy_four_Bean yb_xq_four_bean) {

    }

    @Override
    public void showmessage(String str) {

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
                        setVisibleHint(false);
                    }
                    bool[0] = false;
                }else {
                    if (!mPlayer.isPlaying()){
                        MyLog.e("holle dnsjk","ahahahahh");
                        setVisibleHint(true);
                    }
                    bool[0] = true;
                }


                break;
            case R.id.Ly_btn:

                if (b[0]){
                    stopAudioRecord();
                    rippleIntroView.setColor(this.getResources().getColor(R.color.colorWhite));
                    b[0] = false;
                }else {
                        startAudioRecord();
//                        presenter = new ZhiL_Csh_Fy_Presenter(this);
//                        presenter.setUrlsZhiL("0",word,System.currentTimeMillis() + "","1","4.0");
                    b[0] = true;
                    rippleIntroView.setColor(this.getResources().getColor(R.color.text_color_red));
                }
                break;
            case R.id.TZ_YX_t:

                Intent intent = new Intent(App.activity,ZuoY_TiaoZan_Activity.class);
                intent.putExtra("hw_type",hw_type);
                intent.putExtra("hw_content",hw_content);
                intent.putExtra("hwid",hwid);
                intent.putExtra("avgScores",avgScores);
                startActivity(intent);

                break;

        }
    }
}
