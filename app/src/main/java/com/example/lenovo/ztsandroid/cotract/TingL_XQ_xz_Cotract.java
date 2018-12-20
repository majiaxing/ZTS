package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.TingL_TK_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_XQ_xz_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_erj_Bean;

/**
 * Created by Administrator on 2018/11/22.
 */

public interface TingL_XQ_xz_Cotract {




    interface View extends BaseView<TingL_XQ_xz_Cotract.Presenter> {
        void getManager(TingL_XQ_xz_Bean xqbean);
        void getManager(TingL_TK_Bean xqbean);
        void showmessage(String str);
    }
    interface Presenter extends BasePresenter {

        void SetU(String listen_id);

    }


}
