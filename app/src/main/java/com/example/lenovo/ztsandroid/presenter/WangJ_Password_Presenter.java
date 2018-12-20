package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.WangJ_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.WangJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiuG_CG_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/10.
 */

public class WangJ_Password_Presenter implements WangJ_Cotract.Presenter{



    private CSModel totallabelModel;
    private WangJ_Cotract.View view;


    public WangJ_Password_Presenter(WangJ_Cotract.View loginView) {
        view = loginView;
        this.view.setBasePresenter(this);
        totallabelModel  =new CSModelImpl();
    }

    @Override
    public void setUrl(String shoujihao, String use_type_d) {

    }

    @Override
    public void setUrls(String usertype_code, String user_zhanghao, String user_password, String user_yanzhengma, String user_dianhua) {
        totallabelModel.postWangJ_TJ(usertype_code, user_zhanghao, user_password, user_yanzhengma, user_dianhua, new MyNetWorkCallback<XiuG_CG_Bean>() {
            @Override
            public void onSuccess(XiuG_CG_Bean s) {
                view.getManagerO(s);
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
