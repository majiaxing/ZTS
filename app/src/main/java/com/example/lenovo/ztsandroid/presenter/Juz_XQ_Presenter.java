package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Juz_XQ_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Juz_Xq_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/21.
 */

public class Juz_XQ_Presenter implements Juz_XQ_Cotract.Presenter {


    private Juz_XQ_Cotract.View view;
    private CSModel jXQModel;

    public Juz_XQ_Presenter(Juz_XQ_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        jXQModel = new CSModelImpl();

    }

    @Override
    public void SetU(String sentence_id) {

        jXQModel.postJuz_Xq(sentence_id, new MyNetWorkCallback<Juz_Xq_Bean>() {
            @Override
            public void onSuccess(Juz_Xq_Bean juz_xq_bean) {
                view.getManager(juz_xq_bean);
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
