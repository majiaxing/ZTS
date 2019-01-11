package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.TingL_XQ_xz_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.TingL_XQ_xz_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/22.
 */

public class TingL_Xq_xz_Presenter implements TingL_XQ_xz_Cotract.Presenter{


    private TingL_XQ_xz_Cotract.View view;
    private CSModel csModel;

    public TingL_Xq_xz_Presenter(TingL_XQ_xz_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetU(String listen_id) {
        csModel.postTingL_XQ_xz(listen_id, new MyNetWorkCallback<TingL_XQ_xz_Bean>() {
            @Override
            public void onSuccess(TingL_XQ_xz_Bean tingL_xq_xz_bean) {
                view.getManager(tingL_xq_xz_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    @Override
    public void SetUrl(String listen_id, String type, String stuid, String listen_type, String listen_questId, String learn_video, String learn_score) {

    }

    @Override
    public void start() {

    }
}
