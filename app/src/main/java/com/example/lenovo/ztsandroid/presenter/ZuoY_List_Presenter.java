package com.example.lenovo.ztsandroid.presenter;

import com.example.lenovo.ztsandroid.cotract.Zuoy_Cotract;
import com.example.lenovo.ztsandroid.model.biz.CSModel;
import com.example.lenovo.ztsandroid.model.biz.CSModelImpl;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_list_Bean;
import com.example.lenovo.ztsandroid.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2018/11/27.
 */

public class ZuoY_List_Presenter implements Zuoy_Cotract.Presenter {

    private Zuoy_Cotract.View view;
    private CSModel csModel;

    public ZuoY_List_Presenter(Zuoy_Cotract.View view) {
        this.view = view;
        view.setBasePresenter(this);
        csModel = new CSModelImpl();
    }
    //    调用model层数据  把 model层数据传递到view层
    @Override
    public void SetUrl(String stuid) {

        csModel.postZuoY_List(stuid, new MyNetWorkCallback<ZuoY_list_Bean>() {
            @Override
            public void onSuccess(ZuoY_list_Bean listBean) {
                view.getManager(listBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    @Override
    public void SetU(String stuid, String homework_cishu, String flag, String scoreAll) {

    }

    @Override
    public void start() {

    }
}
