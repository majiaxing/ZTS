package com.example.lenovo.ztsandroid.presenter.zuoye;

import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_DY_Cotract;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Dc_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_dc_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_dy_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZuoY_Dy_presenter implements ZuoY_DY_Cotract.Presenter {


    private ZuoY_DY_Cotract.View view;
    private CSModel csModel;

    public ZuoY_Dy_presenter(ZuoY_DY_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }



    @Override
    public void SetUrl(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore) {

        csModel.postZuoY_DY(stuid, hwid, flag, listen_type, hw_type, hw_content, avgScore, new MyNetWorkCallback<ZuoY_dy_Bean>() {
            @Override
            public void onSuccess(ZuoY_dy_Bean zuoYDcBean) {
                view.getManager(zuoYDcBean);
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
