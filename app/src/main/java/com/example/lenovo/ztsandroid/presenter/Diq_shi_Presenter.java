package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Diq_QieH_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Diq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Diq_Shi_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/20.
 */

public class Diq_shi_Presenter implements Diq_QieH_Cotract.Presenter {

    private Diq_QieH_Cotract.View view;
    private CSModel DancModel;

    public Diq_shi_Presenter(final Diq_QieH_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        DancModel = new CSModelImpl();
    }

    @Override
    public void start() {


    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String sheng_id) {

        DancModel.post_DiqShi(sheng_id,new MyNetWorkCallback<Diq_Shi_Bean>() {
            @Override
            public void onSuccess(Diq_Shi_Bean diqBean) {
                view.getManagershi(diqBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    @Override
    public void SetU(String shi_id) {

    }
}
