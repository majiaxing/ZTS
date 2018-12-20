package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Lu_SC_Cotract;
import com.example.lenovo.ztsandroid.cotract.TouX_SC_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.LiY_SC_WJ_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

import java.io.File;

/**
 * Created by Administrator on 2018/12/15.
 */

public class Use_Toux_Presenter implements TouX_SC_Cotract.Presenter {


    private CSModel csModel;
    private TouX_SC_Cotract.View view;

    public Use_Toux_Presenter(TouX_SC_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


    @Override
    public void SetU(String student, String stuTupian, String stuid) {

        csModel.postSC_tx(student, stuTupian, stuid, new MyNetWorkCallback<LiY_SC_WJ_Bean>() {
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
    public void start() {

    }
}
