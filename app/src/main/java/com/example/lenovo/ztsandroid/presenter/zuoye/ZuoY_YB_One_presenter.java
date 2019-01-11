package com.example.lenovo.ztsandroid.presenter.zuoye;

import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Dc_Cotract;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Yb_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_One_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_dc_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/8.
 */

public class ZuoY_YB_One_presenter implements ZuoY_Yb_Cotract.Presenter {


    private ZuoY_Yb_Cotract.View view;
    private CSModel csModel;

    public ZuoY_YB_One_presenter(ZuoY_Yb_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore ,String shiliType ) {

        csModel.postZuoY_Yb_One(stuid, hwid, flag, listen_type, hw_type, hw_content, avgScore ,shiliType, new MyNetWorkCallback<YB_Zy_One_Bean>() {
            @Override
            public void onSuccess(YB_Zy_One_Bean zuoYDcBean) {
                view.getManagerOne(zuoYDcBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    @Override
    public void SetU(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore) {

        csModel.postZuoY_Yb_One(stuid, hwid, flag, listen_type, hw_type, hw_content, avgScore ,"", new MyNetWorkCallback<YB_Zy_One_Bean>() {
            @Override
            public void onSuccess(YB_Zy_One_Bean zuoYDcBean) {
                view.getManagerOne(zuoYDcBean);
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
