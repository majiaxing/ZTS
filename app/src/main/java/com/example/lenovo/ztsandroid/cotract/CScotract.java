package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;

/**
 * Created by Lenovo on 2018/10/24.
 */

public interface CScotract {
    //    定义view里面的 方法

    interface View extends BaseView<Presenter>{
        void getManager(CeSBean ceSBean);
        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
     interface Presenter extends BasePresenter{

        void SetUrl(String string);
    }

}
