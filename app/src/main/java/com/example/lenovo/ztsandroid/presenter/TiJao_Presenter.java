package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.TiJao_Cotract;
import com.example.lenovo.ztsandroid.cotract.TiJiao_ZY_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.TiJao_ZY_Bean;
import com.example.lenovo.ztsandroid.model.entity.TiJiao_ZY_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/6.
 */

public class TiJao_Presenter implements TiJao_Cotract.Presenter {



    private CSModel csModel;
    private TiJao_Cotract.View view;

    public TiJao_Presenter(TiJao_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }

    @Override
    public void start() {

    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String stuid, String hwid) {

        csModel.postTingL_ZY(stuid, hwid, new MyNetWorkCallback<TiJiao_ZY_Bean>() {
            @Override
            public void onSuccess(TiJiao_ZY_Bean tiJiao_zy_bean) {
                view.getManager(tiJiao_zy_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });


    }
}
