package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.TiJiao_ZY_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.DWj_SC_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/6.
 */

public class DuoWJ_SC_Presenter implements TiJiao_ZY_Cotract.Presenter {



    private CSModel csModel;
    private TiJiao_ZY_Cotract.View view;

    public DuoWJ_SC_Presenter(TiJiao_ZY_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


    @Override
    public void SetU(String stuid, String hwid, ArrayList<Map<String, Object>> mapArrayList) {

    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(File file, String type, String save_path) {
        csModel.postTiJiao_File(file, type, save_path, new MyNetWorkCallback<DWj_SC_Bean>() {
            @Override
            public void onSuccess(DWj_SC_Bean sc_bean) {
                view.getD_ShangC(sc_bean);
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
