package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Read_XQ_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Read_TJ_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/26.
 */

public class Read_TJ_Presenter implements Read_XQ_Cotract.Presenter {


    private CSModel csModel;
    private Read_XQ_Cotract.View view;

    public Read_TJ_Presenter(Read_XQ_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        csModel = new CSModelImpl();

    }

    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String read_Id) {

        csModel.postRead_TJ(read_Id, new MyNetWorkCallback<Read_TJ_Bean>() {
            @Override
            public void onSuccess(Read_TJ_Bean read_tj_bean) {

                view.getRead_Tj(read_tj_bean);

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
