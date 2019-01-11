package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Delete_XX_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiaoX_Bean;

/**
 * Created by Administrator on 2018/11/15.
 */

public interface XX_Cotract {
    //    定义view里面的 方法

    interface View extends BaseView<XX_Cotract.Presenter> {
        void getManager(XiaoX_Bean xiaoX_bean);

        void getManagerDelete(Delete_XX_Bean delete_xx_bean);

        void showmessage(String str);


    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void SetUrl(String useId,String pageNumber , String pageSize);

        void SetU(String json);

    }



}
