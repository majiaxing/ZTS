package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.DWj_SC_Bean;
import com.example.lenovo.ztsandroid.model.entity.Read_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.TiJao_ZY_Bean;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/6.
 */

public interface TiJiao_ZY_Cotract {


    interface View extends BaseView<TiJiao_ZY_Cotract.Presenter> {
        void getManager(TiJao_ZY_Bean xqbean);

        void getD_ShangC(DWj_SC_Bean sc_bean);
        void showmessage(String str);
    }

    interface Presenter extends BasePresenter {

        void SetU(String stuid, String hwid, ArrayList<Map<String,Object>> mapArrayList);

        void SetUrl(File file ,String type, String save_path);

    }


}
