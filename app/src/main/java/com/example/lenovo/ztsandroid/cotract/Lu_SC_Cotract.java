package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.Kw_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.LiY_SC_WJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.SC_YX_Bean;
import com.example.lenovo.ztsandroid.model.entity.YuYinPinG_Bean;

import java.io.File;

/**
 * Created by Administrator on 2018/12/4.
 */

public interface Lu_SC_Cotract {
    //    定义view里面的 方法

    interface View extends BaseView<Lu_SC_Cotract.Presenter> {
        void getManager(LiY_SC_WJ_Bean xq_bean);
        void getWJSC(SC_YX_Bean sc_yx_bean);

        void getManager(YuYinPinG_Bean yuYinPinGBean);
        void getManagerO(String pinC_fay_bean);

        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
    //    {"jclx":"人教版","nj":"一年级","sxc":"上册","flag":"text"}
    interface Presenter extends BasePresenter {

        void SetU(String stuid, String hwid, String hw_type, String hw_content,String hw_answerId,String hw_video, String hw_score ,String everyScore);
        void  seturl(File file, String type, String save_path);


        void setUrlsZhiL(String EvalMode, String RefText, String SessionId, String WorkMode,String ScoreCoeff);

        void seturlZhiL(String SeqId, String IsEnd, String VoiceFileType, String VoiceEncodeType, String UserVoiceData, String SessionId);

    }

}











