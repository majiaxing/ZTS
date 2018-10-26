package com.example.lenovo.ztsandroid.model.biz;

import com.example.lenovo.ztsandroid.config.Urls;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.net.HttpFactroy;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Lenovo on 2018/10/24.
 */

public class CSModelImpl implements CSModel {
    @Override
    public void getLiveChinaUrl(String url, MyNetWorkCallback<CeSBean> callback) {

        HttpFactroy.create().
                get(Urls.CSUrls,null,callback);
    }
}
