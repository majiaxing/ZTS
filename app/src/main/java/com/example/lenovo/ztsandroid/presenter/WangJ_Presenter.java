package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.WangJ_Cotract;
import com.example.lenovo.ztsandroid.cotract.YB_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.WangJ_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/7.
 */

public class WangJ_Presenter implements WangJ_Cotract.Presenter {


    private CSModel totallabelModel;
    private WangJ_Cotract.View view;


    public WangJ_Presenter(WangJ_Cotract.View loginView) {
        view = loginView;
        this.view.setBasePresenter(this);
        totallabelModel  =new CSModelImpl();
    }

    @Override
    public void setUrl(String shoujihao, String use_type_d) {
    totallabelModel.postWangJ(shoujihao, use_type_d, new MyNetWorkCallback<WangJ_Bean>() {
        @Override
        public void onSuccess(WangJ_Bean wangJBean) {
            view.getManager(wangJBean);
        }

        @Override
        public void onError(int errorCode, String errorMsg) {

        }
    });
    }

    @Override
    public void setUrls(String usertype_code, String user_zhanghao, String user_password, String user_yanzhengma, String user_dianhua) {

    }


    @Override
    public void start() {

    }
}
