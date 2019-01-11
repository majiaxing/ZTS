package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.SC_YX_Bean;
import com.example.lenovo.ztsandroid.model.entity.Stdey_Bean;
import com.example.lenovo.ztsandroid.model.entity.YuYinPinG_Bean;

import java.io.File;

/**
 * Created by Administrator on 2018/12/11.
 */

public interface YB_TJ_ZhiL_Yuyin_Cotract {


    //    定义view里面的 方法

    interface View extends BaseView<YB_TJ_ZhiL_Yuyin_Cotract.Presenter> {
        void getManager(YuYinPinG_Bean yuYinPinGBean);
        void getManagerO(String pinC_fay_bean);


        void getManagerT(Stdey_Bean xq_bean);
        void getWJSC(SC_YX_Bean sc_yx_bean);

        void showmessage(String str);
    }
    //    presenter 里面需要传递的参数
    interface Presenter extends BasePresenter {

        void setUrlsZhiL(String EvalMode, String RefText, String SessionId, String WorkMode, String ScoreCoeff);

        void seturlZhiL(String SeqId, String IsEnd, String VoiceFileType, String VoiceEncodeType, String UserVoiceData, String SessionId);


        void SetU(String stuid, String yb_wordId, String learn_video, String learn_score);

        void  seturl(File file, String type, String save_path);
    }





}
