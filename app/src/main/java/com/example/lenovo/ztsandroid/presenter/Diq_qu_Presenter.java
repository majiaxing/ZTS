package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Diq_QieH_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Diq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Diq_Qu_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/20.
 */

public class Diq_qu_Presenter implements Diq_QieH_Cotract.Presenter {

    private Diq_QieH_Cotract.View view;
    private CSModel DancModel;

    public Diq_qu_Presenter(final Diq_QieH_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        DancModel = new CSModelImpl();
    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void start() {

    }

    @Override
    public void SetUrl(String sheng_id) {



    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetU(String shi_id) {
        DancModel.post_DiqQu(shi_id,new MyNetWorkCallback<Diq_Qu_Bean>() {
            @Override
            public void onSuccess(Diq_Qu_Bean diqBean) {
                view.getManagerqu(diqBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }
}
