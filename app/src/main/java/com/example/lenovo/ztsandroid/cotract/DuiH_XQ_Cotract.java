package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.DuiH_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.XX_xq_Bean;

/**
 * Created by Administrator on 2018/11/21.
 */

public interface DuiH_XQ_Cotract {
    //    定义view里面的 方法

    interface View extends BaseView<DuiH_XQ_Cotract.Presenter> {
        void getManager(DuiH_XQ_Bean duiHXqBean);
        void showmessage(String str);


    }

    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetUrl(String talk_id);

    }



}
