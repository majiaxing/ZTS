package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.TiJiao_ZY_Cotract;
import com.example.lenovo.ztsandroid.cotract.TingL_XQ_xz_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.TiLi_BaoC_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/12/26.
 */

public class TiL_BaoC_Presenter implements TingL_XQ_xz_Cotract.Presenter {


    private CSModel csModel;
    private TingL_XQ_xz_Cotract.View view;

    public TiL_BaoC_Presenter(TingL_XQ_xz_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


    @Override
    public void SetU(String listen_id) {

    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String listen_id, String type, String stuid, String listen_type, String listen_questId, String learn_video, String learn_score) {

        csModel.postTiJ_TinL(listen_id, type, stuid, listen_type, listen_questId, learn_video, learn_score, new MyNetWorkCallback<TiLi_BaoC_Bean>() {
            @Override
            public void onSuccess(TiLi_BaoC_Bean tiLi_baoC_bean) {
                view.getManagerTiJ(tiLi_baoC_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    @Override
    public void start() {

    }
}
