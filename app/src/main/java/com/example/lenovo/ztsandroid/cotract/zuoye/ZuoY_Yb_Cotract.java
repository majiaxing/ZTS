package com.example.lenovo.ztsandroid.cotract.zuoye;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_One_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_Three_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_four_Bean;

/**
 * Created by Administrator on 2018/12/8.
 */

public interface ZuoY_Yb_Cotract {


    interface View extends BaseView<ZuoY_Yb_Cotract.Presenter> {

        void getManagerOne(YB_Zy_One_Bean yb_xq_one_bean);
        void getManagerTwo(YB_Zy_Two_Bean yb_xq_two_bean);
        void getManagerThree(YB_Zy_Three_Bean yb_xq_three_bean);
        void getManagerFour(YB_Zy_four_Bean yb_xq_four_bean);
        void showmessage(String str);
    }

    interface Presenter extends BasePresenter {

        void SetUrl(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore ,String shiliType);

        void SetU(String stuid, String hwid, String flag, String listen_type, String hw_type, String hw_content, String avgScore );
    }

}
