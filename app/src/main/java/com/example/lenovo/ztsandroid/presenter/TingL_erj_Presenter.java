package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.TingL_erj_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.TingL_erj_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/21.
 */

public class TingL_erj_Presenter implements TingL_erj_Cotract.Presenter {

    private TingL_erj_Cotract.View view;
    private CSModel csModel;

    public TingL_erj_Presenter(TingL_erj_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetU(String flag, String type, String listen_type) {

        csModel.postTingL(flag, type, listen_type,new MyNetWorkCallback<TingL_erj_Bean>() {
            @Override
            public void onSuccess(TingL_erj_Bean tingL_erj_bean) {
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
