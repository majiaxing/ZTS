package com.example.lenovo.ztsandroid;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.hotspot2.pps.Credential;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.config.Urls;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Zuoy_Bean;
import com.example.lenovo.ztsandroid.utils.MyLog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Lenovo on 2017/10/16.
 */

public class App extends Application {

    public static BaseActivity context = null;

    public static RadioGroup mRadiogroup;

    public static BaseActivity activity;

    public static BaseFragment lastFragment;

    public static TextView textView;

    public static String stuid;

    public static ArrayList<Map<String,Object>> mlist = new ArrayList<>() ;

    public static Map<String, Object> map = new HashMap<>();

    public static ArrayList<Spinner_Zuoy_Bean.DataBean> list = new ArrayList<>();

    public static ArrayList<File> fileArrayList = new ArrayList<>();
    public static String sessionID;
    public static String Cookie;

    //    @RequiresApi(api = 26)
    @Override
    public void onCreate() {
        super.onCreate();
        AudioManager audioManager = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setSpeakerphoneOn(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                postParams();
            }
        }).start();

    }

    private void postParams() {
        //创建一个OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //构建一个请求体 add参数1 key 参数2 value 发送字段
        FormBody.Builder builder = new FormBody.Builder();
//        builder.add("hwid", )
//                .add("flag", "1")
//                .add("stuid", App.stuid)
//                .build();
        //构建一个请求对象
        Request request = new Request.Builder()
                .url( "https://zts100.com/demo/login/bind_session")
//                .addHeader("","")
                .post(builder.build())
                .build();

        //发送请求获取响应
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            //判断请求是否成功
            if (response.isSuccessful()) {
                //打印服务端返回结果
                String sss = response.body().string();

                Log.e("asdbjksaiwqoe", sss);
                JSONObject str = new JSONObject(sss);
                JSONObject data = str.getJSONObject("data");
                sessionID = data.optString("SessionID");

                Cookie = "JSESSIONID="+sessionID;

                MyLog.e("sessionID", sessionID);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}