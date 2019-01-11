package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.DuiH_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Xq_Bean;

/**
 * Created by Administrator on 2018/11/27.
 */

public interface Zy_Xq_Cotract {

    //    定义view里面的 方法


    interface View extends BaseView<Zy_Xq_Cotract.Presenter> {
        void getManager(ZuoY_Xq_Bean zuoYXqBean);
        void showmessage(String str);

    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetUrl(String stuid, String hwid ,String flag);

    }



}
