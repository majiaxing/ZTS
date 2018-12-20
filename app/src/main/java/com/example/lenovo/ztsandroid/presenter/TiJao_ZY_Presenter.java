package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Lu_SC_Cotract;
import com.example.lenovo.ztsandroid.cotract.TiJiao_ZY_Cotract;
import com.example.lenovo.ztsandroid.cotract.TingL_XQ_xz_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.TiJao_ZY_Bean;
import com.example.lenovo.ztsandroid.model.entity.Xz_Bj_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/6.
 */

public class TiJao_ZY_Presenter implements TiJiao_ZY_Cotract.Presenter {



    private CSModel csModel;
    private TiJiao_ZY_Cotract.View view;

    public TiJao_ZY_Presenter(TiJiao_ZY_Cotract.View view) {
        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }

    @Override
    public void start() {

    }

    @Override
    public void SetU(String stuid, String hwid, ArrayList<Map<String, Object>> mapArrayList) {

        csModel.postTiJao_ZY(stuid, hwid, mapArrayList, new MyNetWorkCallback<TiJao_ZY_Bean>() {
            @Override
            public void onSuccess(TiJao_ZY_Bean xz_bj_bean) {
                view.getManager(xz_bj_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void SetUrl(File file, String type, String save_path) {

    }
}
