package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.model.entity.LoginBean;

/**
 * Created by Administrator on 2018/11/14.
 */

public interface Logincotract {
    //    定义view里面的 方法

    interface View extends BaseView<Logincotract.Presenter> {
        void getManager(LoginBean loginBean);
        void showmessage(String str);


    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetUrl(String name ,String possward ,String usertype_code);
    }

}
