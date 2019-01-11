package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Read_erj_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Read_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_erj_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/22.
 */

public class Read_erj_Presenter implements Read_erj_Cotract.Presenter {

    private Read_erj_Cotract.View view;
    private CSModel csModel;

    public Read_erj_Presenter(Read_erj_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetU(String flag, String type) {
        csModel.postRead_erj(flag, type, new MyNetWorkCallback<Read_erj_Bean>() {
            @Override
            public void onSuccess(Read_erj_Bean tingL_erj_bean) {
                view.getManager(tingL_erj_bean);
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
