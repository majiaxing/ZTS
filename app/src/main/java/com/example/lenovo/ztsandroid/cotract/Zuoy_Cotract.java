package com.example.lenovo.ztsandroid.cotract;

import android.view.View;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_erJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_list_Bean;

/**
 * Created by Administrator on 2018/11/27.
 */

public interface Zuoy_Cotract {

    interface View extends BaseView<Zuoy_Cotract.Presenter> {
        void getManager(ZuoY_list_Bean listBean);
        void getManagZuoY(ZuoY_erJ_Bean erJ_bean);
        void showmessage(String str);
    }

    interface Presenter extends BasePresenter {

        void SetUrl(String stuid);

        void SetU(String stuid,String homework_cishu,String flag ,String scoreAll);

    }


}
