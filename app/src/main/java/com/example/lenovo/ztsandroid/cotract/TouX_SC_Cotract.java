package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.LiY_SC_WJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.SC_YX_Bean;

import java.io.File;

/**
 * Created by Administrator on 2018/12/4.
 */

public interface TouX_SC_Cotract {

    //    定义view里面的 方法

    interface View extends BaseView<TouX_SC_Cotract.Presenter> {
        void getManager(LiY_SC_WJ_Bean xq_bean);
        void getWJSC(SC_YX_Bean sc_yx_bean);
        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
    //    {"jclx":"人教版","nj":"一年级","sxc":"上册","flag":"text"}
    interface Presenter extends BasePresenter {

        void SetU(String student, String stuTupian,String stuid);
        void  seturl(File file, String type, String save_path);
    }

}











