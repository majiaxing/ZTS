package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.LiY_SC_WJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.SC_YX_Bean;
import com.example.lenovo.ztsandroid.model.entity.Stdey_Bean;

import java.io.File;

/**
 * Created by Administrator on 2018/12/4.
 */

public interface Lu_SC_Stdey_Cotract{

    interface View extends BaseView<Lu_SC_Stdey_Cotract.Presenter> {
        void getManager(Stdey_Bean xq_bean);
        void getWJSC(SC_YX_Bean sc_yx_bean);
        void showmessage(String str);
    }

    //    {"jclx":"人教版","nj":"一年级","sxc":"上册","flag":"text"}
    interface Presenter extends BasePresenter {

        void SetU(String stuid, String word_id, String learn_video, String learn_score, String type);
        void  seturl(File file, String type, String save_path);
    }

}











