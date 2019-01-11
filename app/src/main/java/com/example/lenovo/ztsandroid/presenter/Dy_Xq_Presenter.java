package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.DuiH_XQ_Cotract;
import com.example.lenovo.ztsandroid.cotract.Dy_erj_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Dc_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Dy_Xq_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/28.
 */

public class Dy_Xq_Presenter implements Dy_erj_Cotract.Presenter {


    private Dy_erj_Cotract.View  view;
    private CSModel DuihModel;

    public Dy_Xq_Presenter(Dy_erj_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        DuihModel = new CSModelImpl();
    }


    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void setUrl(String flag, String type, String stuid) {

        DuihModel.postDY_Xq(flag, type, stuid, new MyNetWorkCallback<Dy_Xq_Bean>() {
            @Override
            public void onSuccess(Dy_Xq_Bean dcXqBean) {
                view.getManager(dcXqBean);
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
