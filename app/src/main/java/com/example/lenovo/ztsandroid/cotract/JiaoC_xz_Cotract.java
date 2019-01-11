package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.CeSBean;
import com.example.lenovo.ztsandroid.model.entity.JiaoC_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_content_Bean;

/**
 * Created by Administrator on 2018/11/14.
 */

public interface JiaoC_xz_Cotract {
    //    定义view里面的 方法
    interface View extends BaseView<JiaoC_xz_Cotract.Presenter> {
        void getManager(JiaoC_Bean ceSBean);
        void getXiaoXContent(XiaoX_content_Bean xiaoX_content_bean);

        void showmessage(String str);
    }
//    presenter 里面需要传递的参数

    interface Presenter extends BasePresenter {

        void SetUrl(String string);


    }

}
