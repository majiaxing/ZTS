package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Zy_Xq_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_erJ_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/27.
 */

public class Zy_Xq_Presenter implements Zy_Xq_Cotract.Presenter {

    private Zy_Xq_Cotract.View view;
    private CSModel csModel;

    public Zy_Xq_Presenter(Zy_Xq_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        csModel = new CSModelImpl();

    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String stuid, String hwid, String flag) {

        csModel.postZuoY_Xq(stuid, hwid, flag, new MyNetWorkCallback<ZuoY_Xq_Bean>() {
            @Override
            public void onSuccess(ZuoY_Xq_Bean erJ_bean) {
            view.getManager(erJ_bean);
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
