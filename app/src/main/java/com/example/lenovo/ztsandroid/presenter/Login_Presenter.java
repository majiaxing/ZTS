package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Logincotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.LoginBean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;
import com.example.lenovo.ztsandroid.utils.MyLog;

/**
 * Created by Administrator on 2018/11/14.
 */

public class Login_Presenter implements Logincotract.Presenter {

    private CSModel totallabelModel;
    private Logincotract.View LoginView;

    public Login_Presenter(Logincotract.View loginView) {
        LoginView = loginView;
        this.LoginView.setBasePresenter(this);
        totallabelModel = new CSModelImpl();

    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String name, String possward ,String usertype_code) {

        totallabelModel.postLogin(name, possward ,usertype_code, new MyNetWorkCallback<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                LoginView.getManager(loginBean);
                MyLog.e("TAG",loginBean.toString());
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                LoginView.showmessage(errorMsg);
            }
        });

    }

    @Override
    public void start() {

    }
}
