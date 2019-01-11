package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.TiJ_Vip_Cotract;
import com.example.lenovo.ztsandroid.cotract.TiJiao_ZY_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.TiJ_Vip_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/7.
 */

public class TiJ_Vip_Presenter implements TiJ_Vip_Cotract.Presenter {

    private CSModel csModel;
    private TiJ_Vip_Cotract.View view;

    public TiJ_Vip_Presenter(TiJ_Vip_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String stuid, String cardName, String cardPassword) {
        csModel.postTiJ_Vip(stuid, cardName, cardPassword, new MyNetWorkCallback<TiJ_Vip_Bean>() {
            @Override
            public void onSuccess(TiJ_Vip_Bean tiJ_vip_bean) {
                view.getManager(tiJ_vip_bean);
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
