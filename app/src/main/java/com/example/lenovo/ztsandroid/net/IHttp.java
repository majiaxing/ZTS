package com.example.lenovo.ztsandroid.net;


import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Lenovo on 2017/10/16.
 */

public interface IHttp {

    <T> void get(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    <T> void post(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    <T> void postjson(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    <T> void post_ZlYYin(String url, Map<String, String> params, MyNetWorkCallback<T> callback);

    <T>void postSC_File(String url, Map<String, Object> params, MyNetWorkCallback<T> callback);

    <T>void getZlY(String url, TreeMap<String, Object> params, MyNetWorkCallback<T> callback);


    <T>void postZlY(String url, TreeMap<String, Object> params, MyNetWorkCallback<T> callback);

    <T>void postCSh(String url, TreeMap<String, Object> params, MyNetWorkCallback<T> callback);






}
