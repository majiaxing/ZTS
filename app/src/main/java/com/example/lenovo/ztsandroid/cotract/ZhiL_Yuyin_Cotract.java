package com.example.lenovo.ztsandroid.cotract;

import com.example.lenovo.ztsandroid.base.BasePresenter;
import com.example.lenovo.ztsandroid.base.BaseView;
import com.example.lenovo.ztsandroid.model.entity.PinC_Fay_Bean;
import com.example.lenovo.ztsandroid.model.entity.SC_YX_Bean;
import com.example.lenovo.ztsandroid.model.entity.Stdey_Bean;
import com.example.lenovo.ztsandroid.model.entity.YuYinPinG_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_erJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_list_Bean;

import java.io.File;

/**
 * Created by Administrator on 2018/12/11.
 */

public interface ZhiL_Yuyin_Cotract {



    interface View extends BaseView<ZhiL_Yuyin_Cotract.Presenter> {
        void getManager(YuYinPinG_Bean yuYinPinGBean);
        void getManagerO(String pinC_fay_bean);


        void getManagerT(Stdey_Bean xq_bean);
        void getWJSC(SC_YX_Bean sc_yx_bean);

        void showmessage(String str);
    }

    interface Presenter extends BasePresenter {

        void setUrlsZhiL(String EvalMode, String RefText, String SessionId, String WorkMode,String ScoreCoeff);

        void seturlZhiL(String SeqId, String IsEnd, String VoiceFileType, String VoiceEncodeType, String UserVoiceData, String SessionId);


        void SetU(String stuid, String word_id, String learn_video, String learn_score, String type);

        void  seturl(File file, String type, String save_path);
    }





}
