package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.BanJBean;
import com.example.lenovo.ztsandroid.model.entity.DuiH_XQ_Bean;
import com.example.lenovo.ztsandroid.model.entity.Xz_Bj_Bean;

/**
 * Created by Administrator on 2018/11/21.
 */

public interface JaR_Bj_Cotract {


    interface View extends BaseView<JaR_Bj_Cotract.Presenter> {
        void getManager(BanJBean duiHXqBean);
        void getManagerO(Xz_Bj_Bean str);
        void showmessage(String str);


    }
    interface Presenter extends BasePresenter {

        void SetUrl(String stuid,String infor);

    }



}
