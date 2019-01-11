package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.JiaoC_xz_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.model.entity.JiaoC_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/14.
 */

public class JiaoC_Presenter implements JiaoC_xz_Cotract.Presenter {

    private JiaoC_xz_Cotract.View jiaocView;
    private CSModel csModel;

    public JiaoC_Presenter(JiaoC_xz_Cotract.View jiaocView) {
        this.jiaocView = jiaocView;
        this.jiaocView.setBasePresenter(this);
        csModel  =new CSModelImpl();

    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String string) {
        csModel.postJC(string, new MyNetWorkCallback<JiaoC_Bean>() {
            @Override
            public void onSuccess(JiaoC_Bean jiaoC_bean) {
                jiaocView.getManager(jiaoC_bean);
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
