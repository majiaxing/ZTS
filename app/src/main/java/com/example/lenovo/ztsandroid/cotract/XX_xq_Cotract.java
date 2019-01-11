package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.XX_xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_Bean;

/**
 * Created by Administrator on 2018/11/15.
 */

public interface XX_xq_Cotract {
    //    定义view里面的 方法

    interface View extends BaseView<XX_xq_Cotract.Presenter> {
        void getManager(XX_xq_Bean xx_xq_bean);
        void showmessage(String str);


    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetUrl(String Id);

    }



}
