package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.ZhiL_Yuyin_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.PinC_Fay_Bean;
import com.example.lenovo.ztsandroid.model.entity.YuYinPinG_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

import java.io.File;

/**
 * Created by Administrator on 2018/12/11.
 */

public class PinC_Fay_presenter implements ZhiL_Yuyin_Cotract.Presenter {


    private ZhiL_Yuyin_Cotract.View view;
    private CSModel csModel;

    public PinC_Fay_presenter(ZhiL_Yuyin_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


    @Override
    public void start() {

    }


    @Override
    public void setUrlsZhiL(String EvalMode, String RefText, String SessionId, String WorkMode, String ScoreCoeff) {

    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void seturlZhiL(String SeqId, String IsEnd, String VoiceFileType, String VoiceEncodeType, String UserVoiceData, String SessionId) {
        csModel.getFy_PG(SeqId, IsEnd, VoiceFileType, VoiceEncodeType, UserVoiceData, SessionId, new MyNetWorkCallback<String>() {
            @Override
            public void onSuccess(String pinC_fay_bean) {
                view.getManagerO(pinC_fay_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void SetU(String stuid, String word_id, String learn_video, String learn_score, String type) {

    }

    @Override
    public void seturl(File file, String type, String save_path) {

    }
}
