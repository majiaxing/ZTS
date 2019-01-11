package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Juz_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_erj_Bean;

/**
 * Created by Administrator on 2018/11/21.
 */

public interface TingL_erj_Cotract {

    //    定义view里面的 方法


    interface View extends BaseView<TingL_erj_Cotract.Presenter> {
        void getManager(TingL_erj_Bean xqbean);
        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
    //    {"jclx":"人教版","nj":"一年级","sxc":"上册","flag":"text"}
    interface Presenter extends BasePresenter {

        void SetU(String flag ,String type ,String listen_type);

    }


}
