package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Juz_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_Xq_Bean;

/**
 * Created by Administrator on 2018/11/21.
 */

public interface Juz_XQ_Cotract {

    //    定义view里面的 方法

    interface View extends BaseView<Juz_XQ_Cotract.Presenter> {
        void getManager(Juz_Xq_Bean xqbean);
        void showmessage(String str);
    }
    //    {"jclx":"人教版","nj":"一年级","sxc":"上册","flag":"text"}//
    //   presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {
        void SetU(String sentence_id );

    }

}
