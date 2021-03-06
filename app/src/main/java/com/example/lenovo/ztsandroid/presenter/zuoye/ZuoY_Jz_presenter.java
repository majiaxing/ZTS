package com.example.lenovo.ztsandroid.presenter.zuoye;

import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Dc_Cotract;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Jz_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Jz_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_dc_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZuoY_Jz_presenter implements ZuoY_Jz_Cotract.Presenter {


    private ZuoY_Jz_Cotract.View view;
    private CSModel csModel;

    public ZuoY_Jz_presenter(ZuoY_Jz_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore) {

        csModel.postZuoY_Jz(stuid, hwid, flag, listen_type, hw_type, hw_content, avgScore, new MyNetWorkCallback<ZuoY_Jz_Bean>() {
            @Override
            public void onSuccess(ZuoY_Jz_Bean zuoYDcBean) {
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
