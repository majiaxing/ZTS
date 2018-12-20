package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Juz_list_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.DuiH_erj_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/21.
 */

public class DuiH_erj_Presenter implements Juz_list_Cotract.Presenter {



    private CSModel totallabelModel;
    private Juz_list_Cotract.View KwView;


    public DuiH_erj_Presenter(Juz_list_Cotract.View View) {
        KwView = View;
        this.KwView.setBasePresenter(this);
        totallabelModel  =new CSModelImpl();
    }




    @Override
    public void SetU(String flag, String type) {

    }

    @Override
    public void setUrl(String flag, String type) {

        totallabelModel.postDuiH_er_list(flag, type, new MyNetWorkCallback<DuiH_erj_Bean>() {
            @Override
            public void onSuccess(DuiH_erj_Bean duiH_erj_bean) {
                KwView.getManager(duiH_erj_bean);
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
