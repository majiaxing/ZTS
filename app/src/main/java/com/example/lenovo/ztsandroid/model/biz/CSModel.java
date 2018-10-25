package com.example.lenovo.ztsandroid.model.biz;

import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Lenovo on 2018/10/24.
 */

public interface CSModel {

    void getLiveChinaUrl(String url,MyNetWorkCallback<CeSBean> callback);

}
