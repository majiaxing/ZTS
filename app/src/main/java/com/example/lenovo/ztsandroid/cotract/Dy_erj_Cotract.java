package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.DuiH_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.Dy_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Juz_erj_Bean;

/**
 * Created by Administrator on 2018/11/28.
 */

public interface Dy_erj_Cotract {
    //    定义view里面的 方法
    interface View extends BaseView<Dy_erj_Cotract.Presenter> {
        void getManager(Dy_Xq_Bean xqBean);
        void showmessage(String str);
    }
    //    {"jclx":"人教版","nj":"一年级","sxc":"上册","flag":"text"}
    //    presenter 里面需要传递的参数

    interface Presenter extends BasePresenter {

        void setUrl(String flag ,String type,String stuid);

    }
}
