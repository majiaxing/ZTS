package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Bean;

/**
 * Created by Administrator on 2018/11/19.
 */

public interface YB_Cotract {
    //    定义view里面的 方法

    interface View extends BaseView<YB_Cotract.Presenter> {
        void getManager(YB_Bean yb_bean);
        void showmessage(String str);
    }
    //    {"jclx":"人教版","nj":"一年级","sxc":"上册","flag":"text"}

//    {"jclx":"人教版","nj":"一年级","sxc":"上册","flag":"symbol"}
//    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetUrl(String jclx ,String nj ,String sxc ,String flag);

    }


}
