package com.example.lenovo.ztsandroid;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;

import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.config.Urls;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Zuoy_Bean;
import com.example.lenovo.ztsandroid.utils.MessageReceiver;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.tencent.android.otherPush.StubAppUtils;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGNotifaction;
import com.tencent.android.tpush.XGPushClickedResult;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushNotifactionCallback;

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

    public static Object token;


    //初始化信鸽 注册
    @Override
    public void onCreate() {
        super.onCreate();
        AudioManager audioManager = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setSpeakerphoneOn(true);

        XGPushManager.setNotifactionCallback(new XGPushNotifactionCallback() {
            @Override
            public void handleNotify(XGNotifaction xgNotifaction) {
                Log.e("test", "处理信鸽通知：" + xgNotifaction);
                // 获取标签、内容、自定义内容
                String title = xgNotifaction.getTitle();
                String content = xgNotifaction.getContent();
                String customContent = xgNotifaction.getCustomContent();

                MyLog.e("啦啦啦啦",title+content+customContent + "");

                // 其它的处理
                // 如果还要弹出通知，可直接调用以下代码或自己创建Notifaction，否则，本通知将不会弹出在通知栏中。
                xgNotifaction.doNotify();
            }
        });

        XGPushConfig.enableDebug(this,true);
        XGPushConfig.enableOtherPush(getApplicationContext(), true);
        XGPushConfig.setHuaweiDebug(true);
        XGPushConfig.setMiPushAppId(getApplicationContext(), "2100322577");
        XGPushConfig.setMiPushAppKey(getApplicationContext(), "AZ998UTKC49Q");
        XGPushConfig.setMzPushAppId(this, "2100322577");
        XGPushConfig.setMzPushAppKey(this, "AZ998UTKC49Q");

        XGPushManager.registerPush(this, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object data, int flag) {
                //token在设备卸载重装的时候有可能会变
                Log.e("TPush", "注册成功，设备token为：" + data);
                // Toast.makeText(App.activity,"注册成功，设备token为：" + data,Toast.LENGTH_LONG).show();
                //注意在3.2.2 版本信鸽对账号绑定和解绑接口进行了升级具体详情请参考API文档。
//                    App.token = data;
            }
            @Override
            public void onFail(Object data, int errCode, String msg) {
                Log.e("TPush", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
            }
        });




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