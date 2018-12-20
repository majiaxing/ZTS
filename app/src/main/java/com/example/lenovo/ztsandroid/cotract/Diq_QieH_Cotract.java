package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Dc_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Diq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Diq_Qu_Bean;
import com.example.lenovo.ztsandroid.model.entity.Diq_Shi_Bean;

/**
 * Created by Administrator on 2018/12/4.
 */

public interface Diq_QieH_Cotract {

    interface View extends BaseView<Diq_QieH_Cotract.Presenter> {

        void getManagerSheng(Diq_Bean diqBean);
        void getManagershi(Diq_Shi_Bean diqBean);
        void getManagerqu(Diq_Qu_Bean diqBean);
        void getManager(Diq_Bean diqBean);
        void showmessage(String str);
    }

    interface Presenter extends BasePresenter {

        void SetUrl(String sheng_id);
        void SetU(String shi_id );
    }


}
