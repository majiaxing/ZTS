package com.example.lenovo.ztsandroid.cotract.zuoye;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Dh_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_dy_Bean;

/**
 * Created by Administrator on 2018/12/8.
 */

public interface ZuoY_Dh_Cotract {


    interface View extends BaseView<ZuoY_Dh_Cotract.Presenter> {
        void getManager(ZuoY_Dh_Bean zuoYDyBean);
        void showmessage(String str);
    }

    interface Presenter extends BasePresenter {

        void SetUrl(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore);
    }



}
