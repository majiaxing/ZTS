package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.JaR_Bj_Cotract;
import com.example.lenovo.ztsandroid.cotract.JiaoC_xz_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.BanJBean;
import com.example.lenovo.ztsandroid.model.entity.Diq_Qu_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/5.
 */

public class JaR_Bj_Presenter implements JaR_Bj_Cotract.Presenter{


    private JaR_Bj_Cotract.View jiaocView;
    private CSModel csModel;

    public JaR_Bj_Presenter(JaR_Bj_Cotract.View jiaocView) {
        this.jiaocView = jiaocView;
        this.jiaocView.setBasePresenter(this);
        csModel  =new CSModelImpl();

    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String stuid, String infor) {

        csModel.post_JR_BJ(stuid, infor, new MyNetWorkCallback<BanJBean>() {
            @Override
            public void onSuccess(BanJBean diq_qu_bean) {
                jiaocView.getManager(diq_qu_bean);
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
