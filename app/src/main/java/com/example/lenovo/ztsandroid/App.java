package com.example.lenovo.ztsandroid;

import android.app.Activity;
import android.app.Application;
import android.net.wifi.hotspot2.pps.Credential;
import android.support.annotation.RequiresApi;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Zuoy_Bean;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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

    public static ArrayList<Map<String,String>> arrayList = new ArrayList<>();

    public static ArrayList<String> XuanZList = new ArrayList<>();

    public static ArrayList<String> hw_videoList = new ArrayList<>();

    public static ArrayList<String> hw_scoreList = new ArrayList<>();

    public static Map<String,String> stringMap = new HashMap<>();

    public static ArrayList<Spinner_Zuoy_Bean.DataBean> list = new ArrayList<>();


    public static ArrayList<File> fileArrayList = new ArrayList<>();

//    @RequiresApi(api = 26)
    @Override
    public void onCreate() {
        super.onCreate();


//        // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey
//        Credential cred = new Credential();
//
//        // 实例化一个http选项，可选的，没有特殊需求可以跳过
//        HttpProfile httpProfile = new HttpProfile();
//        httpProfile.setReqMethod("GET"); // post请求(默认为post请求)
//        httpProfile.setConnTimeout(30); // 请求连接超时时间，单位为秒(默认60秒)
//        httpProfile.setEndpoint("soe.tencentcloudapi.com"); // 指定接入地域域名(默认就近接入)
//
//        // 实例化要请求产品的client对象,clientProfile是可选的
//        SoeClient client = new SoeClient(cred, "");
//        InitOralProcessRequest req = new InitOralProcessRequest();
//        req.setSessionId("1234567");
//        req.setRefText("智聆口语评测");
//        req.setWorkMode(1);
//        req.setEvalMode(0);
//        req.setScoreCoeff(2.0f);
//        InitOralProcessResponse res = client.InitOralProcess(req);
//
//        // 输出json格式的字符串回包
//        System.out.println(InitOralProcessResponse.toJsonString(res));
//        // 也可以取出单个值。
//        // 你可以通过官网接口文档或跳转到response对象的定义处查看返回字段的定义
//        System.out.println(res.getRequestId());
//    } catch (TencentCloudSDKException e) {
//        e.printStackTrace();
//    }

    }





}