package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.KeW_list_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Kw_erji_list_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/20.
 */

public class Kw_erji_Presenter implements KeW_list_Cotract.Presenter {

    private CSModel totallabelModel;
    private KeW_list_Cotract.View KwView;


    public Kw_erji_Presenter(KeW_list_Cotract.View View) {
        KwView = View;
        this.KwView.setBasePresenter(this);
        totallabelModel  =new CSModelImpl();
    }





    @Override
    public void start() {

    }

    @Override
    public void SetUrl(String jclx, String nj, String sxc, String flag, String listen_type, String stuid) {

    }

    @Override
    public void SetU(String flag, String type) {

        totallabelModel.postKwerjList(flag, type, new MyNetWorkCallback<Kw_erji_list_Bean>() {
            @Override
            public void onSuccess(Kw_erji_list_Bean kw_erji_list_bean) {
                KwView.getKw_erjlist(kw_erji_list_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }



}
