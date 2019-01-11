package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.TiLi_BaoC_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_TK_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_XQ_xz_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_erj_Bean;

/**
 * Created by Administrator on 2018/11/22.
 */

public interface TingL_XQ_xz_Cotract {

    //    定义view里面的 方法
    interface View extends BaseView<TingL_XQ_xz_Cotract.Presenter> {
        void getManager(TingL_XQ_xz_Bean xqbean);
        void getManager(TingL_TK_Bean xqbean);
        void getManagerTiJ(TiLi_BaoC_Bean tiLi_baoC_bean);
        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetU(String listen_id);

        void SetUrl(String listen_id ,String type ,String stuid , String listen_type,String listen_questId,String learn_video,String learn_score);

    }


}
