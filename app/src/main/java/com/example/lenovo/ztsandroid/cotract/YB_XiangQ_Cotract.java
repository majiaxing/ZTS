package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.YB_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_three_Bean;

/**
 * Created by Administrator on 2018/11/19.
 */

public interface YB_XiangQ_Cotract {

    //    定义view里面的 方法


    interface View extends BaseView<YB_XiangQ_Cotract.Presenter> {
        void getManager(YB_XQ_four_Bean yb_bean);
        void getManagerO(YB_XQ_one_Bean yb_xq_one_bean);
        void getManagerT(YB_XQ_Two_Bean yb_xq_two_bean);
        void getManagerR(YB_XQ_one_Bean yb_xq_one_bean);
        void getManagerTh(YB_XQ_three_Bean postYinB_XQ_three);





        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetUrl(String ybid ,String flag ,String  shiliType);

        void SetU(String ybid,String flag );
    }

}
