package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.model.entity.LoginBean;

/**
 * Created by Administrator on 2018/11/14.
 */

public interface Logincotract {

    interface View extends BaseView<Logincotract.Presenter> {
        void getManager(LoginBean loginBean);
        void showmessage(String str);


    }

    interface Presenter extends BasePresenter {

        void SetUrl(String name ,String possward);
    }

}
