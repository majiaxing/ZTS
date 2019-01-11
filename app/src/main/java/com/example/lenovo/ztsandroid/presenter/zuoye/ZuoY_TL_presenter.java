package com.example.lenovo.ztsandroid.presenter.zuoye;

import com.example.lenovo.ztsandroid.cotract.ZuoY_TingL_XZ_Cotract;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_DY_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_TL_xz_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_dy_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZuoY_TL_presenter implements ZuoY_TingL_XZ_Cotract.Presenter {


    private ZuoY_TingL_XZ_Cotract.View view;
    private CSModel csModel;

    public ZuoY_TL_presenter(ZuoY_TingL_XZ_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore) {

        csModel.postZuoY_TL(stuid, hwid, flag, listen_type, hw_type, hw_content, avgScore, new MyNetWorkCallback<ZuoY_TL_xz_Bean>() {
            @Override
            public void onSuccess(ZuoY_TL_xz_Bean zuoYDcBean) {
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
