package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_Bean;

/**
 * Created by Administrator on 2018/11/15.
 */

public interface XX_Cotract {

    interface View extends BaseView<XX_Cotract.Presenter> {
        void getManager(XiaoX_Bean xiaoX_bean);
        void showmessage(String str);


    }
    interface Presenter extends BasePresenter {

        void SetUrl(String useId,String pageNumber , String pageSize);

    }



}
