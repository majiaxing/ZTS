package com.example.lenovo.ztsandroid;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.config.Urls;
import com.example.lenovo.ztsandroid.cotract.CS_YYin_JK_Cotract;
import com.example.lenovo.ztsandroid.utils.HMACTest;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/11/27.
 */

public class CS_Yiny_Activity extends BaseActivity {


    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.text)
    Button text;
    @BindView(R.id.textO)
    Button textO;
    private CS_YYin_JK_Cotract.Presenter presenter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private String text1;
    private int nextInt;
    private String signature;
    private String encode;
    private Request request;
    private String requestId;
    private String sessionId;

    private MediaRecorder mediaRecorder = new MediaRecorder();  //用于录音
    private File file = new File("/mnt/sdcard", System.currentTimeMillis() + ".mp3");  //创建一个临时的音频文件
    private MediaPlayer mediaPlayer = new MediaPlayer();  //用于播放录音
    private MediaPlayer mPlayer = new MediaPlayer();  //用于播放音频
    private long currenttime;  //用于确定当前录音时间
    private boolean isrecording = false;  //用于判断当前是否在录音
    private boolean Isplaying = false;  //用于判断是否正在处于播放录音状
    private String toBase64;
    private String oldphoto64code;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {


        new Thread(new Runnable() {
            @Override
            public void run() {
//                    postParams(signature);
            }
        }).start();
    }

    @Override
    public void initData() {
//AKIDz8krbsJ5yKBZQpn74WFkmLPx3EXAMPLE&Timestamp=1465185768&Version=2017-03-12
        long l = System.currentTimeMillis() / 1000;
        String s = "Action=DescribeInstances" +
                "&InstanceIds.0=ins-09dx96dg" +
                "&Limit=20&Nonce=11886&Offset=0" +
                "&Region=ap-guangzhou" +
                "&SecretId=AKIDlLk2DzeZAd5bTMph1Oj7hBeu1w29pRUL" +
                "&Timestamp=" + l +
                "&Version=2018-07-24";

        String string = "GETsoe.tencentcloudapi.com/?";

        String secretKey = "oSF1kR2RegatkWAkDYlpGfyDKFqGLLGE";


        l = 3600 * 24 * 2;
        int i = new Random().nextInt(Integer.MAX_VALUE);


        String str = string + s;
//        MyLog.e("拼的字符串",str);
        try {
//            String sha1 = String.valueOf(HMACSHA1.HmacSHA1Encrypt(str, secretKey));
//
            String toSign = HMACTest.stringToSign(str);
//?Action=InitOralProcess&Version=2018-07-24&SessionId=AKIDlLk2DzeZAd5bTMph1Oj7hBeu1w29pRUL&RefText=holle&WorkMode=0&EvalMode=1&ScoreCoeff=4.0&Timestamp=1544419206944&Nonce=345122&SecretId=AKIDlLk2DzeZAd5bTMph1Oj7hBeu1w29pRUL&Signature=7Fe3Cow46gP0OPNauQrdffAGatg%3D

//
//            MyLog.e("生成的签名串",toSign);
//
//            String text = java.net.URLEncoder.encode(toSign);
//
//            MyLog.e("生成的最终签名串",text);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static String getStringToSign(String method, String endpoint, TreeMap<String, Object> params) {
        StringBuilder s2s = new StringBuilder();
        s2s.append(method).append(endpoint).append("/?");
        // 签名时要求对参数进行字典排序，此处用TreeMap保证顺序
        for (String k : params.keySet()) {
            s2s.append(k).append("=").append(params.get(k).toString()).append("&");
        }
        return s2s.toString().substring(0, s2s.length() - 1);
    }

    public void ToSign() throws Exception {


        String secretKey = "oSF1kR2RegatkWAkDYlpGfyDKFqGLLGE";


        // TreeMap可以自动排序
        final TreeMap<String, Object> params = new TreeMap<String, Object>();
        nextInt = new Random().nextInt(999999);
        MyLog.e("拼接的 请求串", nextInt + "");
        params.put("Nonce", nextInt);
        // 实际调用时应当使用系统当前时间
        params.put("Timestamp", System.currentTimeMillis() / 1000 + "");
        params.put("Region", "ap-beijing");
        params.put("SecretId", "AKIDwmWN4oMsCKOI1avCF2eyJUVM4bxmvuDL");
        params.put("Action", "InitOralProcess");
        params.put("Version", "2018-07-24");
        params.put("SessionId", "123456");
        params.put("RefText", "holle");
        params.put("WorkMode", "0");
        params.put("EvalMode", "0");
        params.put("ScoreCoeff", "3.0");

        String str2sign = getStringToSign("GET", "soe.tencentcloudapi.com", params);

        MyLog.e("拼接的 请求串", str2sign);

        signature = HMACTest.sign(str2sign, "62rgTXXM1PgmjZHrNn26zmRuY4QaecT9", "HmacSHA1");
        MyLog.e("Signature=", signature);
        /// text1 = java.net.URLEncoder.encode(signature,"utf-8");
        params.put("Signature", signature);
        new Thread(new Runnable() {
            @Override
            public void run() {
                postParams(params, " https://soe.tencentcloudapi.com");
            }
        }).start();




    }
    private void record() {
        if (file.exists()) {
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
        isrecording = true;
        currenttime = System.currentTimeMillis();
//        volumehandler.postDelayed(runnable_1,100);
//        timehandler.postDelayed(runnable_2,1000);
    }

    private void stop() throws IOException {
        mediaRecorder.stop();
//        start.setImageResource(btn_radio);
//        volumehandler.removeCallbacks(runnable_1);
//        timehandler.removeCallbacks(runnable_2);//停止相关线程
//        time.setText("00:00");
        isrecording = false;
        Toast.makeText(App.activity, "录音完成！", Toast.LENGTH_SHORT).show();


        InputStream in = null;
//            toBase64 = HMACTest.fileToBase64(file);

//            MyLog.e("shasdhada",toBase64);

        FileInputStream inputStream = null;

            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[(int)file.length()];
            inputStream.read(buffer);
             inputStream.close();
//            toBase64 = Base64.encodeToString(buffer, Base64.NO_WRAP);

            toBase64 = (Base64.encodeToString(buffer,Base64.NO_WRAP)).replaceAll("\r\n", "");

        Log.e("LKing","Base64文件编码---->"+oldphoto64code);
            ShuChu();
    }

    private void play() {
        if (!Isplaying) {
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

    private void pause() {
        mediaPlayer.pause();
//        playhandler.removeCallbacks(runnable_3);
//        play.setImageResource(ic_media_play);
    }


    private void postParams(TreeMap<String, Object> params, String url) {
        //创建一个OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //构建一个请求体 add参数1 key 参数2 value 发送字段
        Log.e("AAAAAAAAAAAAAAAAAAA", params.toString());
        StringBuffer sb = new StringBuffer(url);
        if (params != null && params.size() > 0) {
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = String.valueOf(params.get(key));

                sb.append(key).append("=").append(value).append("&");
                MyLog.e("请求数据", params.toString());
//                try {
//                    text1 = URLEncoder.encode(params.toString(),"utf-8");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();
        }
        MyLog.e("打印的URl", url);

        request = new Request.Builder().url(url).build();
        //发送请求获取响应
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            //判断请求是否成功

            MyLog.e("KASJDJSAJD", response.body().toString());
            if (response.isSuccessful()) {
                //打印服务端返回结果
                String sss = response.body().string();
//                JsonDemo(sss);
                Log.e("adsadas", sss);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void ShuChu(){

        final TreeMap<String, Object> params2 = new TreeMap<String, Object>();
        int nextInt = new Random().nextInt(999999);
        MyLog.e("拼接的 请求串", nextInt + "");
        params2.put("Nonce", nextInt);
        // 实际调用时应当使用系统当前时间
        params2.put("Timestamp", System.currentTimeMillis() / 1000 + "");
        params2.put("Region", "ap-beijing");
        params2.put("SecretId", "AKIDwmWN4oMsCKOI1avCF2eyJUVM4bxmvuDL");
        params2.put("Action", "TransmitOralProcess");
        params2.put("Version", "2018-07-24");
        params2.put("SeqId", "0");
        params2.put("IsEnd", "0");
        params2.put("VoiceFileType", "1");
        params2.put("VoiceEncodeType", "1");
        params2.put("UserVoiceData", "sadsa");
        params2.put("SessionId", "123456");
        String str23sign =getStringToSign("GET", "soe.tencentcloudapi.com", params2);

        MyLog.e("拼接的 请求串", str23sign);

        try {
            signature = HMACTest.sign(str23sign, "62rgTXXM1PgmjZHrNn26zmRuY4QaecT9", "HmacSHA1");
            MyLog.e("Signature=", signature);

//            encode =  java.net.URLEncoder.encode(signature,"UTF-8"); ;
//            MyLog.e("encode=", encode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        params2.put("Signature", signature);

        new Thread(new Runnable() {
            @Override
            public void run() {
                csOKHttp(params2, " https://soe.tencentcloudapi.com");
            }
        }).start();

    }




    private void csOKHttp(TreeMap<String, Object> params, String url){
        //创建一个OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //构建一个请求体 add参数1 key 参数2 value 发送字段
        Log.e("AAAAAAAAAAAAAAAAAAA", params.toString());
        StringBuffer sb = new StringBuffer(url);
        if (params != null && params.size() > 0) {
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = String.valueOf(params.get(key));

                sb.append(key).append("=").append(value).append("&");
                MyLog.e("请求数据", params.toString());
//                try {
//                    text1 = URLEncoder.encode(params.toString(),"utf-8");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();
        }
        MyLog.e("打印的URl", url);

        request = new Request.Builder().url(url).build();
        //发送请求获取响应
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            //判断请求是否成功

            MyLog.e("KASJDJSAJD", response.body().toString());
            if (response.isSuccessful()) {
                //打印服务端返回结果
                String sss = response.body().string();
//                JsonDemo(sss);
                Log.e("adsadas", sss);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    private void postParamsShuC(TreeMap<String, Object> params, String url) {
        //创建一个OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //构建一个请求体 add参数1 key 参数2 value 发送字段
        FormBody.Builder builder = new FormBody.Builder();
        if(params !=null && params.size() > 0){
            Set<String> keys = params.keySet();
            for (String key : keys) {
                MyLog.e("要上传的参数——++——————",key);
                String value = String.valueOf(params.get(key));
                builder.add(key,value);
            }
        }
        Log.e("AAAAAAAAAAAAAAAAAAA",params.toString());
        //构建一个请求对象
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        //发送请求获取响应
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            MyLog.e("QAQ_QAQ_QAQ_QAQ_QAQ_QAQ_QAQ",response.body().toString());
            //判断请求是否成功
            if (response.isSuccessful()) {
                //打印服务端返回结果
                String sss = response.body().string();
                Log.e("asdbjksaiwqoe", sss);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    private void JsonDemo(String string) {


//        第一步，string参数相当于一个JSON,依次解析下一步
        JSONObject json = null;

        try {
            json = new JSONObject(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JSONObject data = json.getJSONObject("Response");
            requestId = data.optString("RequestId");
            sessionId = data.optString("SessionId");

            Log.e("qbedwkjhkdhaaw ", requestId + "++________" + sessionId);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void loadData() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.text, R.id.textO})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text:
                if (!isrecording){
                    record();
                    try {
                        ToSign();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.textO:

                if (isrecording){
                    try {
                        stop();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                break;
        }
    }
}
