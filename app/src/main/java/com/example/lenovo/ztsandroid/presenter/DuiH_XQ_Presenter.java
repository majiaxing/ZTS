package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.DuiH_XQ_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.DuiH_XQ_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/21.
 */

public class DuiH_XQ_Presenter implements DuiH_XQ_Cotract.Presenter{

    private DuiH_XQ_Cotract.View  view;
    private CSModel DuihModel;

    public DuiH_XQ_Presenter(DuiH_XQ_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        DuihModel = new CSModelImpl();
    }

    @Override
    public void SetUrl(String talk_id) {

        DuihModel.postDuiH_XQ(talk_id, new MyNetWorkCallback<DuiH_XQ_Bean>() {
            @Override
            public void onSuccess(DuiH_XQ_Bean duiHXqBean) {
                view.getManager(duiHXqBean);
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
