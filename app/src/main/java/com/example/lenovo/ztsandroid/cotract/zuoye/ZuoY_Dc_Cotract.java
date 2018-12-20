package com.example.lenovo.ztsandroid.cotract.zuoye;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.cotract.CS_YYin_JK_Cotract;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_dc_Bean;

/**
 * Created by Administrator on 2018/12/8.
 */

public interface ZuoY_Dc_Cotract {


    interface View extends BaseView<ZuoY_Dc_Cotract.Presenter> {
        void getManager(ZuoY_dc_Bean zuoYDcBean);
        void showmessage(String str);
    }

    interface Presenter extends BasePresenter {

        void SetUrl(String stuid ,String hwid ,String flag,String listen_type,String hw_type ,String hw_content,String avgScore);
    }



}
