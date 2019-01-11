package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.DWj_SC_Bean;
import com.example.lenovo.ztsandroid.model.entity.TiJ_Vip_Bean;
import com.example.lenovo.ztsandroid.model.entity.TiJao_ZY_Bean;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/7.
 */

public interface TiJ_Vip_Cotract {

    //    定义view里面的 方法
    interface View extends BaseView<TiJ_Vip_Cotract.Presenter> {
        void getManager(TiJ_Vip_Bean xqbean);
        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetUrl(String stuid , String cardName, String cardPassword);

    }


}
