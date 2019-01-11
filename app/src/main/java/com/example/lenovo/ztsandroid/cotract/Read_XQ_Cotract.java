package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Read_TJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.Read_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.XX_xq_Bean;

/**
 * Created by Administrator on 2018/11/22.
 */

public interface Read_XQ_Cotract  {

    //    定义view里面的 方法

    interface View extends BaseView<Read_XQ_Cotract.Presenter> {
        void getManager(Read_XQ_Bean xqBean);

        void getRead_Tj(Read_TJ_Bean read_tj_bean);
        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetUrl(String read_Id);

    }

}
