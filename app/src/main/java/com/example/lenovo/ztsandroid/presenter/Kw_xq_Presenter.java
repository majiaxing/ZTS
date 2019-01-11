package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Kw_Xq_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Kw_Xq_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/20.
 */

public class Kw_xq_Presenter implements Kw_Xq_Cotract.Presenter{

    private CSModel Kw_Xq_Model;
    private Kw_Xq_Cotract.View view;

    public Kw_xq_Presenter(Kw_Xq_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        Kw_Xq_Model  =new CSModelImpl();
    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetU(String text_id) {
        Kw_Xq_Model.postKwXq(text_id, new MyNetWorkCallback<Kw_Xq_Bean>() {
            @Override
            public void onSuccess(Kw_Xq_Bean xq_bean) {
                view.getManager(xq_bean);
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
