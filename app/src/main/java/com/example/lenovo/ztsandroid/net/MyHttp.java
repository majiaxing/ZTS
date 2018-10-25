package com.example.lenovo.ztsandroid.net;

import com.example.lenovo.ztsandroid.net.callback.INetWorkCallback;
import com.example.lenovo.ztsandroid.net.callback.NetWorkCallback;

import java.util.Map;




/**
 * Created by lx on 2017/7/11.
 * 网络请求接口
 */

public interface MyHttp {
    <T> void get(String url, Map<String, String> params, INetWorkCallback<T> callback);

    <T> void post(String url, Map<String, String> params, INetWorkCallback<T> callback);
    //登陆 图片验证码
    <T> void doget(String url, Map<String, String> params, NetWorkCallback callback);

    //获取手机验证码
    <T> void getSjYam(String url, Map<String, String> params, NetWorkCallback callback);

    //手机号注册
    <T> void Register(String url, Map<String, String> params, NetWorkCallback callback);
    //邮箱注册
    <T> void EmailRegister(String url, Map<String, String> params, NetWorkCallback callback);

}
