package com.example.lenovo.ztsandroid.presenter.zuoye;

import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Dc_Cotract;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Yd_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Yd_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_dc_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZuoY_YD_presenter implements ZuoY_Yd_Cotract.Presenter {


    private ZuoY_Yd_Cotract.View view;
    private CSModel csModel;

    public ZuoY_YD_presenter(ZuoY_Yd_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }



    @Override
    public void SetUrl(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore) {

        csModel.postZuoY_Yd(stuid, hwid, flag, listen_type, hw_type, hw_content, avgScore, new MyNetWorkCallback<ZuoY_Yd_Bean>() {
            @Override
            public void onSuccess(ZuoY_Yd_Bean zuoYDcBean) {
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
