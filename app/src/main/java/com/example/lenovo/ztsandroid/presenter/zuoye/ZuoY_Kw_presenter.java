package com.example.lenovo.ztsandroid.presenter.zuoye;

import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Dc_Cotract;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Kw_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_dc_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_kw_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZuoY_Kw_presenter implements ZuoY_Kw_Cotract.Presenter {


    private ZuoY_Kw_Cotract.View view;
    private CSModel csModel;

    public ZuoY_Kw_presenter(ZuoY_Kw_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }



    @Override
    public void SetUrl(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore) {

        csModel.postZuoY_Kw(stuid, hwid, flag, listen_type, hw_type, hw_content, avgScore, new MyNetWorkCallback<ZuoY_kw_Bean>() {
            @Override
            public void onSuccess(ZuoY_kw_Bean zuoYKwBean) {
                view.getManager(zuoYKwBean);
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
