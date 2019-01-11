package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Zuoy_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_erJ_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/27.
 */

public class Zuoye_erji_list_Presenter implements Zuoy_Cotract.Presenter {


    private Zuoy_Cotract.View view;
    private CSModel csModel;

    public Zuoye_erji_list_Presenter(Zuoy_Cotract.View view) {

        this.view = view;
        this.view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }


    @Override
    public void start() {

    }

    @Override
    public void SetUrl(String stuid) {

    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetU(String stuid, String homework_cishu, String flag, String scoreAll) {

        csModel.postZuoY_erJ(stuid,homework_cishu,flag,scoreAll, new MyNetWorkCallback<ZuoY_erJ_Bean>() {
            @Override
            public void onSuccess(ZuoY_erJ_Bean erJ_bean) {
                view.getManagZuoY(erJ_bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}
