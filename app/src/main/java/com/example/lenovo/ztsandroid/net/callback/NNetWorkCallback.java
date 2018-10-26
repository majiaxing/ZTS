package com.example.lenovo.ztsandroid.net.callback;

/**
 * Created by Administrator on 2018/10/26.
 */

public interface NNetWorkCallback {

    void OnSuccess(String s);
    void OnError(int ErrorCode, String ErrorMsg);

}
