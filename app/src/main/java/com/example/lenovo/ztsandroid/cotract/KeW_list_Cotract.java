package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_erji_list_Bean;

/**
 * Created by Administrator on 2018/11/14.
 */

public interface KeW_list_Cotract {

    interface View extends BaseView<KeW_list_Cotract.Presenter> {
        void getManager(Kw_Bean kw_bean);
        void getKw_erjlist(Kw_erji_list_Bean kw_erji_list_bean);
        void showmessage(String str);
    }
//    {"jclx":"人教版","nj":"一年级","sxc":"上册","flag":"text"}
    interface Presenter extends BasePresenter {

        void SetUrl(String jclx ,String nj ,String sxc ,String flag ,String listen_type,String stuid);
        void SetU(String flag ,String type);

    }

}
