package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Read_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_erj_Bean;

/**
 * Created by Administrator on 2018/11/22.
 */

public interface Read_erj_Cotract {

    //    定义view里面的 方法

    interface View extends BaseView<Read_erj_Cotract.Presenter> {
        void getManager(Read_erj_Bean xqbean);
        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetU(String flag ,String type );

    }



}
