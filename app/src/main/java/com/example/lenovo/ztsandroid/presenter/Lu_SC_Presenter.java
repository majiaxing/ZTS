package com.example.lenovo.ztsandroid.presenter;

import android.widget.AdapterView;

import com.example.lenovo.ztsandroid.cotract.Lu_SC_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.LiY_SC_WJ_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

import java.io.File;

/**
 * Created by Administrator on 2018/12/4.
 */

public class Lu_SC_Presenter implements Lu_SC_Cotract.Presenter {

    private CSModel csModel;
    private Lu_SC_Cotract.View view;

    public Lu_SC_Presenter(Lu_SC_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }

    @Override
    public void SetU(String stuid, String hwid, String hw_type, String hw_content, String hw_answerId, String hw_video, String hw_score, String everyScore) {
        csModel.postSC_Lu( stuid,  hwid,  hw_type,  hw_content,  hw_answerId,  hw_video,  hw_score ,everyScore, new MyNetWorkCallback<LiY_SC_WJ_Bean>() {
            @Override
            public void onSuccess(LiY_SC_WJ_Bean liY_sc_wj_bean) {
                view.getManager(liY_sc_wj_bean);
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
    public void setUrlsZhiL(String EvalMode, String RefText, String SessionId, String WorkMode, String ScoreCoeff) {

    }

    @Override
    public void seturlZhiL(String SeqId, String IsEnd, String VoiceFileType, String VoiceEncodeType, String UserVoiceData, String SessionId) {

    }


    @Override
    public void start() {

    }
}
