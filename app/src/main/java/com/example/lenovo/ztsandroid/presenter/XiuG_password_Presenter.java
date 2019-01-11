package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.WangJ_Cotract;
import com.example.lenovo.ztsandroid.cotract.XiuG_password_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.XiuG_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/10.
 */

public class XiuG_password_Presenter implements XiuG_password_Cotract.Presenter {


    private CSModel sModel;
    private XiuG_password_Cotract.View view;


    public XiuG_password_Presenter(XiuG_password_Cotract.View loginView) {
        view = loginView;
        this.view.setBasePresenter(this);
        sModel  =new CSModelImpl();
    }



    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void setUrl(String stuid, String username, String afterpassword, String password) {

        sModel.postXiuG_password(stuid, username, afterpassword, password, new MyNetWorkCallback<XiuG_Bean>() {
            @Override
            public void onSuccess(XiuG_Bean s) {
                view.getManager(s);
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
