package com.example.lenovo.ztsandroid.presenter.zuoye;

import com.example.lenovo.ztsandroid.model.entity.YB_Zy_four_Bean;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Yb_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZuoY_YB_Four_presenter implements ZuoY_Yb_Cotract.Presenter {


    private ZuoY_Yb_Cotract.View view;
    private CSModel csModel;

    public ZuoY_YB_Four_presenter(ZuoY_Yb_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


    @Override
    public void start() {

    }

    @Override
    public void SetUrl(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore, String shiliType) {

        csModel.postZuoY_Yb_Four(stuid, hwid, flag, listen_type, hw_type, hw_content, avgScore, new MyNetWorkCallback<YB_Zy_four_Bean>() {
            @Override
            public void onSuccess(YB_Zy_four_Bean zuoYDcBean) {
                view.getManagerFour(zuoYDcBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void SetU(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore) {

    }
}
