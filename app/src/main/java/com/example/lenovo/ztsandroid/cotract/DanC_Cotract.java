package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Dc_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.JiaoC_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_content_Bean;

/**
 * Created by Administrator on 2018/11/20.
 */

public interface DanC_Cotract {
    //    定义view里面的 方法
    interface View extends BaseView<DanC_Cotract.Presenter> {

        void getManager(Dc_Xq_Bean dcXqBean);
        void showmessage(String str);
    }
//    presenter 里面需要传递的参数

    interface Presenter extends BasePresenter {

        void SetUrl(String flag,String type);


    }

}
