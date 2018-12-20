package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_erji_list_Bean;

/**
 * Created by Administrator on 2018/11/20.
 */

public interface Kw_Xq_Cotract {

    interface View extends BaseView<Kw_Xq_Cotract.Presenter> {
        void getManager(Kw_Xq_Bean xq_bean);
        void showmessage(String str);
    }
    //    {"jclx":"人教版","nj":"一年级","sxc":"上册","flag":"text"}
    interface Presenter extends BasePresenter {

        void SetU(String text_id );

    }

}
