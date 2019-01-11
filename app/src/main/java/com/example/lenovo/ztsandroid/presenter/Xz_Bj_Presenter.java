package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.JaR_Bj_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Xz_Bj_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/5.
 */

public class Xz_Bj_Presenter implements JaR_Bj_Cotract.Presenter {

    private JaR_Bj_Cotract.View jiaocView;
    private CSModel csModel;

    public Xz_Bj_Presenter(JaR_Bj_Cotract.View jiaocView) {
        this.jiaocView = jiaocView;
        this.jiaocView.setBasePresenter(this);
        csModel  =new CSModelImpl();

    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String stuid, String infor) {
        csModel.post_Xz_Bj(stuid, infor, new MyNetWorkCallback<Xz_Bj_Bean>() {
            @Override
            public void onSuccess(Xz_Bj_Bean s) {
                jiaocView.getManagerO(s);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void start() {

    }
}
