package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.DuiH_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.Juz_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_erji_list_Bean;

/**
 * Created by Administrator on 2018/11/20.
 */

public interface Juz_list_Cotract {

    interface View extends BaseView<Juz_list_Cotract.Presenter> {
        void getManager(Juz_erj_Bean erjBean);
        void getManager(DuiH_erj_Bean erjBean);

        void showmessage(String str);
    }
    //    {"jclx":"人教版","nj":"一年级","sxc":"上册","flag":"text"}
    interface Presenter extends BasePresenter {

        void SetU(String flag ,String type);

        void setUrl(String flag ,String type);

    }


}
