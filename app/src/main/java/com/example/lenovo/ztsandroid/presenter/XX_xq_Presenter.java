package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.XX_Cotract;
import com.example.lenovo.ztsandroid.cotract.XX_xq_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.XX_xq_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/19.
 */

public class XX_xq_Presenter implements XX_xq_Cotract.Presenter {


    private XX_xq_Cotract.View view;
    private CSModel csModel;

    public XX_xq_Presenter(XX_xq_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }

    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String Id) {
    csModel.postXiaoXxq(Id, new MyNetWorkCallback<XX_xq_Bean>() {
        @Override
        public void onSuccess(XX_xq_Bean xx_xq_bean) {
            view.getManager(xx_xq_bean);
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
