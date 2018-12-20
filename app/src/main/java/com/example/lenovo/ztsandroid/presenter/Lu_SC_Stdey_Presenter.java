package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Lu_SC_Cotract;
import com.example.lenovo.ztsandroid.cotract.Lu_SC_Stdey_Cotract;
import com.example.lenovo.ztsandroid.cotract.ZhiL_Yuyin_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Stdey_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

import java.io.File;

/**
 * Created by Administrator on 2018/12/11.
 */

public class Lu_SC_Stdey_Presenter implements ZhiL_Yuyin_Cotract.Presenter{



    private CSModel csModel;
    private ZhiL_Yuyin_Cotract.View view;

    public Lu_SC_Stdey_Presenter(ZhiL_Yuyin_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


    @Override
    public void setUrlsZhiL(String EvalMode, String RefText, String SessionId, String WorkMode, String ScoreCoeff) {

    }

    @Override
    public void seturlZhiL(String SeqId, String IsEnd, String VoiceFileType, String VoiceEncodeType, String UserVoiceData, String SessionId) {

    }

    @Override
    public void SetU(String stuid, String word_id, String learn_video, String learn_score, String type) {

        csModel.postSC_Lu_StdeyDc(stuid, word_id, learn_video, learn_score, type, new MyNetWorkCallback<Stdey_Bean>() {
            @Override
            public void onSuccess(Stdey_Bean stdey_bean) {
                view.getManagerT(stdey_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });


    }

    @Override
    public void seturl(File file, String type, String save_path) {




    }

    @Override
    public void start() {

    }
}
