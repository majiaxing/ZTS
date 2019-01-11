package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.WangJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiuG_Bean;

/**
 * Created by Administrator on 2018/12/10.
 */

public interface XiuG_password_Cotract {
    //    定义view里面的 方法

    interface View extends BaseView<XiuG_password_Cotract.Presenter> {

        void getManager(XiuG_Bean xiuGBean);

        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void setUrl(String stuid ,String username,String afterpassword,String password);

    }


}
