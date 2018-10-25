package com.example.lenovo.ztsandroid.net;


import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

import java.util.Map;

/**
 * Created by Lenovo on 2017/10/16.
 */

public interface IHttp {

    <T> void get(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    <T> void post(String url, Map<String, String> params, MyNetWorkCallback<T> callback);


}
