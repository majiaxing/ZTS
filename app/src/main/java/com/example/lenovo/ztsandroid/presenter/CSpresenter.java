package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.CScotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;
import com.example.lenovo.ztsandroid.utils.MyLog;

/**
 * Created by Lenovo on 2018/10/24.
 */

public class CSpresenter implements CScotract.Presenter {

    private CScotract.View view;
    private CSModel csModel;

    public CSpresenter(CScotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


//    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String string) {
        csModel.getLiveChinaUrl(string, new MyNetWorkCallback<CeSBean>() {
            @Override
            public void onSuccess(CeSBean ceSBean) {
                view.getManager(ceSBean);
                MyLog.e("aaaa",ceSBean.toString());
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.showmessage(errorMsg);
            }
        });
    }

    @Override
    public void start() {

    }
}
