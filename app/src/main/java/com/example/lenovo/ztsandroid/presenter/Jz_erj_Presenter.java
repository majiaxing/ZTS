package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Juz_list_Cotract;
import com.example.lenovo.ztsandroid.cotract.KeW_list_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.Juz_erj_Bean;
import com.example.lenovo.ztsandroid.model.entity.Kw_erji_list_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/20.
 */

public class Jz_erj_Presenter  implements Juz_list_Cotract.Presenter{

    private CSModel totallabelModel;
    private Juz_list_Cotract.View KwView;


    public Jz_erj_Presenter(Juz_list_Cotract.View View) {
        KwView = View;
        this.KwView.setBasePresenter(this);
        totallabelModel  =new CSModelImpl();
    }


    @Override
    public void SetU(String flag, String type) {

        totallabelModel.postJuz_list(flag, type, new MyNetWorkCallback<Juz_erj_Bean>() {
            @Override
            public void onSuccess(Juz_erj_Bean kw_erji_list_bean) {
                KwView.getManager(kw_erji_list_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void setUrl(String flag, String type) {

    }


    @Override
    public void start() {

    }
}
