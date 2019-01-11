package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Yd_Cotract;
import com.example.lenovo.ztsandroid.model.entity.SC_YX_Bean;
import com.example.lenovo.ztsandroid.model.entity.Stdey_Bean;
import com.example.lenovo.ztsandroid.model.entity.YuYinPinG_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_TL_xz_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Yd_Bean;

import java.io.File;

/**
 * Created by Administrator on 2018/12/11.
 */

public interface ZuoY_TingL_XZ_Cotract {


    //    定义view里面的 方法

    interface View extends BaseView<ZuoY_TingL_XZ_Cotract.Presenter> {
        void getManager(ZuoY_TL_xz_Bean zuoYDcBean);
        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetUrl(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore);
    }







}
