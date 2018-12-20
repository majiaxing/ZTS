package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Dy_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.WangJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiuG_CG_Bean;

/**
 * Created by Administrator on 2018/12/7.
 */

public interface WangJ_Cotract {


    interface View extends BaseView<WangJ_Cotract.Presenter> {

        void getManager(WangJ_Bean wangJBean);

        void getManagerO(XiuG_CG_Bean string);


//        void getManagerChongz(WangJ_Bean wangJBean);

        void showmessage(String str);
    }
    interface Presenter extends BasePresenter {

        void setUrl(String shoujihao ,String use_type_d);
        void setUrls(String usertype_code,String user_zhanghao,String user_password,String user_yanzhengma,String user_dianhua);
    }

}
