package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Read_TJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.Read_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.TiJiao_ZY_Bean;

/**
 * Created by Administrator on 2018/12/29.
 */
public interface TiJao_Cotract {
    //    定义view里面的 方法

    interface View extends BaseView<TiJao_Cotract.Presenter> {
        void getManager(TiJiao_ZY_Bean xqBean);
        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetUrl(String stuid ,String hwid);

    }
}
