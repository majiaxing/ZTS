package com.example.lenovo.ztsandroid.fragment;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.DanC_Adapter;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.config.Urls;
import com.example.lenovo.ztsandroid.cotract.Lu_SC_Stdey_Cotract;
import com.example.lenovo.ztsandroid.cotract.ZhiL_Yuyin_Cotract;
import com.example.lenovo.ztsandroid.model.entity.PinC_Fay_Bean;
import com.example.lenovo.ztsandroid.model.entity.SC_YX_Bean;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.model.entity.Stdey_Bean;
import com.example.lenovo.ztsandroid.model.entity.YuYinPinG_Bean;
import com.example.lenovo.ztsandroid.presenter.Lu_SC_Stdey_Presenter;
import com.example.lenovo.ztsandroid.presenter.Lu_SC_Stdey_dy_Presenter;
import com.example.lenovo.ztsandroid.presenter.Lu_Study_Presenter;
import com.example.lenovo.ztsandroid.presenter.PinC_Fay_presenter;
import com.example.lenovo.ztsandroid.presenter.Sc_Lu_Presenter;
import com.example.lenovo.ztsandroid.presenter.ZhiL_Csh_Fy_Presenter;
import com.example.lenovo.ztsandroid.utils.ConvertUtil;
import com.example.lenovo.ztsandroid.utils.HMACTest;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.YP_BF_Utils;
import com.example.lenovo.ztsandroid.view.CustomProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;

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
    private String str;
    private TextView pf_fs;
    private RatingBar xinx_bar;
    private TextView gl_;


    @Override
    protected int getLayoutId() {
        return R.layout.viewpager_danci;
    }


    @Override
    protected void init(View view) {

        title = view.findViewById(R.id.Nr_danci);
        CheckO = view.findViewById(R.id.BF_One);
        CheckOXanz = view.findViewById(R.id.BF_One_Xuanz);
        CheckTXanz = view.findViewById(R.id.BF_Two_Xuanz);
        CheckT = view.findViewById(R.id.BF_Two);


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

        CheckBox BF_zt = view.findViewById(R.id.BF_zt);
        CheckBox Ly_btn = view.findViewById(R.id.Ly_btn);
        bf_ly.setOnClickListener(this);
        BF_zt.setOnClickListener(this);
        Ly_btn.setOnClickListener(this);
        next_t.setOnClickListener(this);
        title.setText("shit");

        relativeLayout.setVisibility(View.GONE);
        next_t.setVisibility(View.GONE);
        creatAudioRecord();
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

        if (sessionId != null){
            mProgressDialog = new CustomProgressDialog(App.activity);
            mProgressDialog.show();
            presenter = new PinC_Fay_presenter(this);
            presenter.seturlZhiL("1", "1", "2","1",toBase64, sessionId);
        }
    }

    private void close() {
        if (audioRecord != null) {

            System.out.println("stopRecord");
            isRecord = false;//停止文件写入
            Toast.makeText(App.activity,"录音成功",Toast.LENGTH_SHORT).show();
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

        word = bundle.getString("word");
        String word_tran = bundle.getString("word_tran");





        word_id = bundle.getString("word_id");
        type = bundle.getString("type");




        title.setText(word);
        dc_jx_text.setText(word_tran);


    }


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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void setParams(Bundle bundle) {
        this.bundle = bundle;
    }

    final Boolean[] b = {false};
    private Boolean[] aBoolean = {false};
    private Boolean[] bool  = {false};
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
            case R.id.next_T:



                break;
            case R.id.Ly_btn:
                Log.e("AAAAAAAAAAAA","WWWWWWWWWWWWWWWWWX");

                if (b[0]){

                    stopAudioRecord();

                    b[0] = false;

                }else {


                    startAudioRecord();
                    presenter = new ZhiL_Csh_Fy_Presenter(this);
                    presenter.setUrlsZhiL("0",word,System.currentTimeMillis() + "","1","4.0");
                    b[0] = true;
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
    private void JsonDemo(String string) {

//        第一步，string参数相当于一个JSON,依次解析下一步
        JSONObject json = null;

        try {
            json = new JSONObject(string);

            JSONObject response = json.optJSONObject("Response");
            String PronAccuracy = response.optString("PronAccuracy");


            if (PronAccuracy != "0"){

                str = PronAccuracy.substring(0,4);

                MyLog.e("发音得到的评分————", str + "");


                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pf_fs.setText(str);
                        relativeLayout.setVisibility(View.VISIBLE);
                        next_t.setVisibility(View.VISIBLE);

                        float i = ConvertUtil.convertToFloat(str,f);
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
                        mProgressDialog.dismiss();
                    }
                });

                presenter = new Lu_SC_Stdey_Presenter(this);
                presenter.SetU(App.stuid,word_id,System.currentTimeMillis()+".mp3",str,type);


            }else {
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mProgressDialog.dismiss();
                        Toast.makeText(App.activity,"请正常朗读",Toast.LENGTH_SHORT).show();
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
            App.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(App.activity,"评估失败",Toast.LENGTH_SHORT).show();
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
